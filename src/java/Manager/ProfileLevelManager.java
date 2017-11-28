/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Bean.ProfileLevelBean;
import DBConnection.DBConnection;
import Persistence.ProfileLevelPersistence;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author dilumka_g
 */
public class ProfileLevelManager {
    private Connection con;
    int x;
    
    public int addProfile(ProfileLevelBean bean) throws SQLException {
        ProfileLevelPersistence persistence;
        
        try {
            con = DBConnection.getConnection();
            persistence = new ProfileLevelPersistence();
            x=persistence.addProfile(con,bean);
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
