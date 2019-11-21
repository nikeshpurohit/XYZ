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
        <title>XYZ Login</title>
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
        <link rel="icon" type="image/png" href="images/favicon.png">

    </head>
    <body>

        <!-- Primary Page Layout
        –––––––––––––––––––––––––––––––––––––––––––––––––– -->
        <div class="container">
            <div class="row">
                <div class="one-half column" style="margin-top: 25%">
                    <h4>XYZ Driver Association</h4>
                        <%! String errString = ""; %>
                        <% errString  = (String) session.getAttribute("LoginError");%>
                        <% if(errString.equals("user")){ %>
                        <div style="color : red">A user with this username does not exist. Did you type it correctly?</div>
                        <% }else if(errString.equals("password")){ %>
                        <div style="color : red">The password you have entered in incorrect.</div>
                        <% } %>
                    <form method="POST" action="Login.do">
                        <label for="usernameInput">Username</label>
                        <input class="u-full-width" type="text" placeholder=" " name="usernameInput" required>

                        <label for="passwordInput">Password</label>
                        <input class="u-full-width" type="password" placeholder=" " name="passwordInput" required>

                        <input class="button-primary" type="submit" value="Login" name="loginButton">
                        <input class="button" type="submit" value="Sign up" name="registerButton"></form>
                    <p> The current date over there is: <%= new java.util.Date()%> </p>
                </div>
            </div>
        </div>

        <!-- End Document
          –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    </body>
</html>
