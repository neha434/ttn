package com.springboot.ecommerceApplication.controller;

import com.springboot.ecommerceApplication.co.CustomerCO;
import com.springboot.ecommerceApplication.dto.CustomerDto;
import com.springboot.ecommerceApplication.repositories.CustomerRepo;
import com.springboot.ecommerceApplication.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepo customerRepository;
    @Autowired
    CustomerService customerService;

    @GetMapping("/{id}")
    public CustomerDto getCustomer(@PathVariable Integer id){
        return  customerService.getCustomer(id);
    }

    @PostMapping("/")
    public CustomerDto registerCustomer(@RequestBody CustomerCO customerCO, WebRequest webRequest){
        return customerService.registerCustomer(customerCO);
    }

    @PutMapping("/{id}")
    public CustomerDto updateCustomer(@PathVariable Integer id,@RequestBody CustomerCO customerCO , WebRequest webRequest){
        return  customerService.updateCustomer(id,customerCO);
    }

    @DeleteMapping("/{id}")
    public Map<String,Boolean> deleteUser(@PathVariable Integer id){
        return customerService.deleteCustomer(id);
    }

    @GetMapping("/")
    public List<CustomerDto> getAllCustomer(){
        return  customerService.getAllCustomer();
    }

}