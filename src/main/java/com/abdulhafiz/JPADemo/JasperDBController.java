package com.abdulhafiz.JPADemo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JasperDBController {

	private EntityManagerFactory entityManagerFactory = null;
	private EntityManager entityManager = null;
	private JasperStudentNames jasperStudentNames = null;
	private JasperStudents jasperStudents = null;
	
	Scanner scanner = new Scanner(System.in);
	
	
	public JasperStudentNames getJasperStudentNames() {
		return jasperStudentNames;
	}

	public void setJasperStudentNames(JasperStudentNames jasperStudentNames) {
		this.jasperStudentNames = jasperStudentNames;
	}
	
	public JasperStudents getJasperStudents() {
		return jasperStudents;
	}

	public void setJasperStudents(JasperStudents jasperStudents) {
		this.jasperStudents = jasperStudents;
	}
	
	
	public void configure() {
		
		 entityManagerFactory = Persistence.createEntityManagerFactory("jasper");
		 entityManager = entityManagerFactory.createEntityManager();
	}
	
	public void close() {
		entityManager.close();
		entityManagerFactory.close();
		scanner.close();
	}
	
	public void jasperStudentNames(){
		
		setJasperStudentNames(new JasperStudentNames());
		
		System.out.println("Enter Student Last Name");
		String lastName = scanner.nextLine();
		getJasperStudentNames().setLastName(lastName);
		
		System.out.println("Enter student First Name");
		String firstName =  scanner.nextLine();
		getJasperStudentNames().setFirstName(firstName);
		
		System.out.println("Enter Student Middle Name");
		String middleName = scanner.nextLine();
		getJasperStudentNames().setMiddleName(middleName);
		
		//return jasperStudentNames;
		
	}
	public JasperStudents jasperStudentData() {
		
		setJasperStudents(new JasperStudents());
		
		jasperStudentNames();
		
		getJasperStudents().setNames(jasperStudentNames);
		
		System.out.println("Enter Student Age");
		int age = scanner.nextInt();
		getJasperStudents().setAge(age);
		
		System.out.println("Enter Student Rating");
		double ratings = scanner.nextDouble();
		getJasperStudents().setRatings(ratings);
		
		System.out.println("Enter Student Status");
		String status = scanner.next();
		getJasperStudents().setStatus(status);

		getJasperStudents().setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
		
		return jasperStudents;
		
	}
	
	public void persistJasperStudent() {
		
		configure();
		
			jasperStudentData();
		
			entityManager.getTransaction().begin();
		
				entityManager.persist(jasperStudents);
		
			entityManager.getTransaction().commit();
		
		close();
		
		System.out.println(jasperStudents);
	}
	
	public void retrieveAJasperStudent() {
		
		System.out.println("Enter Jasper Student id. Enter A Number Between 1 and 19");
			int sid = scanner.nextInt();
			
		configure();
		
			entityManager.getTransaction().begin();
				
				JasperStudents student = entityManager.find(JasperStudents.class, sid);
			
			entityManager.getTransaction().commit();
		
		close();
		
		System.out.println(student);
	}
	
	public void updateJasperStudentRecords() {
		
		System.out.println("Enter Jasper Student id. Enter A Number Between 1 and 19");
			int sid = scanner.nextInt();
		
		configure();
		
			entityManager.getTransaction().begin();
			
				jasperStudents = entityManager.find(JasperStudents.class, sid);
				
				jasperStudents.setRatings(6.7);
				 
			entityManager.getTransaction().commit();
			
		close();
		
		System.out.println("Student Record of id " + jasperStudents.getId() + " Updated Successfully");
	}

	public void removeJasperStudentRecords() {
		
		System.out.println("Enter Jasper Student id. Enter A Number Between 1 and 19");
		int sid = scanner.nextInt();
		
		configure();
			
			entityManager.getTransaction().begin();
				
				JasperStudents student =  entityManager.find(JasperStudents.class, sid);
			
				entityManager.remove(student);
				
			entityManager.getTransaction().commit();
		close();
		
		System.out.println("Student With id " + sid + " Removed Successfully");
	}
}
