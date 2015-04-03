package com.vehicleshop.impl;

import com.vehicleshop.bean.Vehicle;
import com.vehicleshop.inf.VehicleBuilder;

public class MotorBuilder extends VehicleBuilder {

	@Override
	public void buildFrame() {
		vehicle = new Vehicle("MotorCycle");
		vehicle.frame = "MotorCycle Frame";
	}

	@Override
	public void buildEngine() {
		vehicle.engine = "Motor 500cc";
	}

	@Override
	public void buildWheels() {
		vehicle.wheels = "Motor 2 wheels";
	}

	@Override
	public void buildDoors() {
		vehicle.doors = "Motor no doors";
	}

}
