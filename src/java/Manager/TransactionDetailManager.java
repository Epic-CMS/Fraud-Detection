/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Manager;

import Bean.TransactionDetailBean;
import DBConnection.DBConnection;
import Persistence.TransactionDetailPersistence;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lakmal_j
 */
public class TransactionDetailManager {
     private Connection con;
     
     public TransactionDetailBean getTransactionDetails(String Type) throws Exception {
        TransactionDetailBean bean;
        TransactionDetailPersistence persistence;
        
        
        try {
            con = DBConnection.getConnection();
            persistence = new TransactionDetailPersistence();
            con.setAutoCommit(true);
            bean = persistence.getTransactionDetails(con, Type);
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
        return bean;
    }
     
     public List<TransactionDetailBean> getTransactionList() throws Exception {
        List<TransactionDetailBean> beanList;
        TransactionDetailPersistence persistence;
        
        
        try {
            con = DBConnection.getConnection();
            persistence = new TransactionDetailPersistence();
            con.setAutoCommit(true);
            beanList = persistence.getTransactionList(con);
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
}
