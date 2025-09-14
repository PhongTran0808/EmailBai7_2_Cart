<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="css/main.css" type="text/css">

<div class="form-center">
<h2>Payment Successful</h2>
<p>Thank you for your purchase! Your payment has been confirmed.</p>

<%
    String paymentMethod = (String) request.getAttribute("paymentMethod");
    if (paymentMethod != null)
    {
        String methodName = "";
        if ("credit".equals(paymentMethod)) methodName = "Credit Card";
        else if ("paypal".equals(paymentMethod)) methodName = "PayPal";
        else if ("cod".equals(paymentMethod)) methodName = "Cash on Delivery";
%>
<p><b>Payment Method: </b><%= methodName %></p> <br>
<%
    }
%>


    <form action="loadProducts" method="get">
        <input type="submit" value="Back to Shopping">
    </form>
</div>



