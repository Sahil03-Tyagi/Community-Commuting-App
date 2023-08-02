package com.cts.BillManagement.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.BillManagement.Entities.BillMaster;
import com.cts.BillManagement.Repositories.BillMasterRepo;
import com.cts.BillManagement.Services.BillManageService;

@RestController
@RequestMapping("/api/bill")
@CrossOrigin(origins = "http://localhost:4200")
public class BillManageController {
	
	
	private BillManageService billservice;
	
	@Autowired
    public BillManageController(BillManageService billService) {
        this.billservice = billService;
    }
	
	// Get Bill on the basis of Bill Id
	
	@GetMapping("/{id}")
	public ResponseEntity<List<BillMaster>> getBill(@PathVariable("id") int id) {	
		
		List<BillMaster> bill =  this.billservice.getBill(id);
		System.out.println(bill);
		if(bill==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(bill));
	}
	
	// Add new Bill
	
	@PostMapping("/new")
	public ResponseEntity<Integer> newBill(@RequestBody BillMaster bill){
		int billId = this.billservice.newBill(bill);
		return ResponseEntity.ok(billId);
	}
	
	
	// Get Monthly Bill 
	
	@GetMapping("/{month}/{rideId}")
	public ResponseEntity<List<BillMaster>> getBill(@PathVariable("month") int month,@PathVariable("rideId") int rideId) {	
		
		List<BillMaster> bill =  this.billservice.monthlyBill(month,rideId);
		
		if(bill==null) {
			System.out.println("Empty");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(bill));
	}
	
	
}
