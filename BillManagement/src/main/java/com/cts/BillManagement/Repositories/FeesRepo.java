package com.cts.BillManagement.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.BillManagement.Entities.Fees;

@Repository
public interface FeesRepo extends JpaRepository<Fees, Integer> {
	List<Fees> findByCarTypeAndFuelType(String carType, String fuelType);

}
