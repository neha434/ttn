package com.springboot.ecommerceApplication.repositories;

import com.springboot.ecommerceApplication.domain.user.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer,Integer> {
    Customer findByEmail(String email);
}