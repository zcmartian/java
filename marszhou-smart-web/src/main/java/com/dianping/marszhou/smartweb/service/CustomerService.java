package com.dianping.marszhou.smartweb.service;

import com.dianping.marszhou.smartweb.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.annotation.Service;
import org.smart4j.helper.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by marszhou on 15/12/18.
 */
@Service
public class CustomerService {

    // private static class CustomerServiceHolder {
    // private static final CustomerService INSTANCE = new CustomerService();
    // }
    //
    // private CustomerService(){}
    //
    // public static final CustomerService getInstance() {
    // return CustomerServiceHolder.INSTANCE;
    // }

    private static final Logger LOGGER = LoggerFactory
            .getLogger(CustomerService.class);

    public List<Customer> getCustomerList() {
        List<Customer> customerList = new ArrayList<Customer>();
        // Connection conn = DatabaseHelper.getConnection();
        String sql = "select * from customer";
        return DatabaseHelper.queryEntityList(Customer.class,/* conn, */sql);
    }

    public Customer getCustomer(long id) {
        String sql = "select * from customer where id=" + id;
        return DatabaseHelper.queryEntity(Customer.class, sql);
    }

    public boolean createCustomer(Map<String, Object> fieldMap) {
        String sql = "insert into customer values (" + fieldMap.get("id") + ","
                + fieldMap.get("name") + ", " + fieldMap.get("contact") + ","
                + fieldMap.get("phone") + ", " + fieldMap.get("email") + ", "
                + fieldMap.get("remark") + ")";
        return DatabaseHelper.insertEntity(Customer.class, sql);
    }

    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        String sql = "update customer set name='" + fieldMap.get("name")
                + "' where id =" + fieldMap.get("id");
        return DatabaseHelper.updateEntity(Customer.class, sql);
    }

    public boolean deleteCustomer(long id) {
        String sql = "delete from customer where id=" + id;
        return DatabaseHelper.deleteEntity(Customer.class, sql);
    }
}
