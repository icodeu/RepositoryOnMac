
public class Main {

	public static void main(String[] args) {
		
		GBTwoPlug twoPlug = new GBTwoPlug();
		IThreePlug threePlug = new TwoPlugAdapter(twoPlug);
		
		NoteBook nb = new NoteBook(threePlug);
		nb.charge();
		
		
		
	}
	
	
}
