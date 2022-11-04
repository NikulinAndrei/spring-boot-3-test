package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
public class User extends AbstractEntity implements WithTranslationKey {

	private String name;


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
