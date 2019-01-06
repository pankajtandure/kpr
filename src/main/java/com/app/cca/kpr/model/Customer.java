package com.app.cca.kpr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="CUSTOMER")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Customer {
	
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

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	
	@JsonIgnore
	@NotNull
	@Size(min=1, max=20)
	@Column(name="STATUS")
	private String status;
	
	@NotNull
	@Size(min=1, max=30)
	@Column(name="NAME")
	private String name;

	@Size(min=1, max=1)
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="BIRTH_DATE")
	private Date birthdate;
	
	@Size(min=1, max=10)
	@Column(name="PAN_CARD")
	private String pancard;
	
	@Size(min=1, max=10)
	@Column(name="CONTACT_NO")
	private int contactno;
	
	@Email
	@Column(name="EMAIL_ID")
	private String email;
	
	@Size(min=1, max=100)
	@Column(name="ADDRESS1")
	private String address1;
	
	@Size(min=1, max=100)
	@Column(name="ADDRESS2")
	private String address2;
	
	@Size(min=1, max=100)
	@Column(name="LOCALITY")
	private String locality;
	
	@Size(min=1, max=6)
	@Column(name="PINCODE")
	private int pincode;
	
	public Customer() {
		
	}
	
	public Customer(String name, String gender, Date birthdate, String pancard, int contactno,
			String email, String address1, String address2, String locality, int pincode) {
		//this.id=++counter;
		this.name=name;
		this.gender=gender;
		this.birthdate=birthdate;
		this.pancard=pancard;
		this.contactno=contactno;
		this.email=email;
		this.address1=address1;
		this.address2=address2;
		this.locality=locality;
		this.pincode=pincode;
	}
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
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
	
	public static Customer getCustomer(CustomerWork work) {
		
		return new Customer(work.getName(), work.getGender(),work.getBirthdate(),work.getPancard(),work.getContactno(), 
				work.getEmail(), work.getAddress1(), work.getAddress2(), work.getLocality(), work.getPincode());
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", status=" + status + ", name=" + name + ", gender=" + gender + ", birthdate="
				+ birthdate + ", pancard=" + pancard + ", contactno=" + contactno + ", email=" + email + ", address1="
				+ address1 + ", address2=" + address2 + ", locality=" + locality + ", pincode=" + pincode + "]";
	}
	
}

