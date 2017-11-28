/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Bean.ProfileLevelBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dilumka_g
 */
public class ProfileLevelPersistence {
    
    PreparedStatement pst=null;
    int x;
    
    public int addProfile(Connection con, ProfileLevelBean bean) throws SQLException {
        
            pst = con.prepareStatement("Insert into PROFILE_LEVELS values(?,?,?)");
            pst.setInt(1, bean.getLEVEL_NAME());
            pst.setInt(2, bean.getLEVEL_FROM());
            pst.setInt(3,bean.getLEVEL_TO());
            
            x = pst.executeUpdate();
            
            return  x;
       
    }
}
