/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Manager;

import Bean.GeoDistanceCheckBean;
import DBConnection.DBConnection;
import Persistence.GeoDistanceCheckPersistence;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lakmal_j
 */
public class GeoDistanceCheckManager {
    
    private Connection con;
    
     public List<GeoDistanceCheckBean> getGeoCheckTrans(String PAN) throws Exception {
        List<GeoDistanceCheckBean> beanList;
        GeoDistanceCheckPersistence persistence;
        
        
        try {
            con = DBConnection.getConnection();
            persistence = new GeoDistanceCheckPersistence();
            con.setAutoCommit(true);
            beanList = persistence.getGeoCheckTrans(PAN, con);
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw e;
                }
            }
        }
        return beanList;
    }
     
    public String getFinalTran() throws Exception {
        String LastTranPAN;
        GeoDistanceCheckPersistence persistence;
        
        
        try {
            con = DBConnection.getConnection();
            persistence = new GeoDistanceCheckPersistence();
            con.setAutoCommit(true);
            LastTranPAN = persistence.getFinalTran(con);
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw e;
                }
            }
        }
        return LastTranPAN;
    }
}
