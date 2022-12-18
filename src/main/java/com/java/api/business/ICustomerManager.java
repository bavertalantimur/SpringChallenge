package com.java.api.business;

import com.java.api.entities.Customer;

import java.util.List;

public interface ICustomerManager {
    Customer addCustomer(Customer customer);
    List<Customer> getAllCustomer();
    void update(Customer customer);

    String deleteCustomer(Long id);
}
