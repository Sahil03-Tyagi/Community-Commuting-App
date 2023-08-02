package com.cts.BillManagement;

import java.util.Arrays;
import java.util.List;
import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cts.BillManagement.Services.BillManageService;

import com.cts.BillManagement.Repositories.BillMasterRepo;
import com.cts.BillManagement.Repositories.FeesRepo;
import com.cts.BillManagement.Entities.*;

@SpringBootTest
class BillManagementApplicationTests {

	@Mock
	private BillMasterRepo billMasterRepo;
	private FeesRepo feesRepo;
	

	// Test GetBill Method for existing Bill ID
	@Test
	void testGetBill_ExistingBillId() {

		BillMaster expectedBill = new BillMaster();

		Mockito.when(billMasterRepo.findById(252)).thenReturn(Optional.of(expectedBill));

		BillManageService billClass = new BillManageService(billMasterRepo, feesRepo);

		List<BillMaster> result = billClass.getBill(252);

		// Verify the result
		Assertions.assertEquals(Arrays.asList(expectedBill), result);
	}
	
	
	// Test GetBill method for non existing bill ID
	@Test
	void testGetBill_NonExistingBillId() {
		
		Mockito.when(billMasterRepo.findById(2)).thenReturn(null);

		BillManageService billClass = new BillManageService(billMasterRepo, feesRepo);

		List<BillMaster> result = billClass.getBill(2);

		// Verify the result
		Assertions.assertNull(result);
	}
	
	
	// Test Monthly Bill Method
	@Test
	void testMonthlyBill() {

		Mockito.when(billMasterRepo.findByRideMonth(7, 1)).thenReturn(new ArrayList<>());

		BillManageService billClass = new BillManageService(billMasterRepo, feesRepo);

		List<BillMaster> result = billClass.monthlyBill(7, 1);

		// Verify the result
		Assertions.assertNull(result);
	}

}
