package com.jsp.UtilityBillPayment.REPOSITORY;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.UtilityBillPayment.DTO.Bill;
import com.jsp.UtilityBillPayment.DTO.PaymentStatus;

public interface BillRepository extends JpaRepository<Bill, Long> {

	// Find all Bill records where user.userId field equals the provided userId value
		// Spring Data JPA will itself form(create) this query
		// --> " select b from Bill b where b.user.userId=? "
		// based on the method declaration
		List<Bill> findByUserUserId(Long userId);
		
		// Find all Bill records where status field equals the given status
		List<Bill> findByStatus(PaymentStatus status);
		
		// Find all Bill entries where the associated User's userId equals the given value, 
		// AND the status equals the given status.
		List<Bill> findByUserUserIdAndStatus(Long userId, PaymentStatus status);
}
