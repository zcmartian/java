package com.dianping.marszhou.smartweb.test;

import com.dianping.marszhou.smartweb.service.CustomerService;
import org.smart4j.helper.BeanHelper;
import org.smart4j.helper.ClassHelper;
import org.smart4j.helper.DatabaseHelper;
import com.dianping.marszhou.smartweb.model.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.smart4j.util.ClassUtil;

/**
 * Created by marszhou on 15/12/18.
 */
public class CustomerServiceTest {
    private static CustomerService customerService;

    static {
        ClassUtil.loadClass(DatabaseHelper.class.getName(), true);
        Set<Class<?>> set = ClassHelper.getServiceClassSet();
        if (!set.isEmpty() && set.size() ==1) {
            try {
                customerService = (CustomerService) Class.forName(CustomerService.class.getName()).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Before
    public void init() throws Exception {
        DatabaseHelper.executeSqlFile("sql/customer_init.sql");
    }

    @Test
    public void getCustomerListTest() throws Exception {
        List<Customer> customerList = customerService.getCustomerList();
        Assert.assertEquals(4, customerList.size());
    }

    @Test
    public void getCustomerTests() throws Exception {
        long id = 1;
        Customer customer = customerService.getCustomer(id);
        Assert.assertNotNull(customer);
        Assert.assertEquals("Jack", customer.getContact());
    }

    @Test
    public void createCustomerTests() throws Exception {
        Map<String, Object> fieldMap = new HashMap<String, Object>();
        fieldMap.put("name", "'customer4'");
        fieldMap.put("contact", "'JohnJohn'");
        fieldMap.put("phone", "'12310987987'");
        boolean result = customerService.createCustomer(fieldMap);
        Assert.assertTrue(result);
    }

    @Test
    public void updateCustomerTests() throws Exception {
        long id = 2;
        Map<String, Object> fieldMap = new HashMap<String, Object>();
        fieldMap.put("id", 2);
        fieldMap.put("name", "customer2");
        boolean result = customerService.updateCustomer(id, fieldMap);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteCustomerTests() throws Exception {
        long id = 1;
        boolean result = customerService.deleteCustomer(id);
        Assert.assertTrue(result);
    }
}
