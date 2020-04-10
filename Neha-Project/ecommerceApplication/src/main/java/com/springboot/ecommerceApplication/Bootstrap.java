package com.springboot.ecommerceApplication;

import com.springboot.ecommerceApplication.domain.Role;
import com.springboot.ecommerceApplication.domain.order.Cart;
import com.springboot.ecommerceApplication.domain.order.Order;
import com.springboot.ecommerceApplication.domain.product.Category;
import com.springboot.ecommerceApplication.domain.product.Product;
import com.springboot.ecommerceApplication.domain.product.ProductReview;
import com.springboot.ecommerceApplication.domain.product.ProductVariation;
import com.springboot.ecommerceApplication.domain.user.Customer;
import com.springboot.ecommerceApplication.domain.user.Seller;
import com.springboot.ecommerceApplication.domain.user.User;
import com.springboot.ecommerceApplication.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    CategoryRepo categoryRepository;

    @Autowired
    ProductRepo productRepository;

    @Autowired
    CartRepo cartRepository;

    @Autowired
    OrderRepo orderRepository;

    @Autowired
    ProductVariationRepo productVariationRepository;

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

        if(categoryRepository.count() < 1){
            Category category = new Category();
            category.setName("");
            categoryRepository.save(category);
        }
        if(productRepository.count() < 1){
            Product product = new Product();
            product.setName("Lenovo Ideapad");
            product.setDescription("Portable Design");

            product.setCategory(categoryRepository.findByName("Laptops"));
            product.setSeller( sellerRepository.findByEmail("pragati.singhal@gmail.com"));

            product.setCancellable(true);
            product.setReturnable(true);
            product.setBrand("Lenovo");
            product.setActive(true);

            List<ProductVariation> productVariations = new ArrayList<>();
            ProductVariation productVariation1 = new ProductVariation(1,26990,"Image Name 1",
                    "Meta Data 1");
            productVariation1.setProduct(product);
            productVariations.add(productVariation1);
            ProductVariation productVariation2 = new ProductVariation(5, 18990,"Image Name 2",
                    "Meta Data 2");
            productVariation2.setProduct(product);
            productVariations.add(productVariation2);
            product.setProductVariationList(productVariations);

            List<ProductReview> productReviewsList = new ArrayList<>();

            ProductReview productReview1 = new ProductReview();
            productReview1.setReview("Nice Camera");
            productReview1.setRating(4.8);
            productReview1.setProduct(product);
            productReviewsList.add(productReview1);

            ProductReview productReview2 = new ProductReview();
            productReview2.setReview("Good Battery Backup");
            productReview2.setRating(4.7);
            productReview2.setProduct(product);
            productReviewsList.add(productReview2);
            product.setProductReviewsList(productReviewsList);
            productRepository.save(product);
        }
        if (cartRepository.count() < 1){
            Cart cart = new Cart();
            cart.setProductVariation(productVariationRepository.findById(1).get());
            cart.setCustomer(customerRepository.findById(3).get());
            cart.setWishList(true);
            cart.setQuantity(2);
            cartRepository.save(cart);
        }
        if (orderRepository .count() < 1){
            Order order = new Order();
            order.setAmountPaid(10000);

            Date date = new Date();
            order.setDate_created(date);
            order.setPaymentMethod("Net Banking");
            order.setCustomerAddressCity("Greater Noida");
            order.setCustomerAddressState("Uttar Pradsh");
            order.setCustomerAddressCountry("India");
            order.setCustomerAddressAddressLine("Kaushalya Residency");
            order.setCustomerAddressLabel("Home");
            order.setCustomerAddressZipCode(201310);
            orderRepository.save(order);
        }

    }
}
