package com.leeSofa.dao;


import java.util.List;
import java.util.Optional;

import com.leeSofa.model.po.User;

public interface UserDao {
	User createUser(User user);
    Optional<User> findById(Integer id); //查詢
    List<User> getAllUsers();
    User updateUser(Integer id, User user);
    Integer deleteUser(Integer id);

	
}
