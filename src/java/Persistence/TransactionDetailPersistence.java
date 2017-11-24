/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistence;

import Bean.TransactionDetailBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lakmal_j
 */
public class TransactionDetailPersistence {
     private ResultSet rs = null;
     private List<TransactionDetailBean> tranList = null;

    public TransactionDetailBean getTransactionDetails(Connection con, String PAN) throws Exception {
        
        PreparedStatement ps = null;
        TransactionDetailBean bean = new TransactionDetailBean();

        try {

          
            String quary = "Select * from TBLISO";

            ps = con.prepareStatement(quary);

            rs = ps.executeQuery();

            while (rs.next()) {
                

                bean.setF2_PAN(rs.getString("F2_PAN"));
                
                
            }
        } catch (Exception ex) {

            throw ex;
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (Exception e) {
            }
        }

        return bean;
    }
    
    public List<TransactionDetailBean> getTransactionList(Connection con) throws Exception {
        
        PreparedStatement ps = null;
        

        try {

            String quary = "Select * from TBLISO";

            ps = con.prepareStatement(quary);
            rs = ps.executeQuery();
            tranList = new ArrayList<>();
            
            int i = 0;
            while (rs.next()) {
                TransactionDetailBean bean = new TransactionDetailBean();

                bean.setF2_PAN(rs.getString("F2_PAN"));
                bean.setF4_AMOUNT_TRANS(rs.getString("F4_AMOUNT_TRANS"));
                bean.setF12_LOCAL_TIME(rs.getString("F12_LOCAL_TIME"));
                bean.setF13_LOCAL_DATE(rs.getString("F13_LOCAL_DATE"));
                bean.setF18_MERCHANT_TYPE(rs.getString("F18_MERCHANT_TYPE"));
                bean.setF14_DATE_EXPIRATION(rs.getString("F14_DATE_EXPIRATION"));
                bean.setF11_SYSTEM_TRACE(rs.getString("F11_SYSTEM_TRACE"));
                bean.setF41_CARD_ACCEPT_TERM_IDEN(rs.getString("F41_CARD_ACCEPT_TERM_IDEN"));
                bean.setF42_CARD_ACCEPT_IDEN_CODE(rs.getString("F42_CARD_ACCEPT_IDEN_CODE"));
                bean.setF43_CARD_ACCCEPT_NAME(rs.getString("F43_CARD_ACCCEPT_NAME"));
                bean.setF49_CURRENCY_CODE_TRANS(rs.getString("F49_CURRENCY_CODE_TRANS"));
                tranList.add(bean);
                i++; 
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

}
