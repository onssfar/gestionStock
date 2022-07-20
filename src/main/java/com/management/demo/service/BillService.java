package com.management.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.demo.entities.Bill;
import com.management.demo.entities.User;
import com.management.demo.repository.BillRepository;

@Service
public class BillService {

	@Autowired
	private BillRepository billRepository;

	public Bill saveBill(Bill bill) {
		return this.billRepository.save(bill);
	}

	public Bill getBillByProduct(User user) {
		return this.billRepository.findByUser(user);
	}

	public Optional<Bill> getBillById(Long id) {
		return this.billRepository.findById(id);
	}

	public List<Bill> findAll() {
		return this.billRepository.findAll();
	}
}
