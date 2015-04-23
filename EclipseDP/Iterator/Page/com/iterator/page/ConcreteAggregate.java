package com.iterator.page;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAggregate implements Aggregate {

	private List<String> datas = new ArrayList<String>();
	
	@Override
	public Iterator createIterator() {
		return new ConcreteIterator(this);
	}
	
	public int getLength(){
		return datas.size();
	}
	
	public String getItem(int i){
		return datas.get(i);
	}
	
	public void addItem(String item){
		datas.add(item);
	}

}
