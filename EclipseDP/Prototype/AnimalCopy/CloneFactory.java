
public class CloneFactory {
	
	public IAnimal getClone(IAnimal animalSample){
		return animalSample.makeCopy();
	}

}
