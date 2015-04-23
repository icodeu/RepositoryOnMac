package com.decorator.average;

import java.util.List;

public class GreaterDecorator extends CalcDecorator {

	private Average average;
	
	public GreaterDecorator(Average average) {
		super(average);
		this.average = average;
	}
	
	@Override
	public void calc() {
		super.calc();
		calcGreater();
	}
	
	// 既然是装饰者  那就要增加新的方法
	public void calcGreater(){
		int counter = 0;
		List<Integer> data = average.getData();
		double ave = average.calc();
		for (int i=0;i<data.size();i++)
			if (data.get(i) > ave)
				counter++;
		System.out.println("超过平均值的个数为 : " + counter);
	}

}
