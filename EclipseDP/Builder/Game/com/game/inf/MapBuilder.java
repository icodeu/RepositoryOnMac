package com.game.inf;

import com.game.bean.Map;

public abstract class MapBuilder {
	
	public Map map;
	
	public abstract void buildSky();
	public abstract void buildEarth();
	public abstract void buildBackground();
	
	public Map getResult(){
		return map;
	}

}
