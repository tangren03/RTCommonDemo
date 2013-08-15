package com.ryantang.rtcommondemo.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.ryantang.common.activity.RTActivity;
import com.ryantang.rtcommondemo.R;
import com.ryantang.rtcommondemo.pulllistview.TestRTPullListView;
import com.ryantang.rtcommondemo.slidingmenu.MainSlidingMenuActivity;

public class MainActivity extends RTActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/**
		 * Use RTActivityManager to manage your activity
		 */
		printActivityCount();
		MyActivityManager.addActivity(this);
		printActivityCount();
		
		/**
		 * open new activity and bring a parameter
		 */
		this.findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Bundle bundle = new Bundle();
				bundle.putString("params", "TEST");
				openActivity(SecondActivity.class, bundle);
				
//				openActivity(SecondActivity.class);
//				openActivity(action, pBundle)
//				openActivity(action)
				
				/**
				 * close the activity ,two ways
				 */
				MyActivityManager.finishCurrentActivity();
//				closeActivity();
				printActivityCount();
			}
		});
		
		/**
		 * Open PullListView activity
		 */
		this.findViewById(R.id.btn_pulllistview).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				openActivity(TestRTPullListView.class);
			}
		});
		
		/**
		 * Open sliding menu activity
		 */
		this.findViewById(R.id.btn_slidingmenu).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				openActivity(MainSlidingMenuActivity.class);
			}
		});
	}

	private void printActivityCount(){
		System.out.println("Activity count:"+MyActivityManager.getActivityCount());
	}

}
