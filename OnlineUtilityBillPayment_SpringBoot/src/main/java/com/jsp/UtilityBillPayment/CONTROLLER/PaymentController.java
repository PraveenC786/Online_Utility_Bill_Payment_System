package com.jsp.UtilityBillPayment.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.UtilityBillPayment.DTO.Payment;
import com.jsp.UtilityBillPayment.SERVICE.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/pay")
	public ResponseEntity<Payment> payBill(@RequestParam Long billId){
		return ResponseEntity.ok(paymentService.payBill(billId));
	}
	
	@GetMapping("/byuser")
	public List<Payment> getPaymentsByUser(Long userId){
		return paymentService.getPaymentByUser(userId);
	}
	
	@GetMapping("/all")
	public List<Payment> getAllPayments(){
		return paymentService.getAllPayments();
	}
	
//	one payment detail for one bill
	@GetMapping("/bybill")
	public ResponseEntity<Payment> getPaymentByBill(@RequestParam Long billId){
		return paymentService.getPaymentByBill(billId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
