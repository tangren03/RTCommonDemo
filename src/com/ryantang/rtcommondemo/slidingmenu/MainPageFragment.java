package com.ryantang.rtcommondemo.slidingmenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ryantang.rtcommondemo.R;
/**
 * Main page fragment for slidingmenu
 * @author Ryan
 *
 */
public class MainPageFragment extends Fragment{

	public MainPageFragment(){
		setRetainInstance(true);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.activity_sm_mainpage, null);
	    //do something...
		return view;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();
	}
	
	
}
