package com.example.demo17_11_9_2025.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ConfirmPaymentServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException
    {

        String paymentMethod = request.getParameter("paymentMethod");
        request.setAttribute("paymentMethod", paymentMethod);

        String url = "/confirmation.jsp";
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
