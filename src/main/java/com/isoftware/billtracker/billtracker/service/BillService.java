package com.isoftware.billtracker.billtracker.service;

import java.util.List;

import com.isoftware.billtracker.billtracker.entity.Bill;

public interface BillService {
	
public List<Bill> findAll();
	
	public Bill findById(int theId);
	
	public void save(Bill theBill);
	
	public void deleteById(int theId);

}
