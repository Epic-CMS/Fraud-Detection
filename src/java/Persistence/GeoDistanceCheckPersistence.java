/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Bean.GeoDistanceCheckBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lakmal_j
 */
public class GeoDistanceCheckPersistence {

    private ResultSet rs = null;
    private List<GeoDistanceCheckBean> tranList = null;
    private List<GeoDistanceCheckBean> tranListf = null;

    public List<GeoDistanceCheckBean> getGeoCheckTrans(String PAN, Connection con) throws Exception {

        PreparedStatement ps = null;

        try {

            ps = con.prepareStatement("Select * from TBLISO where F2_PAN = ? ORDER BY F7_TRANSMISSION_DATETIME ASC");
            ps.setString(1, PAN);
            rs = ps.executeQuery();

            tranList = new ArrayList<>();

            int i = 0;
            while (rs.next()) {
                GeoDistanceCheckBean bean = new GeoDistanceCheckBean();
                bean.setMSGIN_ID(rs.getString("MSGIN_ID"));
                bean.setF2_PAN(rs.getString("F2_PAN"));

                String F7_TRANSMISSION_DATETIME = rs.getString("F7_TRANSMISSION_DATETIME");
                bean.setF7_TRANSMISSION_DATETIME(F7_TRANSMISSION_DATETIME.split("(?<=\\G.{2})"));
                bean.setF43_CARD_ACCCEPT_NAME(rs.getString("F43_CARD_ACCCEPT_NAME"));

                tranList.add(bean);

                i++;
            }
            if(i>1){
                List<GeoDistanceCheckBean> lastTrans = tranList.subList(tranList.size() - 2, tranList.size());
                return lastTrans;
            }
                return tranList;

        } catch (Exception ex) {

            throw ex;
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (Exception e) {
            }
        }

    }

    public String getFinalTran(Connection con) throws Exception {

        PreparedStatement ps = null;

        try {

            ps = con.prepareStatement("Select * from TBLISO ORDER BY F7_TRANSMISSION_DATETIME ASC");

            rs = ps.executeQuery();
            
            tranListf = new ArrayList<>();

            int i = 0;
            while (rs.next()) {
                GeoDistanceCheckBean bean = new GeoDistanceCheckBean();

                bean.setF2_PAN(rs.getString("F2_PAN"));

                tranListf.add(bean);

                i++;
            }
            List<GeoDistanceCheckBean> lastTran = tranListf.subList(tranListf.size() - 1, tranListf.size());
            String LastTranPAN = lastTran.get(0).getF2_PAN();

            return LastTranPAN;

        } catch (Exception ex) {

            throw ex;
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (Exception e) {
            }
        }

    }
}
