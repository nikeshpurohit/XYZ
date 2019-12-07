<%-- 
    Document   : LoginJSP
    Created on : 08-Nov-2019, 17:32:05
    Author     : nik_3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>

        <!-- Basic Page Needs
        –––––––––––––––––––––––––––––––––––––––––––––––––– -->
        <meta charset="utf-8">
        <title>XYZ Register</title>
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Mobile Specific Metas
        –––––––––––––––––––––––––––––––––––––––––––––––––– -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- FONT
        –––––––––––––––––––––––––––––––––––––––––––––––––– -->
        <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">

        <!-- CSS
        –––––––––––––––––––––––––––––––––––––––––––––––––– -->
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/skeleton.css">

        <!-- Favicon
        –––––––––––––––––––––––––––––––––––––––––––––––––– -->
        <link rel="icon" type="image/png" href="images/favicon.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=places&key=AIzaSyBcumNoMo3C2x2BjP2GbX8dX25JEDHoH1M"></script>
<script>
    var searchInput = 'search_input';

$(document).ready(function () {
    var autocomplete;
    autocomplete = new google.maps.places.Autocomplete((document.getElementById(searchInput)), {
        types: ['geocode'],
    });
	
    google.maps.event.addListener(autocomplete, 'place_changed', function () {
        var near_place = autocomplete.getPlace();
        document.getElementById('loc_lat').value = near_place.geometry.location.lat();
        document.getElementById('loc_long').value = near_place.geometry.location.lng();
		
        document.getElementById('latitude_view').innerHTML = near_place.geometry.location.lat();
        document.getElementById('longitude_view').innerHTML = near_place.geometry.location.lng();
    });
});    
</script>
    </head>
    <body>

        <!-- Primary Page Layout
        –––––––––––––––––––––––––––––––––––––––––––––––––– -->
        <div class="container">
            <div class="row">
                <div class="one-half column" style="margin-top: 25%">
                    <h4>XYZ Driver Association</h4>
                        <%! String errString = ""; %>
                        <%! String successString = "";%>
                        <% errString  = (String) session.getAttribute("RegisterError");%>
                        <% successString = (String) session.getAttribute("RegisterSuccess"); %>
                        <% if(errString.equals("RUser")){ %>
                        <div style="color : red">A user with this username already exists! Try making up a new one!</div>
                        <% }else if(errString.equals("REmpty")){%>
                        <div style="color : red">Please input your username and password to continue!</div>
                        <% }else if(errString.equals("RPassword")){ %>
                        <div style="color : red">The Password given does not match! re-type both of your passwords. </div>
                        <% }else if((errString.equals("none")) && (successString.equals("true"))){ %>
                        <div style="color : green">User created successfully</div>
                        
                        <%} %>
                       
                    <form method="POST" action="Register.do">
                                                
                        <label for="rFirstNameInput">First Name</label>
                        <input class="u-full-width" type="text" placeholder=" " name="rFirstNameInput" required>
                        
                        <label for="rSecondNaameInput">Second Name</label>
                        <input class="u-full-width" type="text" placeholder=" " name="rSecondNameInput" required>

                        <label for="rDoB">Date of Birth</label>
                        <input class="datepicker" type="date" placeholder=" " name="rDoB" required>
                        
			<label for="rAddress">Address</label>
                        <input class="u-full-width" type="text" id ="search_input" placeholder=" " name="rAddress" required>
                        

                        <input class="button-primary" type="submit" value="Register" name="registerButton">
                        </form>
                    <p> The current date over there is: <%= new java.util.Date()%> </p>
                </div>
            </div>
        </div>

        <!-- End Document
          –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    </body>
</html>
