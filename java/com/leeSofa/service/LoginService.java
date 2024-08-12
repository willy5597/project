package com.leeSofa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
	
	    @Autowired
	    public JdbcTemplate jdbcTemplate;
	    

	       
	    public boolean authenticate(String email, String password) {
	        String sql = "SELECT count(*) FROM user WHERE email = ? AND password = ?";
	        int count = jdbcTemplate.queryForObject(sql, Integer.class, email, password);
	        return count == 1;
	    }
	}


