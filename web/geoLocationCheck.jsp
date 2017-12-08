<%@page import="java.util.List"%>
<%@page import="Bean.GeoDistanceCheckBean"%>
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
                    <li><a href="geoLocationCheck.jsp">Geographic</a></li>
                </ul>
                <div class="graphs">
                    <a href="create_newrule.jsp"><button type="button" class="btn btn_5 btn-lg btn-primary">Create New Rule</button></a> 
                    <br><br>

                    <br><br>
                    <div class="bs-example4" data-example-id="contextual-table1">
                        <div id="myField" style="display: none;"></div> 
                        <div><% String Status = (String) session.getAttribute("Status");
                            String PAN = (String) session.getAttribute("PAN");
                            String F43_CARD_ACCCEPT_NAME0 = (String) session.getAttribute("F43_CARD_ACCCEPT_NAME0");
                            String F43_CARD_ACCCEPT_NAME1 = (String) session.getAttribute("F43_CARD_ACCCEPT_NAME1");
                            String date1 = (String) session.getAttribute("date1");
                            String date2 = (String) session.getAttribute("date2");
                            String transactionDifference = (String) session.getAttribute("transactionDifference");
                            String actualDifference = (String) session.getAttribute("actualDifference");
                            %>
                            <div>Last transaction of PAN "<%= PAN%>" is  <b><%= Status%></b></div>
                            <div>Time to travel between two places - <b> <%= transactionDifference%></b></div>
                            <div>Actual Transaction period difference - <b> <%= actualDifference%></b></div>
                            <br><br>
                        </div>
                    </div>
                    <!-- /.table-responsive -->
                    <!--<a href="./GeoDistanceCheckServlet"><button type="button" class="btn btn_2 btn-md btn-primary">Show Table</button></a> <br><br> !-->
                    <div class="table-responsive">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>PAN</th>
                                    <th>Date</th>
                                    <th>Place</th>

                                </tr>
                            </thead>
                            <tbody>

                                <tr><td>1</td><td><%= PAN%></td><td><%= date1%></td><td><%= F43_CARD_ACCCEPT_NAME0%></td>
                                </tr>

                                <tr><td>2</td><td><%= PAN%></td><td><%= date2%></td><td><%= F43_CARD_ACCCEPT_NAME1%></td>
                                </tr>

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
    <script>
                        window.onload = loaddata;

                        function loaddata() {
                            $.ajax({
                                url: "GeoDistanceCheckServlet?flag=loaddata",
                                type: "POST",
                                data: {
                                   
                                },
                                success: function(data) {
                                    //alert("success");
                                    //alert(data.toString());
                                    //alert(JSON.stringify(data));

                                }
                            });
                        }
    </script>


    <script>
        function initMap() {

            var markersArray = [];

            $.ajax({
                url: "GeoDistanceCheckServlet?flag=receive",
                type: "POST",
                data: {},
                success: function(data) {


                    var origin = JSON.stringify(data.origin);
                    var destination = JSON.stringify(data.destination);


                    var service = new google.maps.DistanceMatrixService;
                    service.getDistanceMatrix({
                        origins: [origin],
                        destinations: [destination],
                        travelMode: 'DRIVING',
                        unitSystem: google.maps.UnitSystem.METRIC,
                        avoidHighways: false,
                        avoidTolls: false
                    }, function(response, status) {
                        if (status !== 'OK') {
                            alert('Error was: ' + status);
                        } else {
                            var originList = response.originAddresses;
                            //var destinationList = response.destinationAddresses;

                            var outputDiv1 = document.getElementById('myField');

                            outputDiv1.innerHTML = '';
                            deleteMarkers(markersArray);


                            for (var i = 0; i < originList.length; i++) {
                                var results = response.rows[i].elements;

                                for (var j = 0; j < results.length; j++) {


                                    outputDiv1.innerHTML +=
                                            results[j].duration.text + '<br>';

                                    var str = results[j].duration.text;
                                    var time = str.split(" ");
                                    var days = null;
                                    var hours = null;
                                    var mins = null;
                                    for (var i = 0; i < time.length; i++) {
                                        //alert(time[i]);
                                        if (time[i + 1] == 'days') {
                                            days = time[i];

                                        }
                                        else if (time[i + 1] == 'hours') {
                                            hours = time[i];

                                        }
                                        else if (time[i + 1] == 'mins') {
                                            mins = time[i];
                                        }
                                        i++;

                                    }
                                    ajaxcall(days, hours, mins);
                                }
                            }
                        }
                    });

                }
            });



        }

        function ajaxcall(days, hours, mins) {

            //alert(hours);
            $.ajax({
                url: "GeoDistanceCheckServlet?flag=send",
                type: "POST",
                data: {
                    hours: hours, days: days, mins: mins
                },
                success: function(data) {
                    //alert("success");
                    //alert(data.toString());
                    //alert(JSON.stringify(data));

                }
            });
        }



        function deleteMarkers(markersArray) {
            for (var i = 0; i < markersArray.length; i++) {
                markersArray[i].setMap(null);
            }
            markersArray = [];
        }
    </script>
    <script async defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyARa_203DMXCJebfpnw8n5XiYM_F1Xi0zk&callback=initMap">
    </script>

</body>
</html>
