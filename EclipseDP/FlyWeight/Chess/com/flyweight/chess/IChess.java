package com.flyweight.chess;

public abstract class IChess {
	
	public abstract String getColor();
	
	public void display(Position pos){
		System.out.print("棋子颜色 : " + getColor());
		System.out.println("   棋子位置 : " + "x->" + pos.getX() + " y->" + pos.getY());
	}

}
