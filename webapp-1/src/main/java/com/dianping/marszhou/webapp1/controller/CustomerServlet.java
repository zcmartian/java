package com.dianping.marszhou.webapp1.controller;

import com.dianping.marszhou.webapp1.helper.DatabaseHelper;
import com.dianping.marszhou.webapp1.model.Customer;
import com.dianping.marszhou.webapp1.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by marszhou on 15/12/18.
 */
@WebServlet("/customer")
public class CustomerServlet extends HttpServlet{
    private CustomerService customerService;
    @Override
    public void init() throws ServletException {
        customerService = CustomerService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Customer> customerList = customerService.getCustomerList();
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("/WEB-INF/view/customer.jsp").forward(request, response);
    }
}
