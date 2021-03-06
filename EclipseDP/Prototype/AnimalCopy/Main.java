
public class Main {

	public static void main(String[] args) {
		CloneFactory factory = new CloneFactory();
		
		Sheep sheep = new Sheep();
		Sheep cloneSheep = (Sheep) factory.getClone(sheep);
		
		System.out.println(sheep);
		System.out.println(cloneSheep);
		
		System.out.println(sheep.hashCode());
		System.out.println(cloneSheep.hashCode());
	}

}
