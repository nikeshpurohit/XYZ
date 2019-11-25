<%-- 
    Document   : Make_Payments
    Created on : 24-Nov-2019, 22:08:09
    Author     : Karl Sartorio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>

        <!-- Basic Page Needs
        –––––––––––––––––––––––––––––––––––––––––––––––––– -->
        <meta charset="utf-8">
        <title>XYZ Make Claims</title>
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
                    <h4>XYZ Driver Association - Making Claims</h4>
                        <!---<%! String errString = ""; %>
                        <% errString  = (String) session.getAttribute("username");%>
                        <% if(errString.equals("errMemID")){ %>
                        <div style="color : red">UserID incorrect! please re-type the username</div>
                        <% }else if(errString.equals("errEmpty")){%>
                        <div style="color : red">Empty Field was detected! Please fill all fields </div>
                        <% }else if(errString.equals("errEmptyDesc")){ %>
                        <div style="color : red">Please Fill The Description field </div>
                        <% } %>--->
                    <form method="POST" action="MakeClaims.do">

                        <label for="ClaimsDate">Date of incident</label>
                        <input class="u-full-width" type="datetime-loc" placeholder="00/00/0000 " name="ClaimDate" required>

			<label for="ClaimsDesc">Description</label>
                        <input class="u-full-width" type="text" placeholder="What happend " name="ClaimsRationale" required>

			<label for="ClaimsAmount">Amount in (£)</label>
                        <input class="u-full-width" type="text" placeholder="£0 - x " name="ClaimsAmount" required>


                        <input class="button-primary" type="submit" value="Claim" name="claimButton"/>
                        </form>
                    <form method="POST" action="UserDashServlet"><input class="button" type="submit" value="Go back to dashboard"/></form>
                </div>
            </div>
        </div>

        <!-- End Document
          –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    </body>
</html>
