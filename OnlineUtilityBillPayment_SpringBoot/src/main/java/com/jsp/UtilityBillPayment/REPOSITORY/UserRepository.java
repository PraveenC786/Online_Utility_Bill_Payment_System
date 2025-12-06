package com.jsp.UtilityBillPayment.REPOSITORY;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.UtilityBillPayment.DTO.Bill;
import com.jsp.UtilityBillPayment.DTO.User;

public interface UserRepository extends JpaRepository<User,Long>{

	// Find all Bill records where user.userId field 
	// Equals the provided userId value
	List<Bill> findByUserUserId(Long userId);
	
	//select b from Bill b where b.user.userId=?
	
}
