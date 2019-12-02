<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <link rel="icon" type="image/png" href="images/favicon.ico">

    </head>


    <!-- Primary Page Layout
    ?????????????????????????????????????????????????? -->
    <% request.getSession().setAttribute("LoginError", "none"); %>
    <% com.LoginSession login_session = (com.LoginSession) request.getSession().getAttribute("login_session"); %>
    <% String uname = login_session.getUsername();%>
    <div class="header">
        <form action="Logout.do" method="POST" ><input class="logout" type="submit" value="Logout"/></form>
        <h1 id="logo-text">XYZ</h1>
    </div>
    <div class="container">
        <h1><%out.print(uname);%>'s Dashboard</h1>
        <div class="section-grid">
            <div class="dash-card-half">
                <!--<div class="dash-card-image" style="background-image: url(images/thumb-project-tRAYce.png);"></div>-->
                <a href="#" class="dash-card-title" target="_blank">Your Profile</a>
                <div class="dash-card-content">
                    <table style="width:100%">
                        <tr>
                            <th>Name:</th>
                            <td>Nikesh</td>
                        </tr>
                        <tr>
                            <th>Address:</th>
                            <td>345 Downend Road, Bristol</td>
                        </tr>
                        <tr>
                            <th>Date of birth:</th>
                            <td>34/05/39</td>
                        </tr>
                    </table>
                    <form action="" method="POST"><input class="button-primary" style="float: right;" type="submit" value="Edit Details"/></form>
                </div>
            </div>

            <div>
                <div class="dash-card-half-right">
                    <!--<div class="dash-card-image" style="background-image: url(images/thumb-project-tRAYce.png);"></div>-->
                    <div class="dash-card-title" target="_blank">Your Account Balance</div>
                    <div class="dash-card-content">
                        <h1>£0.00</h1>
                    </div>
                </div>
            </div>




            <div class="dash-card">
                <!--<div class="dash-card-image" style="background-image: url(images/thumb-project-tRAYce.png);"></div>-->
                <a href="#" class="dash-card-title" target="_blank">Your Claims History</a>
                <div class="dash-card-content">
                    <table>
                        <thead>
                            <tr>
                                <th>Claim ID</th>
                                <th>Date Created</th>
                                <th>Description</th>
                                <th>Amount</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listOfUserClaims}" var="item">      
                                <tr>
                                    <td>#</td>
                                    <td>${item.date}</td>
                                    <td>${item.rationale}</td>
                                    <td>${item.amount}</td>
                                    <td>${item.status}</td>
                                </tr>                 
                            </c:forEach>
                        </tbody>
                    </table>
                    <form action="/XYZ/MakeClaims.jsp" method="POST"><input class="button-primary" style="float: right;" type="submit" value="New Claim"/></form>
                </div>
            </div>

            <div class="dash-card">
                <!--<div class="dash-card-image" style="background-image: url(images/thumb-project-tRAYce.png);"></div>-->
                <a href="#" class="dash-card-title" target="_blank">Your Transaction History</a>
                <div class="dash-card-content">
                    <table>
                        <thead>
                            <tr>
                                <th>Transaction ID</th>
                                <th>Transaction Date</th>
                                <th>Amount</th>
                                <th>Payment Method</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listOfUserPayments}" var="payment">
                                <tr>
                                    <td>#</td>
                                    <td>${payment.date}</td>
                                    <td>${payment.amount}</td>
                                    <td>${payment.typeOfPayment}</td>
                                </tr>

                            </c:forEach>
                        </tbody>
                    </table>
                    <form action="/XYZ/MakePayment.jsp" method="POST"><input class="button-primary" style="float: right;" type="submit" value="Make payment"/></form>

                </div>
            </div>
        </div>

    </div>
</div>
</div>

<!-- End Document
  ?????????????????????????????????????????????????? -->

</html>
