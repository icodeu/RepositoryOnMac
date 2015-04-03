package com.simplefactory.musicbox;

public class MusicBoxFactory {

	public static IMusicBox createMusicBox(String className){
		try {
			return (IMusicBox) Class.forName(className).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
		
}
