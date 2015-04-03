
public class Sheep implements IAnimal{

	public Sheep() {
		System.out.println("Sheep Made");
	}
	
	@Override
	public IAnimal makeCopy() {
		System.out.println("Sheep is being Made");
		
		Sheep sheep = null;
		
		try {
			sheep = (Sheep) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sheep;
	}
	
	@Override
	public String toString() {
		return "Dolly is my hero~~~";
	}

}
