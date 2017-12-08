/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Manager;

import Bean.ProfileLevelBean;
import Bean.TransactionDetailBean;
import DBConnection.DBConnection;
import Persistence.ProfileLevelPersistence;
import Persistence.UserLevelAssignPersistence;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lakmal_j
 */
public class UserLevelAssignManager {
   private Connection con;
   int x;
    
     public List<TransactionDetailBean> getTranAmounts(String PAN) throws Exception {
        List<TransactionDetailBean> beanList;
        UserLevelAssignPersistence persistence;
        
        
        try {
            con = DBConnection.getConnection();
            persistence = new UserLevelAssignPersistence();
            con.setAutoCommit(true);
            beanList = persistence.getTranAmounts(PAN, con);
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
     public int assignlevel(String PAN, String Level) throws SQLException {
        UserLevelAssignPersistence persistence;
        
        try {
            con = DBConnection.getConnection();
            persistence = new UserLevelAssignPersistence();
            x = persistence.assignlevel(con, PAN, Level);
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
        return x;
    }
}
