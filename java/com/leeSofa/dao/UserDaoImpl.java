package com.leeSofa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



import com.leeSofa.model.po.User;


import java.util.List;
import java.util.Optional;


@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
    

    @Override
    public User createUser(User user) {
        String sql = "instert into user(id, name, email, password) value(?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getId(),
        		user.getName(),
        		user.getEmail(),
        		user.getPassword());
       return user;
        
     }

    @Override
    public Optional<User> findById(Integer id){
    	String sql = "select id, name, email, password from user where id = ?";
    	  try {
			User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
			return Optional.of(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
       return  Optional.of(null);
    }

    @Override
    public List<User> getAllUsers() {
    	String sql = "select id, name, email, password from user";
    	return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User updateUser(Integer id,User user) {
       String sql = "Insert into user(id, name, email, password) value(?, ?, ?, ?)";
        jdbcTemplate.update(sql,
        		user.getId(),
        		user.getName(),
        		user.getEmail(),
        		user.getPassword());
        return user;
    }

    @Override
    public Integer deleteUser(Integer id) {
       String sql = "delete from user where id = ?";
       int rowcount = jdbcTemplate.update(sql, id);
       return rowcount;
    }
}
