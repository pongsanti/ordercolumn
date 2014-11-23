package com.popsicle.example.data.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.*;
import com.popsicle.example.data.model.User; 

public interface UserRepository extends JpaRepository<User, Long> {

}