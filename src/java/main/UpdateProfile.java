/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Bean.ProfileLevelBean;
import Manager.ProfileLevelManager;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dilumka_g
 */
public class UpdateProfile extends HttpServlet {

    ProfileLevelManager manager=new ProfileLevelManager();
    ProfileLevelBean bean=new ProfileLevelBean();
    
    int l_name,l_from,l_to,x;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        try {
            
            l_name=Integer.parseInt(request.getParameter("l_name")); 
            l_from=Integer.parseInt(request.getParameter("l_from"));
            l_to=Integer.parseInt(request.getParameter("l_to"));
            
            bean.setLEVEL_NAME(l_name);
            bean.setLEVEL_FROM(l_from);
            bean.setLEVEL_TO(l_to);
            
            x=manager.updateProfile(bean);
           
        }catch(Exception e){
            out.print(e);
        }finally{
            pw.println("<script type=\"text/javascript\">");
            pw.println("location='ViewProfile';");
            pw.println("</script>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
