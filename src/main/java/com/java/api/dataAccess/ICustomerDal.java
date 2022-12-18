package com.java.api.dataAccess;
import com.java.api.entities.Customer;

import java.util.List;

public interface ICustomerDal {
   Customer addCustomer(Customer customer);
   List<Customer> getAllCustomer();
   public void update(Customer customer);
   String deleteCustomer(Long id);


}
