package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "USER_TRANSLATION")
public class UserTranslation extends AbstractTranslationEntity<User> {

	private String translation;

	/* boilerplate */
	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	@Override
	public String toString() {
		return "UserTranslation{" +
				"translation='" + translation + '\'' +
				"classifier='" + getClassifier() + '\'' +
				'}';
	}
}
