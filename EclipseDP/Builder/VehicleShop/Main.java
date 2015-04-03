import com.vehicleshop.bean.Vehicle;
import com.vehicleshop.impl.CarBuilder;
import com.vehicleshop.impl.MotorBuilder;
import com.vehicleshop.inf.VehicleBuilder;


public class Main {

	public static void main(String[] args) {
		Shop shop = new Shop();
		VehicleBuilder builder = new CarBuilder();   //只需更改  CarBuilder --> MotorBuilder
		shop.Construct(builder);
		Vehicle vehicle = builder.getResult();
		vehicle.show();
	}

}
