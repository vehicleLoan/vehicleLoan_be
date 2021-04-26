package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="vl_vehicle_details")
public class VehicleDetails {
	
	@Id
	@SequenceGenerator(name="vehicle_seq",initialValue=800,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="vehicle_seq")
	int vehicleId;
	
	String vehicleType;
	
	String vehicleMake;
	
	String vehicleModel;
	
	String vehicleState;
	
	String vehicleCity;
	
	@OneToOne(mappedBy="vehicle",cascade=CascadeType.ALL)
	Loan loan;

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleMake() {
		return vehicleMake;
	}

	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}

	public String getVehicleState() {
		return vehicleState;
	}

	public void setVehicleState(String vehicleState) {
		this.vehicleState = vehicleState;
	}

	public String getVehicleCity() {
		return vehicleCity;
	}

	public void setVehicleCity(String vehicleCity) {
		this.vehicleCity = vehicleCity;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	@JsonIgnore
	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}
	
	
}
