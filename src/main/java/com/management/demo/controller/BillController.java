package com.management.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.demo.entities.Bill;
import com.management.demo.entities.User;
import com.management.demo.repository.IClientRepository;
import com.management.demo.service.BillService;

@CrossOrigin
@RestController
@RequestMapping(value = "/manageBill")
public class BillController {

	@Autowired
	private BillService billService;

	@Autowired
	private IClientRepository clientRepository;
	
	@PostMapping("/addBill")
	public Bill addBill(@RequestBody Bill bill) {
		this.clientRepository.save(bill.getClient());
		return this.billService.saveBill(bill);
	}

	@GetMapping("/findById/{id}")
	public Bill findById(Long id) {
		Optional<Bill> bill = this.billService.getBillById(id);
		return bill.isPresent() == true ? bill.get() : null;
	}

	@PostMapping("/findByUser")
	public Bill findByUser(@RequestBody User user) {
		return this.billService.getBillByProduct(user);
	}

	@GetMapping("/findAllBill")
	public List<Bill> findAll() {
		return this.billService.findAll();
	}
}
