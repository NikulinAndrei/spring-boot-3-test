package com.example.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.domain.User;
import com.example.demo.domain.UserTranslation;

public class FailingTest {

	private static Logger log = LoggerFactory.getLogger(FailingTest.class);

	private static EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	@BeforeClass
	public static void setUpClass() {
		entityManagerFactory = Persistence.createEntityManagerFactory("templatePU");
	}

	@Before
	public void setUp() {
		entityManager = entityManagerFactory.createEntityManager();
	}

	@AfterClass
	public static void tearDownClass() {
		entityManagerFactory.close();
	}

	@After
	public void tearDown() {
		entityManager.close();
	}

	@Test
	public void failingTest() {
		entityManager.getTransaction().begin();

		log.info("Create user...");
		var user1 = createUser();
		entityManager.persist(user1);
		log.info("User created : {} ", user1);

		log.info("Create translation...");
		var translation = createTranslation(user1, "EN", "User in Eng");
		entityManager.persist(translation);
		log.info("Translation created : {} ", translation);

		List resultList = entityManager.createQuery("from UserTranslation where classifier.id=?")
				.setParameter(0, user1.getId())
				.getResultList();
		Assert.assertEquals(resultList, List.of(translation));

		entityManager.getTransaction().commit();
	}

	private User createUser() {
		var user = new User();
		user.setName("User 1");
		return user;
	}

	private UserTranslation createTranslation(User user, String locale, String translated) {
		var translation = new UserTranslation();
		translation.setClassifier(user);
		translation.setLocaleCode(locale);
		translation.setTranslation(translated);
		return translation;
	}
}