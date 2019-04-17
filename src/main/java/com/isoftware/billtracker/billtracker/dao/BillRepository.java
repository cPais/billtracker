package com.isoftware.billtracker.billtracker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isoftware.billtracker.billtracker.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer> {
	
	List<Bill> findAllByOrderByDateDueAsc();

}



