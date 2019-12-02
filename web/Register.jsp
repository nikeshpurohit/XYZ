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
                        
                        <label for="rUsernameInput">Username</label>
                        <input class="u-full-width" type="text" placeholder=" " name="rFirstNameInput" required>
                        
                        <label for="rFirstNameInput">First Name</label>
                        <input class="u-full-width" type="text" placeholder=" " name="rFirstNameInput" required>
                        
                        <label for="rSecondNaameInput">Second Name</label>
                        <input class="u-full-width" type="text" placeholder=" " name="rSecondNameInput" required>

                        <label for="rPasswordInput">Password</label>
                        <input class="u-full-width" type="password" placeholder=" " name="rPasswordInput" required>

			<label for="rPasswordInput2">Re-Enter Password</label>
                        <input class="u-full-width" type="password" placeholder=" " name="rPasswordInput2" required>
                        
			<label for="rE-mail">E-Mail Address</label>
                        <input class="u-full-width" type="text" placeholder=" " name="rEmail" required>

                        <label for="rDoB">Date of Birth</label>
                        <input class="u-full-width" type="text" placeholder=" " name="rDoB" required>
                        
			<label for="rAddress">Address</label>
                        <input class="u-full-width" type="text" placeholder=" " name="rAddress" required>
                        

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
