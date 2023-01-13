package com.hibernate.crudoperations;

import java.util.Scanner;

public class Start {

	public static void main(String[] args) {

		System.out.println(">>>>>>>>>>>>>> WELCOME <<<<<<<<<<<<<<");

		// Creating Scanner object for dynamic input
		Scanner scanner = new Scanner(System.in);

		System.out.println("1. Create / Insert Employee Record : ");

		System.out.println("2. Update Employee Record : ");

		System.out.println("3. Delete Employee Record : ");

		System.out.println("4. View Employee Record : ");

		System.out.println("Please Select your Choice : ");

		int choice = 0; // Local Variable
		choice = scanner.nextInt(); // Scanning user input and storing

		switch (choice) {

		case 1:
			CrudOperation.insertRecord(); // Calling Insert Record Method
			break;

		case 2:
			CrudOperation.updateRecord(); // Calling Update Record Method
			break;

		case 3:
			CrudOperation.deleteRecord(); // Calling Delete Record Method
			break;

		case 4:
			CrudOperation.retrieveRecord(); // Calling Retrieve Record Method
			break;

		default:

			System.out.println("Please Select a Valid Option");

		}

	}

}
