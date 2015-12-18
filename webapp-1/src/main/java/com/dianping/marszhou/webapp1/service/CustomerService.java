package com.dianping.marszhou.webapp1.service;

import com.dianping.marszhou.webapp1.helper.DatabaseHelper;
import com.dianping.marszhou.webapp1.model.Customer;
import com.dianping.marszhou.webapp1.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by marszhou on 15/12/18.
 */
public class CustomerService {

    private static class CustomerServiceHolder {
        private static final CustomerService INSTANCE = new CustomerService();
    }

    private CustomerService(){}

    public static final CustomerService getInstance() {
        return CustomerServiceHolder.INSTANCE;
    }

    private static final Logger LOGGER = LoggerFactory
            .getLogger(CustomerService.class);


    public List<Customer> getCustomerList() {
        List<Customer> customerList = new ArrayList<Customer>();
//        Connection conn = DatabaseHelper.getConnection();
        try {
            String sql = "select * from customer";
//            conn = DatabaseHelper.getConnection();
            return DatabaseHelper.queryEntityList(Customer.class,/* conn, */sql);
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            ResultSet resultSet = stmt.executeQuery();
//            while (resultSet.next()) {
//                Customer customer = new Customer();
//                customer.setId(resultSet.getLong("id"));
//                customer.setName(resultSet.getString("name"));
//                customer.setContact(resultSet.getString("contact"));
//                customer.setPhone(resultSet.getString("phone"));
//                customer.setEmail(resultSet.getString("email"));
//                customer.setRemark(resultSet.getString("remark"));
//                customerList.add(customer);
//            }
//        } catch (SQLException e) {
//            LOGGER.error("execute sql failure", e);
        } finally {
//            DatabaseHelper.closeConnection(conn);
//            return customerList;
        }
    }

    public Customer getCustomer(long id) {
        String sql = "select * from customer where id=" + id;
        return DatabaseHelper.queryEntity(Customer.class, sql);
    }

    public boolean createCustomer(Map<String, Object> fieldMap) {
        String sql = "insert into customer values ("+ fieldMap.get("id") + "," + fieldMap.get("name")
                + ", " + fieldMap.get("contact") + "," + fieldMap.get("phone")
                + ", " + fieldMap.get("email") + ", " + fieldMap.get("remark") + ")";
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
