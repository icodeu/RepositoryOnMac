package com.icodeyou.pocketcode.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.icodeyou.pocketcode.R;
import com.icodeyou.pocketcode.model.Category;

public class CategoryAdapter extends BaseAdapter {

	private Context context;
	private List<Category> categoryList;

	public CategoryAdapter(Context context, List<Category> categoryList) {
		this.context = context;
		this.categoryList = categoryList;
	}

	@Override
	public int getCount() {
		return categoryList.size();
	}

	@Override
	public Object getItem(int position) {
		return categoryList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Category category = categoryList.get(position);
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.category_item, null);
		}
		TextView category_name = (TextView) convertView
				.findViewById(R.id.category_name);
		category_name.setText(category.getCategory_name());
		ImageView indicator = (ImageView) convertView
				.findViewById(R.id.indicator);
		if (category.getSelected()) {
			indicator.setVisibility(View.VISIBLE);
		} else {
			indicator.setVisibility(View.GONE);
		}
		return convertView;
	}
}
