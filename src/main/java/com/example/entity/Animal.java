package com.example.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

/*Q1-1*/
public class Animal {
	@SequenceGenerator(name = "ANIMAL_ID_GENERATOR", sequenceName = "ANIMAL_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANIMAL_ID_GENERATOR")
	private Integer id;

	private String name;
}
