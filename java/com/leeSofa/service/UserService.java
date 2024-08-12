package com.leeSofa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leeSofa.dao.UserDao;
import com.leeSofa.model.dto.UserDto;
import com.leeSofa.model.po.User;



@Service
public class UserService {
	
	@Autowired
	private UserDao userdao;
	
	public User addUser(User user) {
		return userdao.createUser(user);
		}
    
	public Integer deleteUser(Integer id) {
		return userdao.deleteUser(id);
	}
	
	public User updateUser(User user) {
		return userdao.createUser(user);
	}
	
	public Optional<User> findById(Integer id){
		return userdao.findById(id);
	}
	
	public List<User> getAllUsers(){
		return userdao.getAllUsers();
	}
	
	public List<UserDto> findUserDtos(){
		List<UserDto> userDtos = new ArrayList<>();
		List<User> users = getAllUsers();
		//PO轉DTO
		for(User user : users) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDtos.add(userDto);
	}
		return userDtos;
	}
}
		

