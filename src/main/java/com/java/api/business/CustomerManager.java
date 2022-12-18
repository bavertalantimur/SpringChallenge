package com.java.api.business;

import com.java.api.dataAccess.ICustomerDal;
import com.java.api.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements ICustomerManager {
    @Autowired
    private ICustomerDal customerDal;
    public CustomerManager(ICustomerDal customerDal) {
        this.customerDal = customerDal;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerDal.addCustomer(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerDal.getAllCustomer();
    }

    @Override
    public void update(Customer customer) {
        customerDal.update(customer);
    }

    @Override
    public String deleteCustomer(Long id) {
         return customerDal.deleteCustomer(id);
    }
}
