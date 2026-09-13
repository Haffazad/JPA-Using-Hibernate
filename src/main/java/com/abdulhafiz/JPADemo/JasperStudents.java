package com.abdulhafiz.JPADemo;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "Jasper_Students")
public class JasperStudents {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jasper_id")
	private Integer id;
	
	private JasperStudentNames names;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "student_ratings")
	private double ratings;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "time_created")
	private Timestamp createdAt;

	
	public JasperStudents() {
		
	}
	
	public JasperStudents(Integer id, JasperStudentNames names, int age, int ratings, String status, Timestamp createdAt) {
		this.id = id;
		this.names = names;
		this.age = age;
		this.ratings = ratings;
		this.status = status;
		this.createdAt = createdAt;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public JasperStudentNames getNames() {
		return names;
	}

	public void setNames(JasperStudentNames names) {
		this.names = names;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getRatings() {
		return ratings;
	}

	public void setRatings(double rating) {
		this.ratings = rating;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "JasperStudents [id=" + id + ", names=" + names + ", age=" + age + ", ratings=" + ratings + ", status="
				+ status + ", createdAt=" + createdAt + "]";
	}
	
	
	
}
