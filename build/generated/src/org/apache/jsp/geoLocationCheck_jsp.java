package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import Bean.GeoDistanceCheckBean;
import java.util.ArrayList;
import Bean.TransactionDetailBean;

public final class geoLocationCheck_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>EPIC Fraud Management</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <meta name=\"keywords\" content=\"Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, \n");
      out.write("              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design\" />\n");
      out.write("        <script type=\"application/x-javascript\"> addEventListener(\"load\", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>\n");
      out.write("        <!-- Bootstrap Core CSS -->\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel='stylesheet' type='text/css' />\n");
      out.write("        <!-- Custom CSS -->\n");
      out.write("        <link href=\"css/style.css\" rel='stylesheet' type='text/css' />\n");
      out.write("        <!-- Graph CSS -->\n");
      out.write("        <link href=\"css/lines.css\" rel='stylesheet' type='text/css' />\n");
      out.write("        <link href=\"css/font-awesome.css\" rel=\"stylesheet\"> \n");
      out.write("        <!-- jQuery -->\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\n");
      out.write("        <!----webfonts--->\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>\n");
      out.write("        <!---//webfonts--->  \n");
      out.write("        <!-- Nav CSS -->\n");
      out.write("        <link href=\"css/custom.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- Metis Menu Plugin JavaScript -->\n");
      out.write("        <script src=\"js/metisMenu.min.js\"></script>\n");
      out.write("        <script src=\"js/custom.js\"></script>\n");
      out.write("        <!-- Graph JavaScript -->\n");
      out.write("        <script src=\"js/d3.v3.js\"></script>\n");
      out.write("        <script src=\"js/rickshaw.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"wrapper\">\n");
      out.write("            <!-- Navigation -->\n");
      out.write("            <nav class=\"top1 navbar navbar-default navbar-static-top\" role=\"navigation\" style=\"margin-bottom: 0\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n");
      out.write("                        <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <a class=\"navbar-brand\" href=\"index.jsp\">Fraud Management</a>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.navbar-header -->\n");
      out.write("                <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("\n");
      out.write("                    <li class=\"dropdown\">\n");
      out.write("                        <a href=\"#\" class=\"dropdown-toggle avatar\" data-toggle=\"dropdown\"><img src=\"images/1.png\"><span class=\"badge\">9</span></a>\n");
      out.write("                        <ul class=\"dropdown-menu\">\n");
      out.write("                            <li class=\"dropdown-menu-header text-center\">\n");
      out.write("                                <strong>Account</strong>\n");
      out.write("                            </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <li class=\"m_2\"><a href=\"#\"><i class=\"fa fa-user\"></i> Profile</a></li>\n");
      out.write("                            <li class=\"m_2\"><a href=\"#\"><i class=\"fa fa-wrench\"></i> Settings</a></li>\n");
      out.write("                            <li class=\"m_2\"><a href=\"#\"><i class=\"fa fa-usd\"></i> Payments <span class=\"label label-default\">42</span></a></li>\n");
      out.write("                            <li class=\"m_2\"><a href=\"#\"><i class=\"fa fa-file\"></i> Projects <span class=\"label label-primary\">42</span></a></li>\n");
      out.write("                            <li class=\"divider\"></li>\n");
      out.write("                            <li class=\"m_2\"><a href=\"#\"><i class=\"fa fa-shield\"></i> Lock Profile</a></li>\n");
      out.write("                            <li class=\"m_2\"><a href=\"#\"><i class=\"fa fa-lock\"></i> Logout</a></li>\t\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("                <form class=\"navbar-form navbar-right\">\n");
      out.write("                    <input type=\"text\" class=\"form-control\" value=\"Search...\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {\n");
      out.write("                                this.value = 'Search...';\n");
      out.write("                            }\">\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"navbar-default sidebar\" role=\"navigation\">\n");
      out.write("                    <div class=\"sidebar-nav navbar-collapse\">\n");
      out.write("                        <ul class=\"nav\" id=\"side-menu\">\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"index.jsp\"><i class=\"fa fa-dashboard fa-fw nav_icon\"></i>Dashboard</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-check-square-o nav_icon\"></i>Rules<span class=\"fa arrow\"></span></a>\n");
      out.write("                                <ul class=\"nav nav-second-level\">\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"#\">Card Number</a>\n");
      out.write("                                        <a href=\"#\">Customer</a>\n");
      out.write("                                        <a href=\"geoLocationCheck.jsp\">Geographic</a>\n");
      out.write("                                        <a href=\"ViewProfile\">Amount</a>\n");
      out.write("                                        <a href=\"#\">Product Details</a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                                <!-- /.nav-second-level -->\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.sidebar-collapse -->\n");
      out.write("                </div>\n");
      out.write("                <!-- /.navbar-static-side -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </nav>\n");
      out.write("            <div id=\"page-wrapper\">\n");
      out.write("                <ul class=\"breadcrumb\">\n");
      out.write("                    <li><a href=\"index.jsp\">Dashboard</a></li>\n");
      out.write("                </ul>\n");
      out.write("                <div class=\"graphs\">\n");
      out.write("                    <a href=\"create_newrule.jsp\"><button type=\"button\" class=\"btn btn_5 btn-lg btn-primary\">Create New Rule</button></a>\n");
      out.write("                    <br><br>\n");
      out.write("\n");
      out.write("                    <br><br>\n");
      out.write("                    <div class=\"bs-example4\" data-example-id=\"contextual-table1\">\n");
      out.write("                        <div id=\"myField\"></div>\n");
      out.write("                        <!-- /.table-responsive -->\n");
      out.write("                        <a href=\"./GeoDistanceCheckServlet\"><button type=\"button\" class=\"btn btn_2 btn-md btn-primary\">Show Table</button></a> <br><br>\n");
      out.write("                        <div class=\"table-responsive\">\n");
      out.write("                            <table class=\"table table-bordered\">\n");
      out.write("                                <thead>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th>#</th>\n");
      out.write("                                        <th>PAN</th>\n");
      out.write("                                        <th>Date</th>\n");
      out.write("                                        <th>Place</th>\n");
      out.write("\n");
      out.write("                                    </tr>\n");
      out.write("                                </thead>\n");
      out.write("                                <tbody>\n");
      out.write("\n");
      out.write("                                    ");

                                        if (request.getAttribute("beanList1") != null || request.getAttribute("beanList1") == "") {
                                            List<GeoDistanceCheckBean> list = (List<GeoDistanceCheckBean>) request.getAttribute("beanList1");
                                            int i = 0;

                                            for (GeoDistanceCheckBean bean : list) {
                                                i++;                                        
      out.write("\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td> ");
 {
                                                out.println(i);
                                            } 
      out.write("</td>\n");
      out.write("                                        <td> ");
 if (bean.getF2_PAN() != null) {
                                                out.println(bean.getF2_PAN());
                                            } else {
                                                out.println("--");
                                            }
      out.write("</td>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        <td> ");
 if (bean.getF7_TRANSMISSION_DATETIME() != null) {
                                                String[] date = bean.getF7_TRANSMISSION_DATETIME();

                                                out.println(" Month " + date[0] + " Date" + date[1] + " hours" + date[2] + " minutes" + date[3]);
                                            } else {
                                                out.println("--");
                                            } 
      out.write("</td>\n");
      out.write("                                        <td> ");
 if (bean.getF43_CARD_ACCCEPT_NAME() != null) {
                                                out.println(bean.getF43_CARD_ACCCEPT_NAME());
                                            } else {
                                                out.println("--");
                                            }
      out.write("</td>\n");
      out.write("\n");
      out.write("                                    </tr> \n");
      out.write("                                    ");
   }
                                        }
                                    
      out.write("\n");
      out.write("\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("                        </div><!-- /.table-responsive -->\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- /#page-wrapper -->\n");
      out.write("        </div>\n");
      out.write("        <!-- /#wrapper -->\n");
      out.write("        <!-- Bootstrap Core JavaScript -->\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("                        function initMap() {\n");
      out.write("\n");
      out.write("                            var markersArray = [];\n");
      out.write("\n");
      out.write("                            $.ajax({\n");
      out.write("                                url: \"GeoDistanceCheckServlet?flag=receive\",\n");
      out.write("                                type: \"POST\",\n");
      out.write("                                data: {},\n");
      out.write("                                success: function(data) {\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    var origin = JSON.stringify(data.origin);\n");
      out.write("                                    var destination = JSON.stringify(data.destination);\n");
      out.write("\n");
      out.write("                                    alert(origin);\n");
      out.write("                                    var service = new google.maps.DistanceMatrixService;\n");
      out.write("                                    service.getDistanceMatrix({\n");
      out.write("                                        origins: [origin],\n");
      out.write("                                        destinations: [destination],\n");
      out.write("                                        travelMode: 'DRIVING',\n");
      out.write("                                        unitSystem: google.maps.UnitSystem.METRIC,\n");
      out.write("                                        avoidHighways: false,\n");
      out.write("                                        avoidTolls: false\n");
      out.write("                                    }, function(response, status) {\n");
      out.write("                                        if (status !== 'OK') {\n");
      out.write("                                            alert('Error was: ' + status);\n");
      out.write("                                        } else {\n");
      out.write("                                            var originList = response.originAddresses;\n");
      out.write("                                            //var destinationList = response.destinationAddresses;\n");
      out.write("\n");
      out.write("                                            var outputDiv1 = document.getElementById('myField');\n");
      out.write("\n");
      out.write("                                            outputDiv1.innerHTML = '';\n");
      out.write("                                            deleteMarkers(markersArray);\n");
      out.write("\n");
      out.write("\n");
      out.write("                                            for (var i = 0; i < originList.length; i++) {\n");
      out.write("                                                var results = response.rows[i].elements;\n");
      out.write("\n");
      out.write("                                                for (var j = 0; j < results.length; j++) {\n");
      out.write("\n");
      out.write("\n");
      out.write("                                                    outputDiv1.innerHTML +=\n");
      out.write("                                                            results[j].duration.text + '<br>';\n");
      out.write("\n");
      out.write("                                                    var str = results[j].duration.text;\n");
      out.write("                                                    var time = str.split(\" \");\n");
      out.write("                                                    var days = null;\n");
      out.write("                                                    var hours = null;\n");
      out.write("                                                    var mins = null;\n");
      out.write("                                                    for (var i = 0; i < time.length; i++) {\n");
      out.write("                                                        //alert(time[i]);\n");
      out.write("                                                        if (time[i + 1] == 'days') {\n");
      out.write("                                                            days = time[i];\n");
      out.write("\n");
      out.write("                                                        }\n");
      out.write("                                                        else if (time[i + 1] == 'hours') {\n");
      out.write("                                                            hours = time[i];\n");
      out.write("\n");
      out.write("                                                        }\n");
      out.write("                                                        else if (time[i + 1] == 'mins') {\n");
      out.write("                                                            mins = time[i];\n");
      out.write("                                                        }\n");
      out.write("                                                        i++;\n");
      out.write("\n");
      out.write("                                                    }\n");
      out.write("                                                    ajaxcall(days, hours, mins);\n");
      out.write("                                                }\n");
      out.write("                                            }\n");
      out.write("                                        }\n");
      out.write("                                    });\n");
      out.write("\n");
      out.write("                                }\n");
      out.write("                            });\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        }\n");
      out.write("\n");
      out.write("                        function ajaxcall(days, hours, mins) {\n");
      out.write("\n");
      out.write("                            //alert(hours);\n");
      out.write("                            $.ajax({\n");
      out.write("                                url: \"GeoDistanceCheckServlet?flag=send\",\n");
      out.write("                                type: \"POST\",\n");
      out.write("                                data: {\n");
      out.write("                                    hours: hours, days: days, mins: mins\n");
      out.write("                                },\n");
      out.write("                                success: function(data) {\n");
      out.write("                                    //alert(\"success\");\n");
      out.write("                                    //alert(data.toString());\n");
      out.write("                                    //alert(JSON.stringify(data));\n");
      out.write("\n");
      out.write("                                }\n");
      out.write("                            });\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        }\n");
      out.write("                        function deleteMarkers(markersArray) {\n");
      out.write("                            for (var i = 0; i < markersArray.length; i++) {\n");
      out.write("                                markersArray[i].setMap(null);\n");
      out.write("                            }\n");
      out.write("                            markersArray = [];\n");
      out.write("                        }\n");
      out.write("        </script>\n");
      out.write("        <script async defer\n");
      out.write("                src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyARa_203DMXCJebfpnw8n5XiYM_F1Xi0zk&callback=initMap\">\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
