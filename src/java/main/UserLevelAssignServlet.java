/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Bean.ProfileLevelBean;
import Bean.TransactionDetailBean;
import Manager.ProfileLevelManager;
import Manager.UserLevelAssignManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lakmal_j
 */
public class UserLevelAssignServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            UserLevelAssignManager manager = new UserLevelAssignManager();
            ProfileLevelManager levelmanager = new ProfileLevelManager();
            UserLevelAssignManager assignManager = new UserLevelAssignManager();
            List<TransactionDetailBean> beanList = null;
            List<ProfileLevelBean> levelBeanList = null;
            int successmsg;

            beanList = manager.getTranAmounts("4024007188976491");
            levelBeanList = levelmanager.getProfileLevelList();

            double total = 0;
            double average;

            for (int i = 0; i < beanList.size(); i++) {
                total = total + Double.parseDouble(beanList.get(i).getF4_AMOUNT_TRANS()) / 100;
                System.out.print("Amount" + i + " " + Double.parseDouble(beanList.get(i).getF4_AMOUNT_TRANS()) / 100);
            }
            average = total / beanList.size();
            System.out.print("average" + average);

            for (int i = 0; i < levelBeanList.size(); i++) {
                if (average>=levelBeanList.get(i).getLEVEL_FROM() && average<levelBeanList.get(i).getLEVEL_TO()) {
                    System.out.print(levelBeanList.get(i).getLEVEL_NAME());
                    
                     successmsg = assignManager.assignlevel(beanList.get(i).getF2_PAN(), String.valueOf(levelBeanList.get(i).getLEVEL_NAME()));
                }
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UserLevelAssignServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UserLevelAssignServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
