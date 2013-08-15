package com.ryantang.rtcommondemo.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.ryantang.common.activity.RTActivity;
import com.ryantang.rtcommondemo.R;

public class SecondActivity extends RTActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		MyActivityManager.addActivity(this);
		
		TextView textView = (TextView)this.findViewById(R.id.txt);
		String paramsString = getIntent().getStringExtra("params");
		textView.setText(paramsString);
		
		
	}

	

}
