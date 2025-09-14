package com.example.demo17_11_9_2025.servlet;

import com.example.demo17_11_9_2025.model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class CartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        String action = request.getParameter("action");
        if (action == null) action = "cart";

        if (action.equals("add")) {
            String code = request.getParameter("code");
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            List<Product> products = (List<Product>) session.getAttribute("products");
            for (Product p : products) {
                if (p.getCode().equals(code)) {
                    cart.addItem(p, quantity);
                    break;
                }
            }
        } else if (action.equals("update")) {
            String code = request.getParameter("code");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            cart.updateItem(code, quantity);
        } else if (action.equals("remove")) {
            String code = request.getParameter("code");
            cart.updateItem(code, 0); // quantity = 0 ⇒ xoá
        }

        getServletContext().getRequestDispatcher("/cart.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // gọi lại doPost để xử lý GET như POST
        doPost(request, response);
    }
}
