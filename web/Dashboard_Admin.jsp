<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>

        <!-- Basic Page Needs
        ?????????????????????????????????????????????????? -->
        <meta charset="utf-8">
        <title>XYZ Administration</title>
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
    <% com.LoginSession login_session = (com.LoginSession) request.getSession().getAttribute("login_session"); %>
    <% String uname = login_session.getUsername();%>

    <div class="header">
        <form action="Logout.do" method="POST" ><input style="float: right;" type="submit" value="Logout"/></form>
        <h1 id="logo-text">XYZ</h1>

    </div>
    <div class="container">
        <h1><%out.print(uname);%>'s dashboard</h1>
        <div>

            <div class="dash-card">
                <!--<div class="dash-card-image" style="background-image: url(images/thumb-project-tRAYce.png);"></div>-->
                <a href="#" class="dash-card-title" target="_blank">All Claims</a>
                <div class="dash-card-content">
                    <table>
                        <thead>
                            <tr>
                                <th>Claim ID</th>
                                <th>Member Name</th>
                                <th>Date Created</th>
                                <th>Description</th>
                                <th>Amount</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listOfAllClaims}" var="item">

                                <tr>
                                    <td>#</td>
                                    <td>${item.username}</td>
                                    <td>${item.date}</td>
                                    <td>${item.rationale}</td>
                                    <td>${item.amount}</td>
                                    <td>${item.status}</td>
                                </tr>

                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="dash-card">
                <!--<div class="dash-card-image" style="background-image: url(images/thumb-project-tRAYce.png);"></div>-->
                <a href="#" class="dash-card-title" target="_blank">All Members</a>
                <div class="dash-card-content">
                    <table>
                        <thead>
                            <tr>
                                <th>User ID</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listOfAllUsers}" var="user">

                                <tr>
                                    <td>${user.username}</td>
                                    <td>${user.status}</td>
                                </tr>

                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>







        </div>
    </div>

    <!-- End Document
      ?????????????????????????????????????????????????? -->

</html>
