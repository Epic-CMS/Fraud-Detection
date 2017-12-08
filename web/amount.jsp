<%@page import="Bean.ProfileLevelBean"%>
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
                                        <a href="#">Card Number</a>
                                        <a href="#">Customer</a>
                                        <a href="geoLocationCheck.jsp">Geographic</a>
                                        <a href="ViewProfile">Amount</a>
                                        <a href="#">Product Details</a>
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
                    <li><a href="ViewProfile">Amount</a></li>
                </ul>
                <div class="graphs">
                    <a href="add_profile_levels.jsp"><button type="button" class="btn btn_5 btn-lg btn-primary">Add Profile Levels</button></a>
                    <a href="UserLevelAssignServlet"><button type="button" class="btn btn_5 btn-lg btn-primary">UserLevelAssignServlet</button></a>
                    <br><br>
                    
                    <div class="bs-example4" data-example-id="contextual-table">
                        <!-- /.table-responsive -->
                        <div><b>Current Profile Levels</b></div> 
                       <br><br>
                        <div class="table-responsive">
                            <table class="table table-bordered" id="myTable">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Profile Level</th>
                                        <th>Limit From</th>
                                        <th>Limit To</th>
                                        <th>Action</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                   
                                       <%
                                           if(request.getAttribute("beanList") != null || request.getAttribute("beanList")== ""){
                                           ArrayList<ProfileLevelBean> list = (ArrayList<ProfileLevelBean>) request.getAttribute("beanList");
                                           int i = 0;

                                           for (ProfileLevelBean bean : list) { 
                                                i++;                                        %>
                                               <tr>
                                               <td> <% out.println(i);  %></td>
                                               <td> <% out.println(bean.getLEVEL_NAME());%></td>
                                               <td> <% out.println(bean.getLEVEL_FROM());%></td>
                                               <td> <% out.println(bean.getLEVEL_TO());%></td>
                                               <td><input type="button" value="Edit" onclick="updateProfile($(this).closest('tr').index());"></input></td>
                                               <td><input type="button" value="Delete" onclick="deleteProfile($(this).closest('tr').index());"></input></td>
                                               </tr> 
                                        <%   }}
                                       %>
                                   
                                </tbody>
                            </table>
                        </div><!-- /.table-responsive -->
                    </div>

                </div>
            </div>
                                       
            <div class="modal fade" id="profileUpdate">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form role="form" class="form-horizontal" action="UpdateProfile" method="post">
                        <div class="modal-header">
                            <h4 class="modal-title"><strong>Update Profile Level</strong></h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        </div>
                        <div class="modal-body">    
                              <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="exampleInputcode">Level Name</label>
                                        <input type="text" class="form-control" id="l_name" name="l_name" placeholder="Level Name" maxlength="10" required="required">
                                    </div>
                                    
                                    <div class="form-group">
                                        <label for="exampleInputcode">Limit From</label>
                                        <input type="text" class="form-control" id="l_from" name="l_from" placeholder="Limit From" maxlength="10" required="required">
                                    </div>

                                    <div class="form-group">
                                        <label for="exampleInputcode">Limit To</label>
                                        <input type="text" class="form-control" id="l_to" name="l_to" placeholder="Limit To" maxlength="50" required="required">
                                    </div>

                                    
                                </div>
                         
                            </div>
                        </div>

                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary">Update</button>    
                            <button type="button" class="btn btn-default left" data-dismiss="modal">Close</button>
                        </div>
                    </form>     

                </div>
            </div>
        </div>
            <!-- /#page-wrapper -->
        </div>
                                       
        
        <script type="text/javascript">
            function updateProfile(row) {
                var oTable = document.getElementById('myTable');
                var Cells = oTable.rows.item(row+1).cells;
                $(".modal-body #l_name").val(Cells[1].innerText);
                $(".modal-body #l_from").val(Cells[2].innerText);
                $(".modal-body #l_to").val(Cells[3].innerText);
                
                $('#profileUpdate').modal('show');

            }

            function deleteProfile(row) {

                var oTable = document.getElementById('myTable');

                //var rowLength = oTable.rows.length;
                var Cells = oTable.rows.item(row+1).cells;
                var value = Cells.item(1).innerHTML;
                
                url = "DeleteProfile";
                window.location.href = "http://localhost:8080/Fraud-Detection/" + url + "?id=" + value;
                
                //var value=document.getElementById('uid').value = oCells.item(0).innerHTML;    
            }

            
        </script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
