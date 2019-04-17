package com.isoftware.billtracker.billtracker.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name="bill")
public class Bill {
	
	// define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="company_number")
	private String companyNumber;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="date_due")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateDue;
	
	@Column(name="date_paid")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate datePaid;
	
	@Column(name="paid")
	private boolean paid;
	// define constructors
	
	public Bill() {
		
	}
	public Bill(int id, String companyName, String companyNumber, int amount, LocalDate dateDue, LocalDate datePaid,
			boolean paid) {
		
		this.id = id;
		this.companyName = companyName;
		this.companyNumber = companyNumber;
		this.amount = amount;
		this.dateDue = dateDue;
		this.datePaid = datePaid;
		this.paid = paid;
	}
	public Bill(String companyName, String companyNumber, int amount, LocalDate dateDue, LocalDate datePaid,
			boolean paid) {
		
		this.companyName = companyName;
		this.companyNumber = companyNumber;
		this.amount = amount;
		this.dateDue = dateDue;
		this.datePaid = datePaid;
		this.paid = paid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyNumber() {
		return companyNumber;
	}
	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public LocalDate getDateDue() {
		return dateDue;
	}
	public void setDateDue(LocalDate dateDue) {
		this.dateDue = dateDue;
	}
	public LocalDate getDatePaid() {
		return datePaid;
	}
	public void setDatePaid(LocalDate datePaid) {
		this.datePaid = datePaid;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	@Override
	public String toString() {
		return "Bill [id=" + id + ", companyName=" + companyName + ", companyNumber=" + companyNumber + ", amount="
				+ amount + ", dateDue=" + dateDue + ", datePaid=" + datePaid + ", paid=" + paid + "]";
	}
	
	
	
	

	
	
	
	
	


}


