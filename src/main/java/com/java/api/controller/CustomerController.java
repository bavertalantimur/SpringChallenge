package com.java.api.controller;

import com.java.api.business.ICustomerManager;
import com.java.api.dto.CustomerDto;
import com.java.api.dto.CustomerResponses;
import com.java.api.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerManager customerManager;

    private final ModelMapper modelMapper;

    public CustomerController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity<CustomerResponses> create(@RequestBody CustomerDto customerDto){

        try {
            customerManager.create(customerDto);
            return ResponseEntity.status(202).body(new CustomerResponses(202,"success","new customer created"));
        }catch (Exception e){
            return ResponseEntity.status(424).body(new CustomerResponses(424,"fail","can not be created"));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<CustomerResponses> getAlLCustomer(){
        try {
            List<CustomerDto> companyDtoList=customerManager.getAllCustomer();
            return ResponseEntity.status(200).body(new CustomerResponses(200,"succes","all customer listed gracefully",companyDtoList));

        }catch (Exception e){
            return ResponseEntity.status(404).body(new CustomerResponses(400,"fail","all customer not listed"));
        }
    }
    @PutMapping("update/{id}")
    public ResponseEntity<CustomerResponses> update(@RequestBody CustomerDto customerDto,@PathVariable Long id){
        try {
            customerManager.update(customerDto,id);
            return ResponseEntity.status(200).body(new CustomerResponses(200,"success","company updated"));
        }catch (Exception e){
            return ResponseEntity.status(400).body(new CustomerResponses(400,"fail","can not be updated"));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CustomerResponses> deleteCustomer(@PathVariable Long id){
        try {
            customerManager.deleteCustomer(id);
            return ResponseEntity.status(204).body(new CustomerResponses(204,"success","successfully deleted"));
        }catch (Exception e){
            return ResponseEntity.status(400).body(new CustomerResponses(400,"fail","not deleted"));
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<CustomerResponses> getCustomerById(@PathVariable Long id){
        try {
            CustomerDto customerDto=customerManager.getCustomerById(id);
            return ResponseEntity.status(200).body(new CustomerResponses(200,"success","Company find by id",List.of(customerDto)));
        }catch (Exception e){
            return ResponseEntity.status(400).body(new CustomerResponses(400,"fail","not find id"));
        }
    }




}
