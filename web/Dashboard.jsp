<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                    <c:if test="${memberDetails == null}">
                        <p> Your registration is incomplete!
                        </c:if>
                        <c:if test="${memberDetails != null}">
                            <c:forEach items="${memberDetails}" var="item">
                            <table style="width:100%">
                                <tr>
                                    <th>Name:</th>
                                    <td>${item.name}</td>
                                </tr>
                                <tr>
                                    <th>Address:</th>
                                    <td>${item.address}</td>
                                </tr>
                                <tr>
                                    <th>Date of birth:</th>
                                    <td>${item.dob}</td>
                                </tr>
                            </table>
                        </c:forEach>
                    </c:if>
                    <form action="" method="POST"><input class="button-primary" style="float: right;" type="submit" value="Edit Details"/></form>
                </div>
            </div>

            <div>
                <div class="dash-card-half-right">
                    <!--<div class="dash-card-image" style="background-image: url(images/thumb-project-tRAYce.png);"></div>-->
                    <div class="dash-card-title" target="_blank">Your Account Balance</div>
                    <div class="dash-card-content">
                        <c:forEach items="${memberDetails}" var="item">
                            <c:if test="${item.balance < 0}">
                                <h1 style="color: red;">£<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${item.balance}"/></h1>
                            </c:if>
                            <c:if test="${item.balance >= 0}">
                                <h1>£<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${item.balance}"/></h1>  
                            </c:if>


                        </c:forEach>
                    </div>
                </div>


                <div class="dash-card-half-right">
                    <!--<div class="dash-card-image" style="background-image: url(images/thumb-project-tRAYce.png);"></div>-->
                    <div class="dash-card-title" target="_blank">Your Account Status</div>
                    <div class="dash-card-content">
                        <h1><c:out value='${user.status}'/> </h1>       
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
