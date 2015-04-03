package com.game.main;

import com.game.inf.MapBuilder;

public class Director {
	
	public void construct(MapBuilder mapBuilder){
		mapBuilder.buildSky();
		mapBuilder.buildEarth();
		mapBuilder.buildBackground();
	}

}
