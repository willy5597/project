/*package com.leeSofa.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.leeSofa.model.po.User;
import com.leeSofa.model.po.login;

public class LoginImpl implements LoginDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Optional<LoginDAO> findByEmail(String id) {
		String sql = "select email, password from user where email = ?";
		try {
			User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
			return Optional.of(login);
		} catch (Exception e) {
			e.printStackTrace();
		}
       return  Optional.of(null);
   }

}*/
