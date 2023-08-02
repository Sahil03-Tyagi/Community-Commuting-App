package com.cts.BillManagement.Repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.BillManagement.Entities.BillMaster;

@Repository
public interface BillMasterRepo extends JpaRepository<BillMaster, Integer> {
	
	// Custom query to get data on the basis of ride id and month
	
	@Query(value = "select * from bill_master b where ride_id =:r and month(date) =:m", nativeQuery=true)
	List<BillMaster> findByRideMonth(@Param("m")int Month,@Param("r")int rideId);


}
