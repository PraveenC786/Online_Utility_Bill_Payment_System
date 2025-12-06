package com.jsp.UtilityBillPayment.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="bills")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long billId;
	private double amount;
	private LocalDate dueDate;
	
	@Enumerated(EnumType.STRING)
	private UtilityType utilityType;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;
	
	
	@OneToOne(mappedBy = "bill", cascade=CascadeType.ALL )
	@JsonIgnore
	private Payment payment;
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonIgnore
	private User user;


// Getters and Setters 
	public long getBillId() {
		return billId;
	}

	public void setBillId(long billId) {
		this.billId = billId;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public LocalDate getDueDate() {
		return dueDate;
	}


	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}


	public UtilityType getUtilityType() {
		return utilityType;
	}


	public void setUtilityType(UtilityType utilityType) {
		this.utilityType = utilityType;
	}


	public PaymentStatus getPaymentStatus() {
		return status;
	}


	public void setPaymentStatus(PaymentStatus status) {
		this.status = status;
	}


	public Payment getPayment() {
		return payment;
	}


	public void setPayment(Payment payment) {
		this.payment = payment;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
