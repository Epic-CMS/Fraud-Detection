/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Bean.GeoDistanceCheckBean;
import Manager.GeoDistanceCheckManager;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class GeoDistanceCheckServlet extends HttpServlet {

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
        GeoDistanceCheckManager manager1 = new GeoDistanceCheckManager();

        List<GeoDistanceCheckBean> beanList1 = null;

        beanList1 = manager1.getGeoCheckTrans("4024007188976491");

        String[] d1 = beanList1.get(0).getF7_TRANSMISSION_DATETIME();
        String[] d2 = beanList1.get(1).getF7_TRANSMISSION_DATETIME();
        String time1 = d1[0] + d1[1] + d1[2] + d1[3];
        String time2 = d2[0] + d2[1] + d2[2] + d2[3];

        SimpleDateFormat simpleDateFormat
                = new SimpleDateFormat("MMddhhmm");
        Date dateAsString = simpleDateFormat.parse(time1);
        Date dateAsString2 = simpleDateFormat.parse(time2);
        long e = dateAsString2.getTime() - dateAsString.getTime();
        long days, hours, mins;
        days = e / (1000 * 60 * 60 * 24);
        if (days > 0) {
            hours = e / (1000 * 60 * 60) - days * 24;
            if (hours > 0) {
                mins = e / (1000 * 60) - hours * 60 - days * 24 * 60;
            } else {
                mins = e / (1000 * 60);
            }
        } else {
            hours = e / (1000 * 60 * 60);
            if (hours > 0) {
                mins = e / (1000 * 60) - hours * 60 - days * 24 * 60;
            } else {
                mins = e / (1000 * 60);
            }
        }

        //String dateA= simpleDateFormat.format(dateAsString);
        System.out.println("days" + days + "  hours" + hours + "  mins" + mins);

        String id = request.getParameter("id");
        System.out.print("id is:" + id);

        request.setAttribute(
                "beanList1", beanList1);
        getServletConfig()
                .getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private Integer[] convertTOIntArray(String[] strings) {
        Integer[] intarray = new Integer[strings.length];
        int i = 0;
        for (String str : strings) {
            intarray[i] = Integer.parseInt(str.trim());//Exception in this line
            i++;
        }
        return intarray;
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
            Logger.getLogger(GeoDistanceCheckServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(GeoDistanceCheckServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
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
