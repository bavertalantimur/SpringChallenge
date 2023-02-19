package com.java.api.business;

import com.java.api.dto.CustomerDto;
import com.java.api.entities.Customer;

import java.util.List;

public interface ICustomerManager {
    void create(CustomerDto customerDto);
    List<CustomerDto> getAllCustomer();
    void update(CustomerDto customerDto,Long id);

    String deleteCustomer(Long id);

    CustomerDto getCustomerById(Long id);
}
