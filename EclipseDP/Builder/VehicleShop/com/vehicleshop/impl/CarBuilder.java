package com.vehicleshop.impl;

import com.vehicleshop.bean.Vehicle;
import com.vehicleshop.inf.VehicleBuilder;

public class CarBuilder extends VehicleBuilder {

	@Override
	public void buildFrame() {
		vehicle = new Vehicle("Car");
		vehicle.frame = "Car Frame";
	}

	@Override
	public void buildEngine() {
		vehicle.engine = "Car 2500cc";
	}

	@Override
	public void buildWheels() {
		vehicle.wheels = "Car 4 wheels";
	}

	@Override
	public void buildDoors() {
		vehicle.doors = "Car 4 doors";
	}

}
