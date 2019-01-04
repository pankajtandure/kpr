package com.app.cca.kpr.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_WORK")
public class CustomerWork extends Customer {
	
	/*
	 * 
	 {
		"name": "Pankaj4",
        "gender": "M",
        "birthdate": "2012-04-23T18:25:43.511Z",
        "pancard": "AAAAA3333A",
        "contactno": "1234567890",
        "email": "pankaj@demo.com",
        "address1": "add 1",
        "address2": "add 2",
        "locality": "Pune",
        "pincode": "411014"
	}
	 */

	public CustomerWork() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerWork(String name, String gender, Date birthdate, String pancard, int contactno, String email,
			String address1, String address2, String locality, int pincode) {
		super(name, gender, birthdate, pancard, contactno, email, address1, address2, locality, pincode);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CustomerWork [getStatus()=" + getStatus() + ", getGender()=" + getGender() + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getBirthdate()=" + getBirthdate() + ", getPancard()=" + getPancard()
				+ ", getContactno()=" + getContactno() + ", getAddress1()=" + getAddress1() + ", getAddress2()="
				+ getAddress2() + ", getLocality()=" + getLocality() + ", getPincode()=" + getPincode()
				+ ", getEmail()=" + getEmail() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}	
}
