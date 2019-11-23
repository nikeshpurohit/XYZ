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
                        <% errString  = (String) session.getAttribute("RegisterError");%>
                        <% if(errString.equals("RUser")){ %>
                        <div style="color : red">A user with this username already exists! Try making up a new one!</div>
                        <% }else if(errString.equals("REmpty")){%>
                        <div style="color : red">Please input your username and password to continue!</div>
                        <% }else if(errString.equals("RPassword")){ %>
                        <div style="color : red"> The Password given does not match! re-type both of your passwords. </div>
                        <% } %>
                    <form method="POST" action="Register.do">
                        <label for="rUsernameInput">Username</label>
                        <input class="u-full-width" type="text" placeholder=" " name="rUsernameInput" required>

                        <label for="rPasswordInput">Password</label>
                        <input class="u-full-width" type="password" placeholder=" " name="rPasswordInput" required>

			<label for="rPpasswordInput2">Re-Enter Password</label>
                        <input class="u-full-width" type="password" placeholder=" " name="rPasswordInput2" required>

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
