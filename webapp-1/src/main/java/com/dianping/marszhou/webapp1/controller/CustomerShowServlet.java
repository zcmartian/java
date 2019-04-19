package com.dianping.marszhou.webapp1.controller;

import com.dianping.marszhou.webapp1.model.Customer;
import com.dianping.marszhou.webapp1.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by marszhou on 15/12/18.
 */
@WebServlet("/customer_show")
public class CustomerShowServlet extends HttpServlet {
    private CustomerService customerService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        customerService = CustomerService.getInstance();
        long id = Long.parseLong(request.getParameter("id"));
        Customer customer = customerService.getCustomer(id);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("/WEB-INF/view/customer_show.jsp").forward(request, response);
    }
}
