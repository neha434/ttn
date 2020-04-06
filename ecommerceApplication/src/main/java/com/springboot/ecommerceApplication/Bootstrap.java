package com.springboot.ecommerceApplication;

import com.springboot.ecommerceApplication.domain.Role;
import com.springboot.ecommerceApplication.domain.user.Customer;
import com.springboot.ecommerceApplication.domain.user.Seller;
import com.springboot.ecommerceApplication.domain.user.User;
import com.springboot.ecommerceApplication.repositories.CustomerRepo;
import com.springboot.ecommerceApplication.repositories.RoleRepo;
import com.springboot.ecommerceApplication.repositories.SellerRepo;
import com.springboot.ecommerceApplication.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap implements ApplicationRunner {

    @Autowired
    RoleRepo roleRepository;

    @Autowired
    UserRepo userRepository;

    @Autowired
    CustomerRepo customerRepository;

    @Autowired
    SellerRepo sellerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(userRepository.count()<1){
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            Role roleAdmin = new Role(1,"ROLE_ADMIN");
            roleRepository.save(roleAdmin);
            Role roleSeller = new Role(2,"ROLE_SELLER");
            roleRepository.save(roleSeller);
            Role roleCustomer = new Role(3,"ROLE_CUSTOMER");
            roleRepository.save(roleCustomer);

            User appUser = new User();
            appUser.setEmail("neha.rai@tothenew.com");
            appUser.setFirstName("Neha");
            appUser.setMiddleName("");
            appUser.setLastName("Rai");
            appUser.setPassword(passwordEncoder.encode("neharai"));
            appUser.setActive(true);
            appUser.setDeleted(false);

            List<Role> roleList = new ArrayList<>();
            roleList.add(roleAdmin);
            appUser.setRoleList(roleList);

            Seller seller = new Seller();
            seller.setEmail("pragati.singhal@gmail.com");
            seller.setFirstName("Pragati");
            seller.setLastName("Singhal");
            seller.setPassword(passwordEncoder.encode("pragati"));
            seller.setActive(true);
            seller.setDeleted(false);
            seller.setCompanyContact("Company Contact");
            seller.setCompanyName("Company Name");
            seller.setGst("GST");

            List<Role> sellerRoleList = new ArrayList<>();
            sellerRoleList.add(roleSeller);
            seller.setRoleList(sellerRoleList);

            Customer customer = new Customer();
            customer.setEmail("Riya.gupta@gmail.com");
            customer.setFirstName("Riya");
            customer.setMiddleName("");
            customer.setLastName("Gupta");
            customer.setPassword(passwordEncoder.encode("riyagupta"));
            customer.setActive(true);
            customer.setDeleted(false);
            customer.setContact("Customer Contact");

            List<Role> customerRoleList = new ArrayList<>();
            customerRoleList.add(roleCustomer);
            customer.setRoleList(customerRoleList);

            userRepository.save(appUser);
            sellerRepository.save(seller);
            customerRepository.save(customer);

            System.out.println("Total users saved::"+ userRepository.count());
        }
    }
}
