package com.hibernate.crudoperations;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CrudOperation {

	// Established the Configuration
	private static Session getSessionObject() {

		// Creating Configuration Object
		Configuration configuration = new Configuration();

		// Loading hibernate.cfg.xml File
		configuration.configure("hibernate.cfg.xml");

		// Creating SessionFactory Object
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// Creating Session Object
		Session session = sessionFactory.openSession();

		// Returning Created session Object
		return session;

	}

	// Perform INSERT OPERATION
	public static void insertRecord() {

		// Calling getSessionObject method and storing the returned session object
		Session session = getSessionObject();

		Employee employee = new Employee();

		Scanner scanner1 = new Scanner(System.in);
		System.out.println("Enter Employee Name");
		String empName = scanner1.nextLine();
		employee.setEmpName(empName);

		Scanner scanner2 = new Scanner(System.in);
		System.out.println("Enter Employee City");
		String city = scanner2.nextLine();
		employee.setCity(city);

		Scanner scanner3 = new Scanner(System.in);
		System.out.println("Enter Employee Mobile Number");
		String mobileNumber = scanner3.nextLine();
		employee.setMobileNumber(mobileNumber);

		session.save(employee);
		session.beginTransaction().commit();
		System.out.println("Employee Record Inserted Successfully...");

		session.close();
		scanner1.close();
		scanner2.close();
		scanner3.close();
	}

	// Perform DELETE OPERATION
	public static void deleteRecord() {

		// Calling getSessionObject method and storing the returned session object
		Session session = getSessionObject();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a Employee I'd to delete");
		int id = scanner.nextInt();

		Employee employee = (Employee) session.get(Employee.class, id);

		if (employee == null) {

			System.out.println("Employee Record does not exist");

		} else {

			session.delete(employee);
			session.beginTransaction().commit();
			session.close();
			scanner.close();
			System.out.println("Employee Record Deleted Successfully...");

		}
	}

	// Perform UPDATE OPERATION
	public static void updateRecord() {

		// Calling getSessionObject method and storing the returned session object
		Session session = getSessionObject();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a Employee I'd to Update");
		int id = scanner.nextInt();

		Employee employee = (Employee) session.get(Employee.class, id);

		System.out.println("Existing Data is > " + employee);

		if (employee == null) {

			System.out.println("Employee Record does not exist");
			System.out.println("Please enter valid Employee I'd");

			updateRecord();

		} else {

			Scanner scanner1 = new Scanner(System.in);
			System.out.println("Enter Employee Name");
			String empName = scanner1.nextLine();
			employee.setEmpName(empName);

			Scanner scanner2 = new Scanner(System.in);
			System.out.println("Enter Employee City");
			String city = scanner2.nextLine();
			employee.setCity(city);

			Scanner scanner3 = new Scanner(System.in);
			System.out.println("Enter Employee Mobile Number");
			String mobileNumber = scanner3.nextLine();
			employee.setMobileNumber(mobileNumber);

			session.save(employee);
			session.beginTransaction().commit();
			System.out.println("Update Employee Record Successfully...");

			session.close();
			scanner1.close();
			scanner2.close();
			scanner3.close();
		}
	}

	// Perform RETRIEVE OPERATION
	public static void retrieveRecord() {

		// Calling getSessionObject method and storing the returned session object
		Session session = getSessionObject();

		// Retrieving all the database data for Employee Table and
		Query query = session.createQuery("from Employee");

		// Storing into query
		List<Employee> empList = query.list();

		// Converting Query into list for Iteration
		for (Employee emp : empList) {

			// using For Each loop for printing every record in the List emplist
			System.out.println(emp);
		}

		System.out.println("Employee Records Retrieved Successfully...");

	}
}
