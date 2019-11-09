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
            <label for="usernameInput">Username</label>
            <input class="u-full-width" type="text" placeholder=" " id="usernameInput">

            <label for="passwordInput">Password</label>
            <input class="u-full-width" type="password" placeholder=" " id="passwordInput">

            <input class="button-primary" type="submit" value="Login">
            <input class="button" type="submit" value="Sign up">
            <p> The current date over there is: <%= new java.util.Date() %> </p>
        </div>
    </div>
  </div>

<!-- End Document
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
</body>
</html>
