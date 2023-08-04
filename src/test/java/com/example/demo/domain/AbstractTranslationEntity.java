package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractTranslationEntity<T extends AbstractEntity<Long> & WithTranslationKey>
		extends AbstractEntity<Long> {

	@Id
	@GeneratedValue
	private Long id;

	@JoinColumn(name = "CLASSIFIER_ID", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private T classifier;

	@Column(name = "LOCALE_CODE", length = 15, nullable = false)
	private String localeCode;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/* boilerplate */
	public T getClassifier() {
		return classifier;
	}

	public void setClassifier(T classifier) {
		this.classifier = classifier;
	}

	public String getLocaleCode() {
		return localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}
}
