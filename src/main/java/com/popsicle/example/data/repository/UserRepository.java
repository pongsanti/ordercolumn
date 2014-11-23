package com.popsicle.example.data.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository<User, Long extends Serializable> 
	extends JpaRepository<User, Long> {
	
}