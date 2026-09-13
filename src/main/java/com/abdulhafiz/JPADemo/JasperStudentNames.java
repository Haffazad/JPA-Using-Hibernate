package com.abdulhafiz.JPADemo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class JasperStudentNames {

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "middle_name")
	private String middleName;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	@Override
	public String toString() {
		return "JasperStudentNames [firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName
				+ "]";
	}
	
	
	
}
