package com.icodeyou.pocketcode.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.icodeyou.pocketcode.MainActivity;
import com.icodeyou.pocketcode.R;

public class ThirdFragment extends Fragment {

	private ImageView enter_img;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_third, container, false);
		enter_img = (ImageView) view.findViewById(R.id.enter_img);
		enter_img.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), MainActivity.class);
				startActivity(intent);
				getActivity().finish();
			}
		});
		return view;
	}

}
