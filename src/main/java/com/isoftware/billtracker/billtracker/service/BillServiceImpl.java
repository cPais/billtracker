package com.isoftware.billtracker.billtracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isoftware.billtracker.billtracker.dao.BillRepository;
import com.isoftware.billtracker.billtracker.entity.Bill;

@Service
public class BillServiceImpl implements BillService {


	private BillRepository BillRepository;
	
	@Autowired
	public BillServiceImpl(BillRepository theBillRepository) {
		BillRepository = theBillRepository;
	}

	@Override
	public List<Bill> findAll() {
		return BillRepository.findAllByOrderByDateDueAsc();
		
	}
	

	@Override
	public Bill findById(int theId) {
		
		Optional<Bill> result = BillRepository.findById(theId);
		Bill theBill = null;
		
		if(result.isPresent()) {
			theBill = result.get();
		}
		else {
			// we didn't find the Bill
			throw new RuntimeException("Did not find Bill id - " + theId);
		}
		return theBill;
	}

	@Override
	public void save(Bill theBill) {
		BillRepository.save(theBill);

	}

	@Override
	public void deleteById(int theId) {
		BillRepository.deleteById(theId);

	}

}
