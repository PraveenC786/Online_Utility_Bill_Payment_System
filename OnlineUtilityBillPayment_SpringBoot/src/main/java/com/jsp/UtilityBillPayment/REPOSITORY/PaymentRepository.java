package com.jsp.UtilityBillPayment.REPOSITORY;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.UtilityBillPayment.DTO.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
	
	// this method returns all payments where the bill is associated with a user 
	// whose user ID matches the given userId.
	List<Payment> findByBillUserUserId(Long userId);

	
	// This method returns the Payment that is associated with a Bill having the given billId — 
	// wrapped inside an Optional.
	Optional<Payment> findByBillBillId(Long billId);
}
