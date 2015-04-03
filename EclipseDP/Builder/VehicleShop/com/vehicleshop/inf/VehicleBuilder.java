package com.vehicleshop.inf;

import com.vehicleshop.bean.Vehicle;

public abstract class VehicleBuilder {
	
	public Vehicle vehicle;

	public abstract void buildFrame();
	public abstract void buildEngine();
	public abstract void buildWheels();
	public abstract void buildDoors();
	
	public Vehicle getResult(){
		return vehicle;
	}

}
