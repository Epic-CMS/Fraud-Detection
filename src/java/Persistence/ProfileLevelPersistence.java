/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Bean.ProfileLevelBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dilumka_g
 */
public class ProfileLevelPersistence {
    
    PreparedStatement pst=null;
    ResultSet rs = null;
    private List<ProfileLevelBean> levelList = null;
    
    int x;
    
    public int addProfile(Connection con, ProfileLevelBean bean) throws SQLException {
        
        try{
            pst = con.prepareStatement("Insert into PROFILE_LEVELS values(?,?,?)");
            pst.setInt(1, bean.getLEVEL_NAME());
            pst.setInt(2, bean.getLEVEL_FROM());
            pst.setInt(3,bean.getLEVEL_TO());
            
            x = pst.executeUpdate();
            
            return  x;
        } catch (Exception ex) {
            throw ex;
        } finally {
            try {
                pst.close();
            } catch (Exception e) {
                
            }
        }
       
    }

    public List<ProfileLevelBean> getProfileLevelList(Connection con) throws Exception {
 
        try {

            String query = "Select * from PROFILE_LEVELS";

            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            levelList = new ArrayList<>();
            
            
            while (rs.next()) {
                ProfileLevelBean bean = new ProfileLevelBean();

                bean.setLEVEL_NAME(rs.getInt("LEVEL_NAME"));
                bean.setLEVEL_FROM(rs.getInt("LEVEL_FROM"));
                bean.setLEVEL_TO(rs.getInt("LEVEL_TO"));
               
                levelList.add(bean);
                
            }
            return levelList;
            
        } catch (Exception ex) {

            throw ex;
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                
            }
        }
    }

   
    public int deleteProfile(Connection con, int id1) throws Exception {
        try{
            pst = con.prepareStatement("Delete from PROFILE_LEVELS where LEVEL_NAME = ?");
            pst.setInt(1, id1);
            x = pst.executeUpdate();
            
            return  x;
        } catch (Exception ex) {
            throw ex;
        } finally {
            try {
                pst.close();
            } catch (Exception e) {
                
            }
        } 
    }

    public int updateProfile(Connection con, ProfileLevelBean bean) throws Exception {
        try{
            pst = con.prepareStatement("update PROFILE_LEVELS set LEVEL_FROM = ?,LEVEL_TO= ?  where LEVEL_NAME = ?");
            
            pst.setInt(1, bean.getLEVEL_FROM());
            pst.setInt(2,bean.getLEVEL_TO());
            pst.setInt(3, bean.getLEVEL_NAME());
            
            x = pst.executeUpdate();
            
            return  x;
        } catch (Exception ex) {
            throw ex;
        } finally {
            try {
                pst.close();
            } catch (Exception e) {
                
            }
        } 
    }
}
