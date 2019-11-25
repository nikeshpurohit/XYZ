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
        <form action="Logout.do" method="POST" ><input style="float: right;" id="logo-text" type="submit" value="Logout"/></form>
        <h1 id="logo-text">XYZ</h1>
    </div>
    <div class="container">
        <h1>Welcome to the dashboard!</h1>

        <div class="row">
            <h2>Your username is: <%out.print(uname);%></h2>
        </div>
        
        <form action="/XYZ/MakeClaims.jsp" method="POST"><input style="float: right;" type="submit" value="Make a Claim!"/></form>
        <form action="/XYZ/MakePayment.jsp" method="POST"><input style="float: left;" type="submit" value="Make a Payment!"/></form>

        <h1 id="logo-text">XYZ</h1>
        <div>

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
        </div>
    </div>

    <!-- End Document
      ?????????????????????????????????????????????????? -->

</html>
