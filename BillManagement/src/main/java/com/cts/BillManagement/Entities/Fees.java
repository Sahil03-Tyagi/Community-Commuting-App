package com.cts.BillManagement.Entities;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Transactional
@Entity
@Table(name = "fees")
public class Fees {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "feeId")
	private int feeId;
	@Column(name = "carType")
	private String carType;
	@Column(name = "carName")
	private String carName;
	@Column(name = "fuelType")
	private String fuelType;
	@Column(name = "averageInKm")
	private int averageInKm;
	@Column(name = "costOfFuel")
	private int costOfFuel;
	@Column(name = "wearTearCost")
	private int wearTearCost;
	@Column(name = "drivercharges")
	private int drivercharges;
	@Column(name = "carPoolCommision")
	private int carPoolCommision;
	@Column(name="noOfkm")
	private int noOfkm;
	@Column(name="noOfOccupants")
	private int noOfOccupants;
	@Column(name="rideId")
	private int rideId;
	

	@JsonManagedReference
	@OneToMany(mappedBy = "fee", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BillMaster> billMaster = new ArrayList<>();
	

	public Fees(int feeId, String carType, String carName, String fuelType, int averageInKm, int costOfFuel,
			int wearTearCost, int drivercharges, int carPoolCommision) {
		super();
		this.feeId = feeId;
		this.carType = carType;
		this.carName = carName;
		this.fuelType = fuelType;
		this.averageInKm = averageInKm;
		this.costOfFuel = costOfFuel;
		this.wearTearCost = wearTearCost;
		this.drivercharges = drivercharges;
		this.carPoolCommision = carPoolCommision;
	}

	public List<BillMaster> getBillMaster() {
		return billMaster;
	}

	public void setBillMaster(List<BillMaster> billMaster) {
		this.billMaster = billMaster;
	}

	public int getFeeId() {
		return feeId;
	}

	public void setFeeId(int feeId) {
		this.feeId = feeId;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getAverageInKm() {
		return averageInKm;
	}

	public void setAverageInKm(int averageInKm) {
		this.averageInKm = averageInKm;
	}

	public int getCostOfFuel() {
		return costOfFuel;
	}

	public void setCostOfFuel(int costOfFuel) {
		this.costOfFuel = costOfFuel;
	}

	public int getWearTearCost() {
		return wearTearCost;
	}

	public void setWearTearCost(int wearTearCost) {
		this.wearTearCost = wearTearCost;
	}

	public int getDrivercharges() {
		return drivercharges;
	}

	public void setDrivercharges(int drivercharges) {
		this.drivercharges = drivercharges;
	}

	public int getCarPoolCommision() {
		return carPoolCommision;
	}

	public void setCarPoolCommision(int carPoolCommision) {
		this.carPoolCommision = carPoolCommision;
	}

	@Override
	public String toString() {
		return "Fees [feeId=" + feeId + ", carType=" + carType + ", carName=" + carName + ", fuelType=" + fuelType
				+ ", averageInKm=" + averageInKm + ", costOfFuel=" + costOfFuel + ", wearTearCost=" + wearTearCost
				+ ", drivercharges=" + drivercharges + ", carPoolCommision=" + carPoolCommision + ", billMaster=" + "]";
	}

	public int getNoOfkm() {
		return noOfkm;
	}

	public void setNoOfkm(int noOfkm) {
		this.noOfkm = noOfkm;
	}

	public int getNoOfOccupants() {
		return noOfOccupants;
	}

	public void setNoOfOccupants(int noOfOccupants) {
		this.noOfOccupants = noOfOccupants;
	}

	public int getRideId() {
		return rideId;
	}

	public void setRideId(int rideId) {
		this.rideId = rideId;
	}


	public Fees() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
