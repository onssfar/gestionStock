package com.management.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.demo.entities.Bill;
import com.management.demo.entities.User;
import com.management.demo.service.BillService;

@RestController
@RequestMapping(value = "/manageBill")
public class BillController {

	@Autowired
	private BillService billService;

	public Bill addBill(Bill bill) {
		return this.billService.saveBill(bill);
	}

	public Bill findById(Long id) {
		Optional<Bill> bill = this.billService.getBillById(id);
		return bill.isPresent() == true ? bill.get() : null;
	}

	public Bill findByUser(User user) {
		return this.billService.getBillByProduct(user);
	}

	public List<Bill> findAll() {
		return this.billService.findAll();
	}
}
