<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="css/main.css" type="text/css">

<h2>Your cart</h2>
<table>
    <tr>
        <th>Quantity</th>
        <th>Description</th>
        <th>Price</th>
        <th>Amount</th>
        <th></th>
    </tr>
    <%
        com.example.demo17_11_9_2025.model.Cart cart =
                (com.example.demo17_11_9_2025.model.Cart) session.getAttribute("cart");
        if (cart != null) {
            for (com.example.demo17_11_9_2025.model.CartItem item : cart.getItems()) {
    %>
    <tr>
        <!-- Update vẫn dùng POST -->
        <td>
            <form action="cart" method="post">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="code" value="<%= item.getProduct().getCode() %>">
                <input type="number" name="quantity" value="<%= item.getQuantity() %>" min="0">
                <input type="submit" value="Update">
            </form>
        </td>
        <td><%= item.getProduct().getDescription() %></td>
        <td>$<%= String.format("%.2f", item.getProduct().getPrice()) %></td>
        <td>$<%= String.format("%.2f", item.getTotal()) %></td>
        <!-- Remove chuyển thành GET link -->
        <td>
            <a href="cart?action=remove&code=<%= item.getProduct().getCode() %>">Remove Item</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

<p><b>Total: </b> $<%= cart != null ? String.format("%.2f", cart.getTotal()) : "0.00" %></p>

<div class="form-center">
    <form action="checkout" method="post" style="display:inline;">
        <input type="submit" value="Checkout">
    </form>

    <form action="loadProducts" method="get" style="display:inline;">
        <input type="submit" value="Continue Shopping">
    </form>
</div>
