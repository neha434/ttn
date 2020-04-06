package com.springboot.ecommerceApplication.services;

import com.springboot.ecommerceApplication.co.CustomerCO;
import com.springboot.ecommerceApplication.domain.Role;
import com.springboot.ecommerceApplication.domain.user.Customer;
import com.springboot.ecommerceApplication.dto.CustomerDto;
import com.springboot.ecommerceApplication.exception.AccountDoesNotExists;
import com.springboot.ecommerceApplication.exception.CustomerAlreadyExistsException;
import com.springboot.ecommerceApplication.repositories.CustomerRepo;
import com.springboot.ecommerceApplication.repositories.RoleRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepository;
    @Autowired
    RoleRepo roleRepository;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    //PasswordEncoder confirmPasswordEncoder = new BCryptPasswordEncoder();

    public CustomerDto registerCustomer(CustomerCO customerCO){
        Customer customer = customerRepository.findByEmail(customerCO.getEmail());
        if(customer != null){
            throw new CustomerAlreadyExistsException("Account Already Exist With This Email Id");
        }
        Customer registerCustomer = new Customer();

        registerCustomer.setEmail(customerCO.getEmail());
        registerCustomer.setFirstName(customerCO.getFirstName());
        registerCustomer.setMiddleName(customerCO.getMiddleName());
        registerCustomer.setLastName(customerCO.getLastName());
        registerCustomer.setPassword(passwordEncoder.encode(customerCO.getPassword()));
       // registerCustomer.setPassword((confirmPasswordEncoder.encode(customerCO.getConfirmPassword())));
        registerCustomer.setContact(customerCO.getContact());
        List<Role> roleList = new ArrayList<>();

        roleList.add(roleRepository.findByAuthority("ROLE_CUSTOMER"));
        registerCustomer.setRoleList(roleList);

        customerRepository.save(registerCustomer);

        CustomerDto customerDto = getCustomer(registerCustomer.getId());
        return customerDto;
    }
    public CustomerDto getCustomer(Integer id){

        Optional<Customer> optional = customerRepository.findById(id);
        if(!optional.isPresent()){
            throw new AccountDoesNotExists("Invalid Account Credentials");
        }
        Customer customer = optional.get();
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setEmail(customer.getEmail());
        customerDto.setFirstName(customer.getFirstName());
        if(customer.getMiddleName() != null){
            customerDto.setMiddleName(customer.getMiddleName());
        }
        customerDto.setLastName(customer.getLastName());
        customerDto.setContact(customer.getContact());

        return  customerDto;
    }

    public List<CustomerDto> getAllCustomer(){
        Iterable<Customer> customersList= customerRepository.findAll();
        List<CustomerDto> customerDtoList = new ArrayList<>();
        customersList.forEach(customers -> customerDtoList.add(new CustomerDto(customers.getId(),customers.getEmail(),
                customers.getFirstName(),
                customers.getMiddleName(),customers.getLastName(),customers.getContact())));
        return customerDtoList;
    }

    public CustomerDto updateCustomer(Integer id,CustomerCO customerCO){


        if (!customerRepository.findById(id).isPresent()){
            throw new AccountDoesNotExists("Invalid Account Credentials");
        }

    Customer customer = customerRepository.findById(id).get();
        BeanUtils.copyProperties(customerCO, customer);
        customerRepository.save(customer);
        CustomerDto customerDto = getCustomer(customer.getId());
        return customerDto;
    }

    public Map<String,Boolean> deleteCustomer(Integer id){
        Map<String,Boolean> map = new HashMap<>();
        Optional<Customer> optional = customerRepository.findById(id);

        if(!optional.isPresent()){
            map.put("Deleted",false);
        }
        else {
            customerRepository.deleteById(id);
            map.put("Deleted",true);
        }
        return map;
    }
}