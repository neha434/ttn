package com.springboot.ecommerceApplication.services;

import com.springboot.ecommerceApplication.domain.user.User;
import com.springboot.ecommerceApplication.dto.CustomerDto;
import com.springboot.ecommerceApplication.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepository;

    public String changeRoleOfUser(Integer id, String role) {
        User user = userRepository.findById(id).get();
        user.getRoleList().get(0).setAuthority(role);
        userRepository.save(user);
        return "Role is changed";

    }
}