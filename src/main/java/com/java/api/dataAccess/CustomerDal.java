package com.java.api.dataAccess;

import com.java.api.dto.CustomerDto;
import com.java.api.entities.Customer;
import com.java.api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDal implements ICustomerDal{
    @Autowired
    private CustomerRepository customerRepository;

    CustomerDal(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }


    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer update(Customer customer) {
        Customer customer1=customerRepository.findById(customer.getId()).orElse(null);

        if(!customer1.getFirstName().isEmpty())
            customer1.setFirstName(customer.getFirstName());//f:alihan
        if(!customer1.getLastName().isEmpty()) //
            customer1.setLastName(customer.getLastName());
         return customerRepository.save(customer);
    }

    @Override
    public String deleteCustomer(Long id) {
        customerRepository.deleteById(id);
        return "successfully deleted";
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }


}
