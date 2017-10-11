
public class NoteBook {
	
	private IThreePlug threePlug;
	
	public NoteBook(IThreePlug threePlug){
		this.threePlug = threePlug;
	}
	
	public void charge(){
		threePlug.powerWithThree();
	}

}
