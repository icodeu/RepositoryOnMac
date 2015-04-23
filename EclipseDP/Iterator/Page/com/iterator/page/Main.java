package com.iterator.page;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		ConcreteAggregate aggregate = new ConcreteAggregate();
		for (int i=0;i<100;i++)
			aggregate.addItem("我是第" + i / ConcreteIterator.PAGE_SIZE + "页的数据" + i);
		
		Iterator iterator = new ConcreteIterator(aggregate);
		
		// 获取第一页数据
		List<String> datas = (List<String>) iterator.firstPage();
		System.out.println(datas);
		
		// 获取下一页数据
		datas = (List<String>) iterator.nextPage();
		System.out.println(datas);
		
		// 获取上一页数据
		datas = (List<String>) iterator.prePage();
		System.out.println(datas);
		
	}
}


// 把真正的数据集合放到迭代器中  隐藏数据细节  通过迭代器的方法把数据暴露给上层
