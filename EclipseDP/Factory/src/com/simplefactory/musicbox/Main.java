package com.simplefactory.musicbox;

public class Main {
	
	public static void main(String[] args) {
		IMusicBox mb = null;
		
		playMusicBox(MusicBoxFactory.createMusicBox("com.simplefactory.musicbox.PianoBox"));
		playMusicBox(MusicBoxFactory.createMusicBox("com.simplefactory.musicbox.ViolinBox"));
	}
	
	private static void playMusicBox(IMusicBox mb){
		mb.play();
	}

}
