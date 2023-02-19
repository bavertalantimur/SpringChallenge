package com.java.api.business;

import com.java.api.dataAccess.ICustomerDal;
import com.java.api.dto.CustomerDto;
import com.java.api.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerManager implements ICustomerManager {
    @Autowired
    private ICustomerDal customerDal;

    private final ModelMapper modelMapper;

    public CustomerManager(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(CustomerDto customerDto) {
        Customer customer=modelMapper.map(customerDto,Customer.class);
         customerDal.addCustomer(customer);
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        List<CustomerDto> customerDtos=new ArrayList<>();
        customerDal.getAllCustomer().forEach(customer -> customerDtos.add(modelMapper.map(customer,CustomerDto.class)));
        return customerDtos;
    }

    @Override
    public void update(CustomerDto customerDto,Long id) {
        Customer customer=modelMapper.map(customerDto,Customer.class);
        customer.setId(id);
        customerDal.update(customer);
    }

    @Override
    public String deleteCustomer(Long id) {
         return customerDal.deleteCustomer(id);
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        CustomerDto customerDto=modelMapper.map(customerDal.getCustomerById(id),CustomerDto.class);
        return customerDto;
    }
}
