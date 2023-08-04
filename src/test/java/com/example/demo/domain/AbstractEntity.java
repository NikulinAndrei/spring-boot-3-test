package com.example.demo.domain;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity<ID> {

	public abstract ID getId();
}
