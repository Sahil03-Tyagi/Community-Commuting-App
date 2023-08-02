package com.cts.BillManagement.Entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="billMaster")
public class BillMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="billId")	
	private int billId;
	
	@Column(name="rideId")
	private int rideId;
	
	@Column(name="totalbill")
	private int totalbill;
	
	@Column(name="date")
	private Date date;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="fee_Id")
	private Fees fee;
	
	@Column(name="costPerOccupant")
	private int costPerOccupant;
	
	public BillMaster(int billId, int rideId, int totalbill, Fees fee,
			int costPerOccupant) {
		super();
		this.billId = billId;
		this.rideId = rideId;
		this.totalbill = totalbill;
		this.fee = fee;
		this.costPerOccupant = costPerOccupant;
	}
	
	

	public BillMaster() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getRideId() {
		return rideId;
	}

	public void setRideId(int rideId) {
		this.rideId = rideId;
	}

	

	public int getTotalbill() {
		return totalbill;
	}

	public void setTotalbill(int totalCost) {
		this.totalbill = totalCost;
	}

	

	public Fees getFee() {
		return fee;
	}

	public void setFee(Fees fee) {
		this.fee = fee;
	}

	public int getCostPerOccupant() {
		return costPerOccupant;
	}

	public void setCostPerOccupant(int costPerOccupant) {
		this.costPerOccupant = costPerOccupant;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	@Override
	public String toString() {
		return "BillMaster [billId=" + billId + ", rideId=" + rideId + ", totalbill=" + totalbill + ", date=" + date
				+ ", fee=" + fee + ", costPerOccupant=" + costPerOccupant + "]";
	}

	
	

}
