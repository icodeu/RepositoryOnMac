import com.vehicleshop.inf.VehicleBuilder;


public class Shop {

	public void Construct(VehicleBuilder vehicleBuilder){
		vehicleBuilder.buildFrame();
		vehicleBuilder.buildEngine();
		vehicleBuilder.buildWheels();
		vehicleBuilder.buildDoors();
	}
	
}
