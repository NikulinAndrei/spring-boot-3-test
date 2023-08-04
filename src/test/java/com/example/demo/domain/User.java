package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
public class User extends AbstractEntity<Long> implements WithTranslationKey {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getTranslationKey() {
		return name;
	}

	/* boilerplate */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				'}';
	}
}
