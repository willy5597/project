package com.leeSofa.dao;

import java.util.Optional;



public interface LoginDAO {
	Optional<LoginDAO> findByEmail(String email);

}
