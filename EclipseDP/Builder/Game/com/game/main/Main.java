package com.game.main;

import com.game.bean.Map;
import com.game.impl.MountainMapBuilder;
import com.game.impl.PlainMapBuilder;
import com.game.inf.MapBuilder;

public class Main {

	public static void main(String[] args) {
		Director director = new Director();
		MapBuilder builder = new MountainMapBuilder();  // MountainMapBuilder --> PlainMapBuilder
		director.construct(builder);
		Map map = builder.getResult();
		map.show();
	}

}
