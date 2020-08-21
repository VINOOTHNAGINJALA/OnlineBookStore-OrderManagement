package com.capgemini.obs.om.entity;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order 
{
	@Id
	@Column(name="orderId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @SequenceGenerator(name = "order_seq", sequenceName = "order_sequence", allocationSize=1)
    int orderId;

	@ManyToOne(fetch=FetchType.EAGER,targetEntity = Customer.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "emailId", referencedColumnName = "emailId")
	private Customer customer; 
	
	@Column(name="recipientName", length = 30)
	private String recipientName;
	@Column(name="recipientPhone", length = 10)
	private Long recipientPhone;
	@Column(name="address", length = 128)
	private String address;
	@Column(name="city", length = 30)
	private String city;
	@Column(name="country", length = 24)
	private String country;
	@Column(name="zipCode", length = 24)
	private int zipCode;
	
	@Column(name="paymentMethod", length=25)
	private String paymentMethod;
	@Column(name="orderStatus", length=15)
	private String orderStatus;
	
	@Column(name="orderDate", length=15)
	private LocalDate orderDate;
	
	public Order() {}
	public Order(int orderId, Customer customer, String recipientName, Long recipientPhone, String address, String city, String country,
			int zipCode, String paymentMethod, String orderStatus, LocalDate orderDate) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.recipientName = recipientName;
		this.recipientPhone = recipientPhone;
		this.address = address;
		this.city = city;
		this.country = country;
		this.zipCode = zipCode;
		this.paymentMethod = paymentMethod;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	public Long getRecipientPhone() {
		return recipientPhone;
	}
	public void setRecipientPhone(Long recipientPhone) {
		this.recipientPhone = recipientPhone;
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
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customer=" + customer + ", recipientName=" + recipientName
				+ ", recipientPhone=" + recipientPhone + ", address=" + address + ", city=" + city + ", country="
				+ country + ", zipCode=" + zipCode + ", paymentMethod=" + paymentMethod + ", orderStatus=" + orderStatus
				+ ", orderDate=" + orderDate + "]";
	} 
}
