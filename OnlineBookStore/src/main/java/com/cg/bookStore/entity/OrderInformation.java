package com.cg.bookStore.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "bookstore_order")
public class OrderInformation {

	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderIdGenerator")
	@SequenceGenerator(name = "orderIdGenerator", initialValue = 1000)
	private int orderId;

	@Column(name = "recipient_name")
	private String recipientName;

	@Column(name = "recipient_phone_no")
	private String recipientPhoneNumber;

	@Column(name = "street_address")
	private String streetAddress;

	@Column(name = "city")
	private String city;

	@Column(name = "zip_code")
	private Integer zipCode;

	@Column(name = "country")
	@Size(min = 3, max = 64)
	private String country;

	@Column(name = "shipping_address")
	private String shippingAddress;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "total_price")
	private float totalPrice;

	@Column(name = "order_status")
	private String orderStatus;

	@Column(name = "payment_method")
	private String paymentMethod;

	@Column(name = "order_date")
	private LocalDate orderDate;

	@OneToMany(orphanRemoval = true,cascade = CascadeType.MERGE)
	private List<CartInformation> cart = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
	private CustomerInformation customer = new CustomerInformation();

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

	public String getRecipientPhoneNumber() {
		return recipientPhoneNumber;
	}

	public void setRecipientPhoneNumber(String recipientPhoneNumber) {
		this.recipientPhoneNumber = recipientPhoneNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public List<CartInformation> getCart() {
		return cart;
	}

	public void setCartId(List<CartInformation> cart) {
		this.cart = cart;
	}

	public CustomerInformation getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerInformation customer) {
		this.customer = customer;
	}

}