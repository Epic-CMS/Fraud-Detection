/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Bean.GeoDistanceCheckBean;
import Bean.ProfileLevelBean;
import Bean.TransactionDetailBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lakmal_j
 */
public class UserLevelAssignPersistence {

    private ResultSet rs = null;
    private List<TransactionDetailBean> tranList = null;
    //private List<GeoDistanceCheckBean> tranListf = null;
    private PreparedStatement psinsert;
    private PreparedStatement psselect;

    public List<TransactionDetailBean> getTranAmounts(String PAN, Connection con) throws Exception {

        PreparedStatement ps = null;

        try {

            ps = con.prepareStatement("Select * from TBLISO where F2_PAN = ? ORDER BY F7_TRANSMISSION_DATETIME ASC");
            ps.setString(1, PAN);
            rs = ps.executeQuery();

            tranList = new ArrayList<>();

            int i = 0;
            while (rs.next()) {
                TransactionDetailBean bean = new TransactionDetailBean();

                bean.setF2_PAN(rs.getString("F2_PAN"));

                bean.setF7_TRANSMISSION_DATETIME(rs.getString("F7_TRANSMISSION_DATETIME"));

                bean.setF4_AMOUNT_TRANS(rs.getString("F4_AMOUNT_TRANS"));

                tranList.add(bean);

                i++;
            }
            if (i > 10) {
                List<TransactionDetailBean> lastTrans = tranList.subList(tranList.size() - 10, tranList.size());
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

    int x, exist;

    public int assignlevel(Connection con, String PAN, String Level) throws SQLException {

        try {
            psselect = con.prepareStatement("select * from USER_ASSIGN_LEVELS where PAN = ?");
            psselect.setString(1, PAN);
            exist = psselect.executeUpdate();
            
            if (exist == 0) {
                psinsert = con.prepareStatement("Insert into USER_ASSIGN_LEVELS values(?,?)");
                psinsert.setString(1, PAN);
                psinsert.setString(2, Level);

                x = psinsert.executeUpdate();
            }else{
                psinsert = con.prepareStatement("update USER_ASSIGN_LEVELS set PROFILE_LEVEL= ? where PAN = ?");
                psinsert.setString(1, Level);
                psinsert.setString(2, PAN);
                x = psinsert.executeUpdate();
            }
            
            return x;
        } catch (Exception ex) {
            throw ex;
        } finally {
            try {
                psinsert.close();
                psselect.close();
            } catch (Exception e) {

            }
        }

    }
}
