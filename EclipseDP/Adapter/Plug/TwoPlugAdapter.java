
public class TwoPlugAdapter implements IThreePlug {

	private GBTwoPlug twoPlug;
	
	public TwoPlugAdapter(GBTwoPlug twoPlug) {
		this.twoPlug = twoPlug;
	}
	
	@Override
	public void powerWithThree() {
		System.out.println("三相转二相");
		twoPlug.powerWithTwo();
	}

}
