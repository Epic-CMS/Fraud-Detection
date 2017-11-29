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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dilumka_g
 */
public class AddProfile extends HttpServlet {

    int l_name,l_from,l_to,x;
    ProfileLevelManager manager;
    ProfileLevelBean bean=new ProfileLevelBean();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter pw = response.getWriter()) {
                    l_name=Integer.parseInt(request.getParameter("l_name"));
                    l_from=Integer.parseInt(request.getParameter("l_from"));
                    l_to=Integer.parseInt(request.getParameter("l_to"));
                    manager = new ProfileLevelManager();
                    
                    bean.setLEVEL_NAME(l_name);
                    bean.setLEVEL_FROM(l_from);
                    bean.setLEVEL_TO(l_to);
                    //System.out.print(bean.getLEVEL_NAME());
                    x = manager.addProfile(bean);
                    
                    if (x > 0) {
                        pw.println("<script type=\"text/javascript\">");
                        pw.println("alert('Successfully Inserted');");
                        pw.println("location='add_profile_levels.jsp';");
                        pw.println("</script>");

                    } else {
                        pw.println("<script type=\"text/javascript\">");
                        pw.println("alert('Not Inserted');");
                        pw.println("location='add_profile_levels.jsp';");
                        pw.println("</script>");
                    }

                    RequestDispatcher rd=request.getRequestDispatcher("./add_profile_levels.jsp");
                    rd.forward(request,response);
                    
                }catch(Exception e){
                    out.print(e);
                }finally{
                    out.close();

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
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
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

    


