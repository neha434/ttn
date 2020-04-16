package com.springboot.ecommerceApplication.controller;

import com.springboot.ecommerceApplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;
    @PutMapping("/changeRole/{role}/{id}")
        public String changeRoleOfUser(@PathVariable Integer id, String role){
        return userService.changeRoleOfUser(id,role);
    }

    @PutMapping("/activate/{id}")
    public ResponseEntity activateUser(@PathVariable Integer id, WebRequest webRequest) {
        return userService.activateById(id, webRequest);
    }

    @PutMapping("deactivate{id}")
    public ResponseEntity deActivateUser(@PathVariable Integer id, WebRequest webRequest) {
        return userService.deActivateById(id, webRequest);
    }

}