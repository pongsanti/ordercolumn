package com.popsicle.example.data.repository;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.transaction.annotation.*;

import java.util.List;

import com.popsicle.example.data.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Transactional
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testFindAll() {
		List<User> users = userRepository.findAll();
		assertTrue(users.isEmpty());
	}

	@Test
	public void testSave() {
		User user = new User();
		user.setUsername("Foo");
		assertNull(user.getUserId());

		user = userRepository.save(user);

		Long userId = user.getUserId();
		assertNotNull("User Id = " + userId, userId);
		System.out.println("User Id = " + userId);
	}

}