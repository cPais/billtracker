package com.isoftware.billtracker.billtracker.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.isoftware.billtracker.billtracker.entity.Bill;
import com.isoftware.billtracker.billtracker.service.BillService;

@Controller
@RequestMapping("/bills")
public class BillController {
	
	private BillService billService;
	
	public BillController(BillService theBillService) {
		billService = theBillService;
	}
	
	@GetMapping("/list")
	public String listBills(Model theModel) {
		
		// get bills from db
		List<Bill> theBills = billService.findAll();
		
		// add to the spring model
		theModel.addAttribute("bills", theBills);
		
		return "bills/list-bills";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Bill theBill = new Bill();
		
		theModel.addAttribute("bill", theBill);
		
		return "bills/bill-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("billId") int theId, 
									Model theModel ) {
		
		//get the bill from the service
		Bill theBill = billService.findById(theId);
		// set bill as a model attribute to pre-populate the form
		theModel.addAttribute("bill", theBill);
		// send over to our form
		return "bills/bill-form";
	}
	
	@PostMapping("/save")
	public String saveBill(@ModelAttribute("bill") Bill theBill) {
		
		// save the bill
		billService.save(theBill);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/bills/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("billId") int theId) {
		//delete the bill
		billService.deleteById(theId);
		
		//redirect to /bill/list
		return "redirect:/bills/list";
	}

}
