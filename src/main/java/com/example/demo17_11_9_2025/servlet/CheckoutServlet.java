package com.example.demo17_11_9_2025.servlet;

import com.example.demo17_11_9_2025.model.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class CheckoutServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        request.setAttribute("cart", cart);

        String url = "/checkout.jsp";
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
