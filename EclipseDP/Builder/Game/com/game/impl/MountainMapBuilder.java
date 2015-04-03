package com.game.impl;

import com.game.bean.Map;
import com.game.inf.MapBuilder;

public class MountainMapBuilder extends MapBuilder {

	@Override
	public void buildSky() {
		map = new Map();
		map.sky = "Mountain Blue";
	}

	@Override
	public void buildEarth() {
		map.earth = "Mountain Yellow";
	}

	@Override
	public void buildBackground() {
		map.background = "Mountain Gray";
	}

}
