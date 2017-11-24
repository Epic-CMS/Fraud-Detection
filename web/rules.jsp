<%-- 
    Document   : rules
    Created on : Nov 22, 2017, 3:24:26 PM
    Author     : harini_s
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                                <a href="rules.jsp"><i class="fa fa-indent nav_icon"></i>Rules<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="grids.html">Card Number</a>
                                        <a href="grids.html">Customer</a>
                                        <a href="grids.html">Geographic</a>
                                        <a href="grids.html">Amount</a>
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
                    <li><a href="rules.jsp">Rules</a></li>
                </ul>
                <div class="graphs">
                    <div align="center"><font size="4" color="black"><b>Create New Rule</b><br><br></font></div>
                    <div class="clearfix"> </div>
                    <div class="col-md-6 widget_1_box2">
                        
                        <div class="wid_blog">
                            <h1>CARD NUMBER</h1>
                        </div>
                        <div class="wid_blog-desc">
                            
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                    <div class="col-md-6 widget_1_box2">
                        
                        <div class="wid_blog">
                            <h1>GEOGRAPHIC</h1>
                        </div>
                        <div class="wid_blog-desc">
                            
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                    <div class="col-md-6 widget_1_box2">
                        
                        <div class="wid_blog">
                            <h1>CUSTOMER</h1>
                        </div>
                        <div class="wid_blog-desc">
                            
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                    <div class="col-md-6 widget_1_box2">
                        
                        <div class="wid_blog">
                            <h1>PRODUCT</h1>
                        </div>
                        <div class="wid_blog-desc">
                            
                            <div class="clearfix"> </div>
                        </div>
                    </div>


                    <div class="span_11">

                        <div class="col-md-6 col_5">
                           
                            <!-- map -->
                            <link href="css/jqvmap.css" rel='stylesheet' type='text/css' />
                            <script src="js/jquery.vmap.js"></script>
                            <script src="js/jquery.vmap.sampledata.js" type="text/javascript"></script>
                            <script src="js/jquery.vmap.world.js" type="text/javascript"></script>

                            <!-- //map -->
                        </div>
                        <div class="clearfix"> </div>
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
