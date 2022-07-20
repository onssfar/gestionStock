package com.management.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.management.demo.entities.Bill;
import com.management.demo.entities.User;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long>{

	public Bill findByUser(User user);
}
