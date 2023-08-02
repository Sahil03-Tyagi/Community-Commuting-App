package com.cts.BillManagement.Services;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.BillManagement.Entities.BillMaster;
import com.cts.BillManagement.Entities.Fees;
import com.cts.BillManagement.Repositories.BillMasterRepo;
import com.cts.BillManagement.Repositories.FeesRepo;

@Service
public class BillManageService {

	private BillMasterRepo billMasterRepo;
	private FeesRepo feesRepo;

	@Autowired
	public BillManageService(BillMasterRepo billMasterRepo, FeesRepo feesRepo) {
		super();
		this.billMasterRepo = billMasterRepo;
		this.feesRepo = feesRepo;
	}

	
	// Get Bill on the basis of Bill Id

	public List<BillMaster> getBill(int billId) {

		if(billMasterRepo.findById(billId)==null) {
			return null;
		}
		Optional<BillMaster> bill = billMasterRepo.findById(billId);
		List<BillMaster> objects2 = Arrays.asList(bill.get());
		return objects2;

		
	}
	
	// Add new Bill in Bill Master table
	
	public int newBill(BillMaster bill){
		BillMaster billMaster = billMasterRepo.save(bill);
	
		return billMaster.getBillId();
	}
	
	// Get Bill on the basis of Month and Ride Id

	public List<BillMaster> monthlyBill(int month, int rideId) {
		
		if(billMasterRepo.findByRideMonth(month, rideId).isEmpty()) {
			return null;
		}

		List<BillMaster> bill = billMasterRepo.findByRideMonth(month, rideId);
		return bill;
	}

}
