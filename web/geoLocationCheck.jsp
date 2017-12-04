<%-- 
    Document   : geoLocationCheck
    Created on : Nov 30, 2017, 3:59:15 PM
    Author     : lakmal_j
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

    </head>
    <body>


        <div>
            <label id="myField"></label>
        </div>



        <script>
            function initMap() {
                var id =2;
                //var bounds = new google.maps.LatLngBounds;
                var markersArray = [];

                var origin = 'Diyatha Uyana,Srilanka';
                //var origin2 = 'Greenwich, England';
                var destination = 'Kandy, Srilanka';
                //var destinationB = {lat: 50.087, lng: 14.421};

//                var destinationIcon = 'https://chart.googleapis.com/chart?' +
//                        'chst=d_map_pin_letter&chld=D|FF0000|000000';
//                var originIcon = 'https://chart.googleapis.com/chart?' +
//                        'chst=d_map_pin_letter&chld=O|FFFF00|000000';
//                var map = new google.maps.Map(document.getElementById('map'), {
//                    center: {lat: 55.53, lng: 9.4},
//                    zoom: 10
//                });
                //var geocoder = new google.maps.Geocoder;

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

//                        var showGeocodedAddressOnMap = function(asDestination) {
//                            var icon = asDestination ? destinationIcon : originIcon;
//                            return function(results, status) {
//                                if (status === 'OK') {
//                                    map.fitBounds(bounds.extend(results[0].geometry.location));
//                                    markersArray.push(new google.maps.Marker({
//                                        map: map,
//                                        position: results[0].geometry.location,
//                                        icon: icon
//                                    }));
//                                } else {
//                                    alert('Geocode was not successful due to: ' + status);
//                                }
//                            };
//                        };

                        for (var i = 0; i < originList.length; i++) {
                            var results = response.rows[i].elements;
//                            geocoder.geocode({'address': originList[i]},
//                            showGeocodedAddressOnMap(false));
                            for (var j = 0; j < results.length; j++) {
//                                geocoder.geocode({'address': destinationList[j]},
//                                showGeocodedAddressOnMap(false));

                                outputDiv1.innerHTML +=
                                        results[j].duration.text + '<br>';

                                var str = results[j].duration.text;
                                var time = str.split(" ");
                                for (var i = 0; i < time.length; i++) {
                                    alert(time[i]);
                                    if (time[i + 1] == 'days') {
                                        var days = time[i];
                                    }
                                    else if (time[i + 1] == 'hours') {
                                        var hours = time[i];
                                        var id= document.getElementById(hours);
                                    }
                                    else if (time[i + 1] == 'mins') {
                                        var mins = time[i];
                                    }
                                    i++;
                                }
                               
                                $.ajax({
                                    url: 'D:\backup\Fraud\Fraud-Detection\src\java\main\GeoDistanceCheckServlet.java',
                                    data: {
                                       postVariableName: id
                                    },
                                    type: 'POST'
                                });
                            }
                        }
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