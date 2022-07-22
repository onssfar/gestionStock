package com.management.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.demo.entities.Bill;
import com.management.demo.entities.Product;
import com.management.demo.entities.User;
import com.management.demo.repository.BillRepository;

@Service
public class BillService {

	@Autowired
	private BillRepository billRepository;

	public Bill saveBill(Bill bill) {
		Optional<Product> exist = bill.getProduts().stream()
				.filter(product -> product.getQuantity() - bill.getQuantity() < 0).findAny();
		if (exist.isPresent())
			return new Bill();
		bill.getProduts().stream().forEach(product -> product.setQuantity(product.getQuantity() - bill.getQuantity()));
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
