package com.abdulhafiz.JPADemo;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        
    	JasperDBController control = new JasperDBController();
    	control.persistJasperStudent();
    	//control.retrieveAJasperStudent();
    	//control.updateJasperStudentRecords();
    	//control.removeJasperStudentRecords();
    }
}
