package com.example.demo.domain;


import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity<ID> {

	public abstract ID getId();
}
