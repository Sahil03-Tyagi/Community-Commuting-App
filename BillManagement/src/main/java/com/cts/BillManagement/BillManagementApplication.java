package com.cts.BillManagement;

import java.text.SimpleDateFormat;
import java.util.List;
import com.cts.BillManagement.Services.BillManageService;
import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.cts.BillManagement.Repositories.BillMasterRepo;
import com.cts.BillManagement.Repositories.FeesRepo;
import com.cts.BillManagement.Entities.Fees;
import com.cts.BillManagement.Entities.BillMaster;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BillManagementApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(BillManagementApplication.class, args);
		
	}

}
