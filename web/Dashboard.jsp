<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>

        <!-- Basic Page Needs
        ?????????????????????????????????????????????????? -->
        <meta charset="utf-8">
        <title>XYZ Login</title>
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Mobile Specific Metas
        ?????????????????????????????????????????????????? -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- FONT
        ?????????????????????????????????????????????????? -->
        <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">

        <!-- CSS
        ?????????????????????????????????????????????????? -->
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/skeleton.css">
        <link rel="stylesheet" href="css/XYZ.css">

        <!-- Favicon
        ?????????????????????????????????????????????????? -->
        <link rel="icon" type="image/png" href="images/favicon.png">

    </head>


    <!-- Primary Page Layout
    ?????????????????????????????????????????????????? -->
    <% request.getSession().setAttribute("LoginError", "none"); %>
    <% model.LoginSession login_session = (model.LoginSession) request.getSession().getAttribute("login_session"); %>
    <% String uname = login_session.getUsername();%>

    <div class="header">
        <h1 id="logo-text">XYZ</h1>
    </div>
    <div class="container">
        <h1>Welcome to the dashboard!</h1>

        <div class="row">
            <h2>Your username is: <%out.print(uname);%></h2>
        </div>
        <div>
            <form action="Logout.do" method="POST"><input type="submit" value="Logout"/></form>
            <form action="ListClaims" method="GET"><input type="submit" value="List claims"/></form>

            <table>
                <thead>
                <tr>
                    <th>Claim ID</th>
                    <th>Description</th>
                    <th>Status</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listOfUserClaims}" var="item">
                    
                    <tr>
                        <td>#<td>
                        <td>${item.rationale}</td>
                        <td>${item.status}</td>
                    </tr>
                    
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- End Document
      ?????????????????????????????????????????????????? -->

</html>
