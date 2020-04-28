package com.example.STARPAY.domain;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "StarPay_user")
public class StarPayUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "Id")
	private Long id;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "mobile_no")
	private String mobileNumber;

	@Column(name = "status", columnDefinition = "varchar(255) default 'Active'")
	private String status = "Active";

	@Column(name = "isActive", columnDefinition = "tinyint(1) default 1")
	private Boolean isActive = true;

	@Column(name = "gender")
	private String gender;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "isAdmin", columnDefinition = "tinyint(1) default 0")
	private Boolean isAdmin = false;

//	@Column(name = "pd_0_rd_1")
//	private Boolean isPd0Rd1;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "retailerFeature", cascade = CascadeType.ALL) // mappedBy = "retailerFeature",
	private Set<Assn_User_Features> retailerFearture;// =new TreeSet<Assn_User_Features>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "address",cascade = CascadeType.ALL) // mappedBy = "address",
	@JoinColumn(name ="Id", referencedColumnName = "Id")
	private Set<Address> address;// =new TreeSet<Address>();

	@ManyToOne
	private Rd rd;
	
	public Rd getRd() {
		return rd;
	}

	public void setRd(Rd rd) {
		this.rd = rd;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Set<Assn_User_Features> getRetailerFearture() {
		return retailerFearture;
	}

	public void setRetailerFearture(Set<Assn_User_Features> retailerFearture) {
		this.retailerFearture = retailerFearture;
	}

}
