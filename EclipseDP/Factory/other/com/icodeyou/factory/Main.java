package com.icodeyou.factory;

public class Main {
	
	private static final String KEY_LEFT = "left";
	private static final String KEY_RIGHT = "right";
	private static final String KEY_MID = "mid";
			
	public static void main(String[] args) {
		HairFactory hairFactory = new HairFactory();
		IHair iHair = hairFactory.getHair("right");
		iHair.draw();
		
		iHair = hairFactory.getHairByClass("com.icodeyou.factory.LeftHair");
		iHair.draw();
		
		iHair = hairFactory.getHairByClassKey(KEY_MID);
		iHair.draw();
	}

}
