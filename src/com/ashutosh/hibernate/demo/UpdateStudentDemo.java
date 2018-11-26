package com.ashutosh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashutosh.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			//start a transasction
			session.beginTransaction();
			
			// retrieve student based on id: primary key
			System.out.println("\nGetting student with id: "+studentId);
			Student student = session.get(Student.class, studentId);
			
			System.out.println("updating student");
			student.setFirstName("Scooby");
			//commit
			session.getTransaction().commit();
			System.out.println("Done!!");
			
			// new code
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student s set s.email='gmail.com' where s.firstName='Daffy'").executeUpdate();
			
			session.getTransaction().commit();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			factory.close();
		}
		
	}
	
}
