package com.java.api.controller;

import com.java.api.business.ICustomerManager;
import com.java.api.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private ICustomerManager customerManager;
    @Autowired
    public CustomerController(ICustomerManager customerManager){
        this.customerManager=customerManager;
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Customer addCustomer(@RequestBody Customer customer){

        return customerManager.addCustomer(customer);
    }

    @GetMapping("/all")
    public List<Customer> getAlLCustomer(){
        return customerManager.getAllCustomer();
    }
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    public void update(@RequestBody Customer customer){
        customerManager.update(customer);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id){
        customerManager.deleteCustomer(id);
        return "successfully deleted";
    }





}
