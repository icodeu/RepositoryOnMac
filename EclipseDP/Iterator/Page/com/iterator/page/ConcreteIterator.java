package com.iterator.page;

import java.util.ArrayList;
import java.util.List;

public class ConcreteIterator implements Iterator {

	//假定一页十条数据
	public static final int PAGE_SIZE = 10;
	
	private ConcreteAggregate aggregate;
	private int currentPage = 0;
	
	public ConcreteIterator(ConcreteAggregate aggregate) {
		this.aggregate = aggregate;
	}

	@Override
	public Object firstPage() {
		List<String> datas = new ArrayList<String>();
		for (int i=0;i<PAGE_SIZE;i++)
			datas.add(aggregate.getItem(i));
		return datas;
	}

	@Override
	public Object nextPage() {
		currentPage++;
		List<String> datas = new ArrayList<String>();
		for (int i=currentPage * PAGE_SIZE;i<(currentPage + 1)*PAGE_SIZE;i++)
			datas.add(aggregate.getItem(i));
		return datas;
	}

	@Override
	public Object currentPage() {
		List<String> datas = new ArrayList<String>();
		for (int i=currentPage * PAGE_SIZE;i<(currentPage + 1)*PAGE_SIZE;i++)
			datas.add(aggregate.getItem(i));
		return datas;
	}

	@Override
	public Object prePage() {
		currentPage--;
		List<String> datas = new ArrayList<String>();
		for (int i=currentPage * PAGE_SIZE;i<(currentPage + 1)*PAGE_SIZE;i++)
			datas.add(aggregate.getItem(i));
		return datas;
	}

}
