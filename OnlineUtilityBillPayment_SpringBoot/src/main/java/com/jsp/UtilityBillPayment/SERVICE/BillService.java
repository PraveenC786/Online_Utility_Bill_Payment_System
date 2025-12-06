package com.jsp.UtilityBillPayment.SERVICE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.UtilityBillPayment.DTO.Bill;
import com.jsp.UtilityBillPayment.DTO.PaymentStatus;
import com.jsp.UtilityBillPayment.DTO.User;
import com.jsp.UtilityBillPayment.REPOSITORY.BillRepository;
import com.jsp.UtilityBillPayment.REPOSITORY.UserRepository;

@Service
public class BillService {

	@Autowired
	private BillRepository billRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	// to generate Bill for a user
	public Bill generateBill(Bill bill, Long userId) {
		// if userId is present , it returns user object, which we are storing.
		// if userId is not present , exception will be thrown.
		User user = userRepo.findById(userId)
				.orElseThrow(()-> new RuntimeException("User Not Found...!"));
		
		// set the user to the bill
		bill.setUser(user);
		
		// setting the initial payment status to pending until payment is done.
		bill.setPaymentStatus(PaymentStatus.PENDING);
		
		// storing the Bill into DB
		return billRepo.save(bill);
	}
	
	// to get bills based on userId
	public List<Bill> getBillsByUser(Long userId){
		return billRepo.findByUserUserId(userId);
	}
	
	// to get bills based on status
	public List<Bill> getBillsByStatus(PaymentStatus status){
		return billRepo.findByStatus(status);
	}
	
	// to get bills based on userId and status
	public List<Bill> getBillsByUserAndStatus(Long userId, PaymentStatus status){
		return billRepo.findByUserUserIdAndStatus(userId , status);
	}
	
	
	// to get the bill based on bill ID
	public Optional<Bill> getBillById(Long billId){
		return billRepo.findById(billId);
	}
	
	// to get all bills
	public List<Bill> getAllBills(){
		return billRepo.findAll();
	}
}




















