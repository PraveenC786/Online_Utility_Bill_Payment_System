package com.jsp.UtilityBillPayment.SERVICE;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.UtilityBillPayment.DTO.Bill;
import com.jsp.UtilityBillPayment.DTO.Payment;
import com.jsp.UtilityBillPayment.DTO.PaymentStatus;
import com.jsp.UtilityBillPayment.REPOSITORY.BillRepository;
import com.jsp.UtilityBillPayment.REPOSITORY.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepo;

	@Autowired
	private BillRepository billRepo;
	
	public Payment payBill(Long billId) {
		Bill bill = billRepo.findById(billId)
				.orElseThrow(()-> new RuntimeException("Bill not found...!"));
		
		if(bill.getPaymentStatus() == PaymentStatus.PAID) {
			throw new RuntimeException("Bill is Already Paid");
		}
		// create a payment
		Payment payment = new Payment();
		payment.setAmountPaid(bill.getAmount());
		payment.setPaymentDate(LocalDate.now());
		payment.setStatus(PaymentStatus.PAID);
		payment.setBill(bill);

		// update bill
		bill.setPaymentStatus(PaymentStatus.PAID);
		bill.setPayment(payment);

		billRepo.save(bill); // saves both bill and payment via cascade
		// paymentRepo.save(payment);
		return payment;
	}
	
	// to get all payments for a particular user
	public List<Payment> getPaymentByUser(Long userId){
		return paymentRepo.findByBillUserUserId(userId);
	}
	
	// to get payment for a particular bill
	public Optional<Payment> getPaymentByBill(Long billId){
		return paymentRepo.findByBillBillId(billId);
	}
	
	// to get all payment objects
	public List<Payment> getAllPayments(){
		return paymentRepo.findAll();
	}
}
