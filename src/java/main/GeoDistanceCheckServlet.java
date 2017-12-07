/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Bean.GeoDistanceCheckBean;
import Manager.GeoDistanceCheckManager;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.err;
import static java.lang.System.out;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

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

        GeoDistanceCheckManager manager1 = new GeoDistanceCheckManager();
        List<GeoDistanceCheckBean> beanList1 = null;
        beanList1 = manager1.getGeoCheckTrans("4024007188976491");

        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html;charset=UTF-8");

            if (request.getParameter("flag").equals("send")) {

                String hours1 = request.getParameter("hours");
                String days1 = request.getParameter("days");
                String mins1 = request.getParameter("mins");
                String numberAsString = days1 + hours1 + mins1;

                long realdifference = Long.parseLong(numberAsString);
                System.out.print("Real Difference---------- ");
                System.out.println(realdifference);

                String[] d1 = beanList1.get(0).getF7_TRANSMISSION_DATETIME();
                String[] d2 = beanList1.get(1).getF7_TRANSMISSION_DATETIME();
                String time1 = d1[0] + d1[1] + d1[2] + d1[3];
                request.getSession().setAttribute("date1", "month" + d1[0] + " date" + d1[1] + " hour" + d1[2] + " mins" + d1[3]);
                String time2 = d2[0] + d2[1] + d2[2] + d2[3];
                request.getSession().setAttribute("date2", "month" + d2[0] + " date" + d2[1] + " hour" + d2[2] + " mins" + d2[3]);

                SimpleDateFormat simpleDateFormat
                        = new SimpleDateFormat("MMddhhmm");
                Date dateAsString = simpleDateFormat.parse(time1);
                Date dateAsString2 = simpleDateFormat.parse(time2);

                if (dateAsString2.getTime() >= dateAsString.getTime()) {
                    long e = dateAsString2.getTime() - dateAsString.getTime();
                    System.out.print("time old vs time new---------- ");
                    System.out.println(dateAsString2.getTime());
                    System.out.println(dateAsString.getTime());
                    System.out.println(e);

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

                    String dayslong, hourslong, minslong;
                    if (days == 0) {
                        dayslong = "00";
                    } else {
                        dayslong = Long.toString(days);
                    }
                    if (hours == 0) {
                        hourslong = "00";
                    } else {
                        hourslong = Long.toString(hours);
                    }
                    if (mins == 0) {
                        minslong = "00";
                    } else {
                        minslong = Long.toString(mins);
                    }

                    String trandiffString = (dayslong + hourslong + minslong);

                    System.out.print("Transaction Difference---------- ");
                    long trandifference = Long.parseLong(trandiffString);
                    //long trandifference = trandiffString;
                    System.out.println(trandifference);

                    long realVsTranDiff = trandifference - realdifference;
                    System.out.print("Transaction vs real time Difference---------- ");
                    System.out.println(realVsTranDiff);
                    if (realVsTranDiff >= 0) {
                        request.getSession().setAttribute("Status", "Not a Fraudulent Transaction");
                        System.out.print("Not a Fraudulent Transaction");
                    } else {
                        request.getSession().setAttribute("Status", "a Fraudulent Transaction !");
                        System.out.print("Fraudulent Transaction !");
                    }
                } else {
                    request.getSession().setAttribute("Status", "Transaction error !");
                }

            } else if (request.getParameter("flag").equals("receive")) {

                String locationA = beanList1.get(0).getF43_CARD_ACCCEPT_NAME();
                String locationB = beanList1.get(1).getF43_CARD_ACCCEPT_NAME();
                String[] locationArrayA = locationA.split("\\s+");
                String[] locationArrayB = locationB.split("\\s+");

                System.out.print("s" + locationArrayA[1] + "e");

                JSONObject jsono = new JSONObject();
                response.setContentType("json");
                jsono.put("origin", locationArrayA[1] + ",Srilanka");
                jsono.put("destination", locationArrayB[1] + ", Srilanka");

                out.print(jsono);
                //getServletContext().getRequestDispatcher("/geoLocationCheck.jsp").forward(request, response);
            } else if (request.getParameter("flag").equals("loaddata")) {

                request.getSession().setAttribute("PAN", beanList1.get(0).getF2_PAN());
                for (int i = 0; i < 2; i++) {
                    request.getSession().setAttribute("F2_PAN" + i, beanList1.get(i).getF2_PAN());
                    request.getSession().setAttribute("F7_TRANSMISSION_DATETIME" + i, beanList1.get(i).getF7_TRANSMISSION_DATETIME());
                    request.getSession().setAttribute("F43_CARD_ACCCEPT_NAME" + i, beanList1.get(i).getF43_CARD_ACCCEPT_NAME());

                }
                //getServletContext().getRequestDispatcher("/geoLocationCheck.jsp").forward(request, response);
            }

        } catch (Exception eg) {
            printStackTrace();
        }

        //getServletConfig().getServletContext().getRequestDispatcher("/geoLocationCheck.jsp").forward(request, response);
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
