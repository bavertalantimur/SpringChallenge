package com.java.api.security;

import com.java.api.dataAccess.CustomerDal;
import com.java.api.entities.Customer;
import com.java.api.repository.CustomerRepository;
import org.apache.catalina.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailServiceImpl implements UserDetailsService {


    private CustomerRepository customerRepository;
    public CustomerDetailServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String mailadress) throws UsernameNotFoundException {
       // Customer user=customerRepository.findByE(mailadress);
        return null;//JwtUserDetails.create(user);
    }
    public UserDetails loadUserById(Long id){
        Customer customer=customerRepository.findById(id).get();
        return JwtUserDetails.create(customer);
    }
}
