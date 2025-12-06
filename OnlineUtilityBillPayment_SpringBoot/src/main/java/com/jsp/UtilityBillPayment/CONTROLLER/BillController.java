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
import com.jsp.UtilityBillPayment.DTO.PaymentStatus;
import com.jsp.UtilityBillPayment.SERVICE.BillService;

@RestController
@RequestMapping("/api/bills")
public class BillController {

	@Autowired
	private BillService billService;
	
	@PostMapping("/generate")
	public ResponseEntity<Bill> generateBill(@RequestParam Long userId, @RequestBody Bill bill){
		return ResponseEntity.ok(billService.generateBill(bill, userId));
	}
	
	@GetMapping("/byuser")
	public List<Bill> getBillsByUser(@RequestParam Long userId){
		return billService.getBillsByUser(userId);
	}
	
	@GetMapping("bystatus")
	public List<Bill> getBillsByStatus(@RequestParam PaymentStatus status) {
		return billService.getBillsByStatus(status);
	}
	
	@GetMapping("byuserstatus")
	public List<Bill> getBillsByUserIdAndStatus(@RequestParam Long userid,@RequestParam PaymentStatus status) {
		return billService.getBillsByUserAndStatus(userid,status);
	}
	
	@GetMapping("/byid")
	public ResponseEntity<Bill> getBillById(@RequestParam Long billId){
		return billService.getBillById(billId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	




} // End of class Block












