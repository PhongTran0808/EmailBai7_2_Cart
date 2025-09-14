<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="css/main.css" type="text/css">
<h2>CD list</h2>
<table>
    <tr>

        <th>Description</th>
        <th>Price</th>
        <th></th>

    </tr>
    <%
        java.util.List<com.example.demo17_11_9_2025.model.Product> products =
                (java.util.List<com.example.demo17_11_9_2025.model.Product>) session.getAttribute("products");
        if (products != null) {
            for (com.example.demo17_11_9_2025.model.Product p : products) {
    %>
    <tr>
        <td><%= p.getDescription() %></td>
        <td>$<%= String.format("%.2f", p.getPrice()) %></td>
        <td>
            <form action="cart" method="post">
                <input type="hidden" name="action" value="add">
                <input type="hidden" name="code" value="<%= p.getCode() %>">
                <input type="number" name="quantity" value="1" min="1">
                <input type="submit" value="Add To Cart">
            </form>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

