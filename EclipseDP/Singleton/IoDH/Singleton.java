
public class Singleton {

	private Singleton(){}
	
	private static class HolderClass{
		private static final Singleton instance = new Singleton();
	}
	
	public static Singleton getInstance() {
		return HolderClass.instance;
	}
		
}
