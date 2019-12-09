<%-- 
    Document   : MakePayment
    Created on : 25-Nov-2019, 13:40:27
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
        <link rel="icon" type="image/png" href="images/favicon.ico">

    </head>

    <!-- Load the required checkout.js script -->
    <script src="https://www.paypalobjects.com/api/checkout.js" data-version-4></script>

    <!-- Load the required Braintree components. -->
    <script src="https://js.braintreegateway.com/web/3.39.0/js/client.min.js"></script>
    <script src="https://js.braintreegateway.com/web/3.39.0/js/paypal-checkout.min.js"></script>

    <script>
        paypal.Button.render({
            braintree: braintree,
            // Other configuration
        }, '#id-of-element-where-paypal-button-will-render');
    </script>

    <body>

        <!-- Primary Page Layout
        –––––––––––––––––––––––––––––––––––––––––––––––––– -->
        <div class="container">
            <div class="row">
                <div class="one-half column" style="margin-top: 25%">
                    <h4>Make a payment</h4>
                    <form method="POST" action="MakePayment.do">

                        <label for="PaymentMethod">Payment method</label>
                        <input class="u-full-width" type="Text" placeholder="How are you gonna pay?" name="PaymentMethod" required>

                        <label for="PaymentAmount">Amount in (£)</label>
                        <input class="u-full-width" type="number" placeholder="£££££" name="PaymentAmount" required>

                        <input class="button-primary" type="submit" value="Payment" name="paymentButton">
                    </form>
                    <form method="POST" action="UserDashServlet"><input class="button" type="submit" value="Go back to dashboard"/></form>
                </div>
            </div>
        </div>

        <!-- End Document
          –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    </body>
</html>
