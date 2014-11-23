package com.popsicle.example.data.repository;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.beans.factory.annotation.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testFindAll() {
		userRepository.findAll();
	}

}