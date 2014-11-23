package com.popsicle.example.data.repository;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

import com.popsicle.example.data.model.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Transactional
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	private User user;

	@Before
	public void setUp() {
		user = createUser("Foo");
	}

	@Test
	public void testFindAll() {
		List<User> users = userRepository.findAll();
		assertTrue(users.isEmpty());
	}

	@Test
	public void testSave() {
		assertNull(user.getUserId());

		user = userRepository.save(user);

		Long userId = user.getUserId();
		assertNotNull("User Id = " + userId, userId);
		System.out.println("User Id = " + userId);
	}

	@Test
	public void testSaveCascade() {
		int accountAmount = 10;
		List<Account> accounts = new ArrayList<>();

		for(int i = 0; i < accountAmount; i++) {
			accounts.add(createAccount("Acc_" + i, user));
		}

		Collections.reverse(accounts);
		user.setAccounts(accounts);
		user = userRepository.save(user);

		assertEquals(accountAmount, user.getAccounts().size());
		printAccounts(user);
		System.out.println("---");
		printAccounts(userRepository.findOne(user.getUserId()));
	}

	private void printAccounts(User user) {
		for(Account account: user.getAccounts()) {
			System.out.println(account);
		}
	}

	private User createUser(String name) {
		User user = new User();
		user.setUsername(name);
		return user;
	}

	private Account createAccount(String name, User user) {
		Account acc = new Account();

		acc.setAccountName(name);
		acc.setUser(user);

		return acc;
	}
}