package com.ashutosh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashutosh.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student student = new Student("Daffy", "Duck", "daffy.duck@as.com");
			
			//start a transasction
			session.beginTransaction();
			
			// save the object
			System.out.println("saving the object...");
			System.out.println(student);
			session.save(student);
			
			// commit transaction
			session.getTransaction().commit();
			
			// new code
			
			// find out the student's id: primary key
			System.out.println("saved student. generated id: " + student.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id: primary key
			System.out.println("\ngetting student with id: "+student.getId());
			Student myStudent = session.get(Student.class, student.getId());
			System.out.println("get complete " + myStudent);
			
			//commit
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
