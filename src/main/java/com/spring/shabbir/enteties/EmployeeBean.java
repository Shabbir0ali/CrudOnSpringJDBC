package com.spring.shabbir.enteties;

public class EmployeeBean {

	private int id;
	private String firstName;
	private String lastName;
	private String city;
	private String country;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "id = " + id + " firstName = " + firstName + " lastName = " + lastName + " city=" + city + " country="
				+ country;
	}

	public EmployeeBean() {
		super();
	}

}
