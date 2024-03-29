<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<script>
    function show_alert() {
        if (!confirm("re you sure you want to charge all members the yearly fee? This should only be done once a year.")) {
            return false;
        }
        this.form.submit();
    }


</script>

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
        <link rel="icon" type="image/png" href="images/favicon.ico">

    </head>


    <!-- Primary Page Layout
    ?????????????????????????????????????????????????? -->
    <% request.getSession().setAttribute("LoginError", "none"); %>
    <% com.LoginSession login_session = (com.LoginSession) request.getSession().getAttribute("login_session"); %>
    <% String uname = login_session.getUsername();%>

    <div class="header">
        <form action="Logout.do" method="POST" ><input style="float: right;" type="submit" value="Logout"/></form>
        <h1 id="logo-text">XYZ Drivers Association</h1>

    </div>
    <div class="container">
        <h1><%out.print(uname);%>'s dashboard</h1>
        <form method="POST" action="ChargeYearlyFee.do" onSubmit="if(!confirm('Are you sure you want to charge the yearly fee to all members? This should only be done once a year.')){return false;}""><button class="button-primary" type="submit">Charge yearly fee</button></form>
        <div class="section-grid">

            <div class="dash-card">
                <a class="dash-card-title">All Claims</a>
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
                                <th>Close</th>
                                <th>Reject</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listOfAllClaims}" var="item" varStatus="loop">

                                <tr>
                                    <td>${item.id}</td>
                                    <td>${item.username}</td>
                                    <td>${item.date}</td>
                                    <td>${item.rationale}</td>
                                    <td>${item.amount}</td>
                                    <td>${item.status}</td>
                                    <td><form method="POST" action="CloseClaim.do"><button class="button" style="width: 20px; height: 20px; padding: 0px;" value="${item.id}">&#10004;</button>
                                            <input type="hidden" name="closeClaimClick" value="${item.id}" ></form></td>
                                    <td><form method="POST" action="RejectClaim.do"><button class="button" style="width: 20px; height: 20px; padding: 0px;" value="${item.id}">&#10539;</button>
                                            <input type="hidden" name="rejectClaimClick" value="${item.id}" ></form></td>
                                </tr>

                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="dash-card">
                <a class="dash-card-title">Members Awaiting Approval</a>
                <div class="dash-card-content">
                    <table>
                        <thead>
                            <tr>
                                <th>Member Name</th>
                                <th>Address</th>
                                <th>Date of birth</th>
                                <th>Registration date</th>
                                <th>Account balance</th>
                                <th>Status</th>
                                <th>Approve</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listOfAppliedUsers}" var="member">

                                <tr>
                                    <td>${member.name}</td>
                                    <td>${member.address}</td>
                                    <td>${member.dob}</td>
                                    <td>${member.dor}</td>
                                    <td>${member.balance}</td>
                                    <td>${member.status}</td>
                                    <td><form method="POST" action="ApproveMember.do"><button class="button" style="width: 20px; height: 20px; padding: 0px;" value="${member.id}">&#10004;</button>
                                            <input type="hidden" name="approveMemClick" value="${member.id}" ></form></td>
                                </tr>



                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="dash-card">
                <a class="dash-card-title">Transaction History</a>
                <div class="dash-card-content">
                    <table>
                        <thead>
                            <tr>
                                <th>Member Name</th>
                                <th>Amount</th>
                                <th>Payment Method</th>
                                <th>Date</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listOfAllPayments}" var="item">

                                <tr>
                                    <td>${item.username}</td>
                                    <td>${item.amount}</td>
                                    <td>${item.typeOfPayment}</td>
                                    <td>${item.date}</td>
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
