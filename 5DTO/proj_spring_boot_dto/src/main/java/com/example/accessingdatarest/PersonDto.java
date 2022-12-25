package com.example.accessingdatarest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//dto must have no anottations and less ivs , keeps the id with no anottation 
//no need for tosetring 
public class PersonDto {


	private long id;
	private String firstName;

	
	public PersonDto() {	
		
	}

	public PersonDto(Long id, String firstName) {  //id must be skipped in constructor only, but not in getters, setter and toString
		super();
		this.id = id;
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	/*
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
*/
}