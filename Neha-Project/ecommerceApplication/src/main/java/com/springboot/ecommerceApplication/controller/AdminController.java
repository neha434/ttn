package com.springboot.ecommerceApplication.controller;

import com.springboot.ecommerceApplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;
    @PutMapping("/changeRole/{role}/{id}")
        public String changeRoleOfUser(@PathVariable Integer id, String role){
        return userService.changeRoleOfUser(id,role);
    }
    }