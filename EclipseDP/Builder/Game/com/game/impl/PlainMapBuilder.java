package com.game.impl;

import com.game.bean.Map;
import com.game.inf.MapBuilder;

public class PlainMapBuilder extends MapBuilder {

	@Override
	public void buildSky() {
		map = new Map();
		map.sky = "Plain Blue";
	}

	@Override
	public void buildEarth() {
		map.earth = "Plain Yellow";
	}

	@Override
	public void buildBackground() {
		map.background = "Plain Gray";
	}

}
