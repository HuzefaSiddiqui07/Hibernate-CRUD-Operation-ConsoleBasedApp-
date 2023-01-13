// Q : Write a Java program to perform the CRUD operation using Hibernate.

package com.hibernate.crudoperations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "empName")
	private String empName;

	@Column(name = "city")
	private String city;

	@Column(name = "mobileNumber")
	private String mobileNumber;

	// Use Getter & Setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	// Use toString Method
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", city=" + city + ", mobileNumber=" + mobileNumber
				+ "]";
	}

}
