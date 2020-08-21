package com.capgemini.obs.om.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "customer")
public class Customer {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_seq")
	@SequenceGenerator(sequenceName = "customer_sequence", allocationSize = 10, name = "cust_seq")
	@Column(name = "customerId")
	private int customerId;
	@Column(name = "name")
	@Length(min=2, max=30)
	private String name;
	@Id
	@Column(name = "emailId")
	@NotBlank(message = "Email Address Should be Entered")
	@Length(min=2, max=64)
	private String emailId;
	@Column(name = "password")
	@NotBlank(message = "Enter Password")
	@Length(min=2, max=30)
	private String password;
	@Column(name = "phone", length = 10)
	private Long phoneNumber;
	@Column(name = "address")
	@NotBlank(message = "Enter Address")
	@Length(min=2, max=128)
	private String address;
	@Column(name = "city")
	@NotBlank(message = "Enter City Name")
	@Length(min=3, max=32)
	private String city;
	@Column(name = "country")
	@NotBlank(message = "Enter Country Name")
	@Length(min=3, max=64)
	private String country;
	@Column(name = "zipcode", length = 6)
	private int zipCode;
	public Customer() {}
	public Customer(int customerId, @Length(min = 2, max = 30) String name,
			@NotBlank(message = "Email Address Should be Entered") @Length(min = 2, max = 64) String emailId,
			@NotBlank(message = "Enter Password") @Length(min = 2, max = 30) String password, Long phoneNumber,
			@NotBlank(message = "Enter Address") @Length(min = 2, max = 128) String address,
			@NotBlank(message = "Enter City Name") @Length(min = 3, max = 32) String city,
			@NotBlank(message = "Enter Country Name") @Length(min = 3, max = 64) String country, int zipCode) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.country = country;
		this.zipCode = zipCode;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", emailId=" + emailId
				+ ", password=" + password + ", phoneNumber=" + phoneNumber + ", address=" + address + ", city=" + city
				+ ", country=" + country + ", zipCode=" + zipCode + "]";
	}
}
