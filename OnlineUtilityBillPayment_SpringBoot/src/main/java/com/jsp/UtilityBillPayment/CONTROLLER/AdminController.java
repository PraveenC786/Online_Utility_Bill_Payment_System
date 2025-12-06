package com.jsp.UtilityBillPayment.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.UtilityBillPayment.DTO.Bill;
import com.jsp.UtilityBillPayment.DTO.Payment;
import com.jsp.UtilityBillPayment.DTO.User;
import com.jsp.UtilityBillPayment.SERVICE.BillService;
import com.jsp.UtilityBillPayment.SERVICE.PaymentService;
import com.jsp.UtilityBillPayment.SERVICE.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BillService billService;
	
	@Autowired
	private PaymentService paymentService;


	//admin generates bill for a user
	@PostMapping("/generatebill")
	public ResponseEntity<Bill> generateBill(@RequestParam Long userId, @RequestBody Bill bill){
		return ResponseEntity.ok(billService.generateBill(bill, userId));
	}
	
	// admin views all users
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	// admin views all payments
	public List<Payment> getAllPayments() {
		return paymentService.getAllPayments();
	} 
	
	// admin views all bills
	@GetMapping("/bills")
	public List<Bill> getAllBills(){
		return billService.getAllBills();
	}


} 

















