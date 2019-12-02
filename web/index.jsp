<!DOCTYPE html>
<html lang="en">
    <head>

        <!-- Basic Page Needs
        –––––––––––––––––––––––––––––––––––––––––––––––––– -->
        <meta charset="utf-8">
        <title>XYZ Drivers Association</title>
        <meta name="description" content="">
        <meta name="author" content="">

        <meta http-equiv = "refresh" content = "2; url = /XYZ/Login.jsp" />
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
        <link rel="stylesheet" href="css/XYZ.css">

        <!-- Favicon
        –––––––––––––––––––––––––––––––––––––––––––––––––– -->
        <link rel="icon" type="image/png" href="images/favicon.ico">

    </head>
    <body>

        <!-- Primary Page Layout
        –––––––––––––––––––––––––––––––––––––––––––––––––– -->
        <% request.getSession().setAttribute("LoginError", "none"); %>
        <% request.getSession().setAttribute("RegisterError", "none"); %>
        <% request.getSession().setAttribute("RegisterSuccess", "none");%>
        
        <div>
            <h1 id="centered-h1">XYZ Drivers Association</h1>
            <h3 id="centered-h3">please wait while you are directed to the login page</h3>
        </div>

        <!-- End Document
          –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    </body>
</html>
