<%@page import="java.util.ArrayList"%>
<%@page import="Bean.TransactionDetailBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
    <head>
        <title>EPIC Fraud Management</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
        <!-- Custom CSS -->
        <link href="css/style.css" rel='stylesheet' type='text/css' />
        <!-- Graph CSS -->
        <link href="css/lines.css" rel='stylesheet' type='text/css' />
        <link href="css/font-awesome.css" rel="stylesheet"> 
        <!-- jQuery -->
        <script src="js/jquery.min.js"></script>
        <!----webfonts--->
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
        <!---//webfonts--->  
        <!-- Nav CSS -->
        <link href="css/custom.css" rel="stylesheet">
        <!-- Metis Menu Plugin JavaScript -->
        <script src="js/metisMenu.min.js"></script>
        <script src="js/custom.js"></script>
        <!-- Graph JavaScript -->
        <script src="js/d3.v3.js"></script>
        <script src="js/rickshaw.js"></script>
    </head>
    <body>
        <div id="wrapper">
            <!-- Navigation -->
            <nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp">Fraud Management</a>
                </div>
                <!-- /.navbar-header -->
                <ul class="nav navbar-nav navbar-right">

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle avatar" data-toggle="dropdown"><img src="images/1.png"><span class="badge">9</span></a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-menu-header text-center">
                                <strong>Account</strong>
                            </li>


                            <li class="m_2"><a href="#"><i class="fa fa-user"></i> Profile</a></li>
                            <li class="m_2"><a href="#"><i class="fa fa-wrench"></i> Settings</a></li>
                            <li class="m_2"><a href="#"><i class="fa fa-usd"></i> Payments <span class="label label-default">42</span></a></li>
                            <li class="m_2"><a href="#"><i class="fa fa-file"></i> Projects <span class="label label-primary">42</span></a></li>
                            <li class="divider"></li>
                            <li class="m_2"><a href="#"><i class="fa fa-shield"></i> Lock Profile</a></li>
                            <li class="m_2"><a href="#"><i class="fa fa-lock"></i> Logout</a></li>	
                        </ul>
                    </li>
                </ul>

                <form class="navbar-form navbar-right">
                    <input type="text" class="form-control" value="Search..." onfocus="this.value = '';" onblur="if (this.value == '') {
                                this.value = 'Search...';
                            }">
                </form>


                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav" id="side-menu">
                            <li>
                                <a href="index.jsp"><i class="fa fa-dashboard fa-fw nav_icon"></i>Dashboard</a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-check-square-o nav_icon"></i>Rules<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="grids.html">Card Number</a>
                                        <a href="grids.html">Customer</a>
                                        <a href="grids.html">Geographic</a>
                                        <a href="amount.html">Amount</a>
                                        <a href="grids.html">Product Details</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>
                        </ul>
                    </div>
                    <!-- /.sidebar-collapse -->
                </div>
                <!-- /.navbar-static-side -->



            </nav>
            <div id="page-wrapper">
                <ul class="breadcrumb">
                    <li><a href="index.jsp">Dashboard</a></li>
                    <li><a href="amount.jsp">Amount</a></li>
                </ul>
                <div class="graphs">
                    <a href="profile_levels.jsp"><button type="button" class="btn btn_5 btn-lg btn-primary">Add/Update Profile Levels</button></a>
                    <br><br>

                    <div class="bs-example4" data-example-id="contextual-table">
                        <!-- /.table-responsive -->
                        <a href="./Test"><button type="button" class="btn btn_2 btn-md btn-primary">Show Table</button></a><br><br>
                        <div class="table-responsive">
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Card Number</th>
                                        <th>Transaction Amount</th>
                                        <th>Time(Local Transaction)</th>
                                        <th>Date()</th>
                                        <th>Merchant Type</th>
                                        <th>STAN</th>
                                        <th>Expiration Date</th>
                                        <th>Terminal Code</th>
                                        <th>Merchant Code</th>
                                        <th>Merchant Name/Location</th>
                                        <th>Currency Code</th>
                                    </tr>
                                </thead>
                                <tbody>
                                   
                                       <%
                                           if(request.getAttribute("beanList") != null || request.getAttribute("beanList")== ""){
                                           ArrayList<TransactionDetailBean> list = (ArrayList<TransactionDetailBean>) request.getAttribute("beanList");
                                           int i = 0;

                                           for (TransactionDetailBean bean : list) { 
                                                i++;                                        %>
                                               <tr>
                                               <td> <% {out.println(i); } %></td>
                                               <td> <% if(bean.getF2_PAN() != null){out.println(bean.getF2_PAN()); }else{out.println("--"); }%></td>
                                               <td> <% if(bean.getF4_AMOUNT_TRANS() != null) {out.println(bean.getF4_AMOUNT_TRANS()); }else{out.println("--"); } %></td>
                                               <td> <% if(bean.getF12_LOCAL_TIME() != null) {
                                                        String time = bean.getF12_LOCAL_TIME();
                                                        String[] parts = {time.substring(0, 2),time.substring(2,4),time.substring(4)};
                                                        out.println(parts[0] +" :"+ parts[1]+" :"+ parts[2]); 
                                                       }else{
                                                        out.println("--"); 
                                                       } %></td>
                                               <td> <% if(bean.getF13_LOCAL_DATE() != null) {
                                                        String date = bean.getF13_LOCAL_DATE();
                                                        String[] parts = {date.substring(0, 2),date.substring(2)};
                                                        out.println(parts[1] +" - "+ parts[0]); 
                                                    }else{
                                                        out.println("--"); 
                                                    } %></td>
                                               
                                               <td> <% if(bean.getF18_MERCHANT_TYPE() != null) {out.println(bean.getF18_MERCHANT_TYPE()); }else{out.println("--"); } %></td>
                                               <td> <% if(bean.getF14_DATE_EXPIRATION() != null) {out.println(bean.getF14_DATE_EXPIRATION()); }else{out.println("--"); } %></td>
                                               <td> <% if(bean.getF11_SYSTEM_TRACE() != null) {out.println(bean.getF11_SYSTEM_TRACE()); }else{out.println("--"); } %></td>
                                               <td> <% if(bean.getF41_CARD_ACCEPT_TERM_IDEN() != null) {out.println(bean.getF41_CARD_ACCEPT_TERM_IDEN()); }else{out.println("--"); } %></td>
                                               <td> <% if(bean.getF42_CARD_ACCEPT_IDEN_CODE() != null) {out.println(bean.getF42_CARD_ACCEPT_IDEN_CODE()); }else{out.println("--"); } %></td>
                                               <td> <% if(bean.getF43_CARD_ACCCEPT_NAME() != null) {out.println(bean.getF43_CARD_ACCCEPT_NAME()); }else{out.println("--"); } %></td>
                                               <td> <% if(bean.getF49_CURRENCY_CODE_TRANS() != null) {out.println(bean.getF49_CURRENCY_CODE_TRANS()); }else{out.println("--"); } %></td>
                                                </tr> 
                                        <%   }}
                                       %>
                                   
                                </tbody>
                            </table>
                        </div><!-- /.table-responsive -->
                    </div>



                </div>
            </div>
            <!-- /#page-wrapper -->
        </div>
        <!-- /#wrapper -->
        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>