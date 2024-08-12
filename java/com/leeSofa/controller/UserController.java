package com.leeSofa.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leeSofa.model.dto.UserDto;
import com.leeSofa.model.po.User;
import com.leeSofa.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.addUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public String getAllUsers(Model model) {
        List<UserDto> userDtos = userService.findUserDtos();
        model.addAttribute("userDtos",userDtos);
        return "user/userlist";
    }

    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
        User updateUser = userService.updateUser(user);
        if (updateUser != null) {
            return ResponseEntity.ok(updateUser);
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model){
    	Integer rowcount = userService.deleteUser(id);
    	 if (rowcount > 0) {
             model.addAttribute("message", "User deleted successfully.");
         } else {
        	 model.addAttribute("error", "User not found.");
         }
     
    	return "user/userlist";
    }
  }
