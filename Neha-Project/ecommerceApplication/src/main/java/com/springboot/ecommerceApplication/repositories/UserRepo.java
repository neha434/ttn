package com.springboot.ecommerceApplication.repositories;


import com.springboot.ecommerceApplication.domain.user.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepo extends CrudRepository<User,Integer> {

    User findByEmail(String email);

}