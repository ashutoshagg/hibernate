package com.ashutosh.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashutosh.hibernate.demo.entity.Student;

public class QueryStudentDemo {

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
				
			//start a transasction
			session.beginTransaction();
			
			// query students
			List<Student> students = session.createQuery("from Student").list();
			
			//display the students
			displayStudents(students);
			
			// query students: lastname="Wall"
			students = session.createQuery("from Student s where s.lastName='Wall'").list();
			
			// display list of students ending with lastname="wall"
			displayStudents(students);
			
			//query students: lastName="wall" or firstName="daffy"
			students = session.createQuery("from Student s where"
					+ " s.lastName='Wall' OR s.firstName='Daffy'").list();
			
			// display list of students ending with lastName="wall" or firstName="daffy"
			displayStudents(students);
			
			students = session.createQuery("from Student s where "
					+ "s.email LIKE '%as.com'").list();
			
			// display list of students ending with lastName="wall" or firstName="daffy"
						displayStudents(students);
			
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

	private static void displayStudents(List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
}
