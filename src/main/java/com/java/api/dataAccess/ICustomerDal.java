package com.java.api.dataAccess;
import com.java.api.dto.CustomerDto;
import com.java.api.entities.Customer;

import java.util.List;

public interface ICustomerDal {
   Customer addCustomer(Customer customer);
   List<Customer> getAllCustomer();
   Customer update(Customer customer);
   String deleteCustomer(Long id);

   Customer getCustomerById(Long id);


}
