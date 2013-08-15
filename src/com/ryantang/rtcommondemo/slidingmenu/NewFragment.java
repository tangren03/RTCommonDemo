package com.ryantang.rtcommondemo.slidingmenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ryantang.rtcommondemo.R;

public class NewFragment extends Fragment {

	public NewFragment(){
		setRetainInstance(true);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_sm_mainpage ,null);
		TextView textView = (TextView)view.findViewById(R.id.tv_text);
		textView.setText("This is a new fragment");
		return view;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	
}
