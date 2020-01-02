package com.memorynotfound.ldap;

public class Person {

	private String fullName;
	private String lastName;

	public Person() {}

	public Person(String fullName, String lastName) {
		this.fullName = fullName;
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Person{" + "fullName='" + fullName + '\'' + ", lastName='" + lastName + '\'' + '}';
	}
}
