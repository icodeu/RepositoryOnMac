package com.composite.shapetrans;

public class Main {

	public static void main(String[] args) {

		// 测试 直线 和 圆
		IShape line = new Line("直线A");
		line.add(new Line("直线B"));
		line.draw();
		
		IShape circle = new Circle("圆A");
		circle.remove(new Circle("圆B"));
		circle.draw();
		
		// 测试 复杂图形树
		IShape complexShape = new ComplexShape("复杂图形树");
		IShape line1 = new Line("直线1");
		IShape circle1 = new Circle("圆1");
			// 添加基本图形后 draw
		complexShape.add(line1);
		complexShape.add(circle1);
		complexShape.draw();
			// 移除基本图形后 draw
		complexShape.remove(line1);
		complexShape.draw();
		
	}

}
