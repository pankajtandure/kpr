package com.app.cca.kpr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_PROFILE")
public class Customer {

	private static long counter=0;
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="BIRTH_DATE")
	private Date birthdate;
	
	@Column(name="PAN_CARD")
	private String pancard;
	
	@Column(name="CONTACT_NO")
	private int contactno;
	
	@Column(name="EMAIL_ID")
	private String email;
	
	@Column(name="ADDRESS1")
	private String address1;
	
	@Column(name="ADDRESS2")
	private String address2;
	
	@Column(name="ADDRESS3")
	private String address3;
	
	@Column(name="PINCODE")
	private int pincode;
	
	public Customer() {
		
	}
	
	public Customer(String name, Date birthdate, String pancard, int contactno,
			String email, String address1, String address2, String address3, int pincode) {
		//this.id=++counter;
		this.name=name;
		this.birthdate=birthdate;
		this.pancard=pancard;
		this.contactno=contactno;
		this.email=email;
		this.address1=address1;
		this.address2=address2;
		this.address3=address3;
		this.pincode=pincode;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthDate) {
		this.birthdate = birthDate;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String panCard) {
		this.pancard = panCard;
	}
	public int getContactno() {
		return contactno;
	}
	public void setContactno(int contactNo) {
		this.contactno = contactNo;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pinCode) {
		this.pincode = pinCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
