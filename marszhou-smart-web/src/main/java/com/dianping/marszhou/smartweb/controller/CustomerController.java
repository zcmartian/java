package com.dianping.marszhou.smartweb.controller;

import com.dianping.marszhou.smartweb.model.Customer;
import com.dianping.marszhou.smartweb.service.CustomerService;
import org.smart4j.annotation.Action;
import org.smart4j.annotation.Controller;
import org.smart4j.annotation.Inject;
import org.smart4j.bean.Data;
import org.smart4j.bean.Param;
import org.smart4j.bean.View;

import java.util.List;
import java.util.Map;

/**
 * Created by marszhou on 15/12/18.
 */
@Controller
public class CustomerController {
    @Inject
    private CustomerService customerService;

    @Action("get:/customer")
    public View index(Param param) {
        List<Customer> customerList = customerService.getCustomerList();
        return new View("customer.jsp").addModel("customerList", customerList);
    }

    @Action("get:/customer_show")
    public View show(Param param) {
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer_show.jsp").addModel("customer", customer);
    }

    @Action("get:/customer_create")
    public View create(Param param) {
        return new View("customer_create.jsp");
    }

    @Action("post:/customer_create")
    public Data creatSubmit(Param param) {
        Map<String, Object> fieldMap = param.getMap();
        boolean result = customerService.createCustomer(fieldMap);
        return new Data(result);
    }

    @Action("get:/customer_edit")
    public View edit(Param param) {
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer_edit.jsp").addModel("customer", customer);
    }

    @Action("put:/customer_edit")
    public Data editSubmit(Param param) {
        long id = param.getLong("id");
        Map<String, Object> fieldMap = param.getMap();
        boolean result = customerService.updateCustomer(id, fieldMap);
        return new Data(result);
    }

    @Action("get:/customer_delete")
    public Data delete(Param param) {
        long id = param.getLong("id");
        boolean result = customerService.deleteCustomer(id);
        return new Data(result);
    }
}
