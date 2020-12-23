/*
 * Create the model class for the electronic product order
 */
package com.cg.elecpurchapp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
/*
 * Create entity of electronic product order and name table as "orders"
 */
@Entity
@Table(name="orders")
public class ElectronicProductOrder {
	/*
	 * Make id as the primary key
	 */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String orderId;
	@Column
	private double totalAmount;	
	@Column
	private String orderStatus;
	/*
	 * Create the non parametrised constructor
	 */
	public ElectronicProductOrder() {
		super();
	}
	/*
	 * Generate parametrized constructor
	 */
	public ElectronicProductOrder(String orderId, double totalAmount, String orderStatus) {
		super();
		this.orderId=orderId;
		//this.orderDate=orderDate;
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
	}
	/*
	 * Generate getters and setters for all the fields
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
//	public LocalDate getOrderDate() {
//		return orderDate;
//	}
//	public void setOrderDate(LocalDate orderDate) {
//		this.orderDate = orderDate;
//	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
}
