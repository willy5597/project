package com.leeSofa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leeSofa.model.dto.LoginDto;
import com.leeSofa.model.po.ProductItem;
import com.leeSofa.model.po.login;
import com.leeSofa.service.LoginService;



@RestController
@RequestMapping("/api/auth")
public class LoginController {
	

			
    @Autowired
	public LoginService loginService;
			
	

	//主要負責處理 Login 的 REST API
	@PostMapping("login")   
	 public ResponseEntity<login> getUserById(@PathVariable Integer id) {
        return loginService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

	}  

