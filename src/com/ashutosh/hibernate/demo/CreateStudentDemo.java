package com.ashutosh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashutosh.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save java object
			// create a student object
			System.out.println("creating new student object..");
			Student student = new Student("Paul", "Wall", "paul.wall@as.com");
			
			//start a transasction
			session.beginTransaction();
			
			// save the object
			System.out.println("saving the object...");
			session.save(student);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			factory.close();
		}
		
	}
	
}
