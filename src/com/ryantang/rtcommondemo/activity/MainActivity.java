package com.ryantang.rtcommondemo.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.ryantang.common.activity.RTActivityManager;
import com.ryantang.rtcommondemo.R;
import com.ryantang.rtcommondemo.imageloader.TestImageLoaderActivity;
import com.ryantang.rtcommondemo.pulllistview.TestRTPullListViewActivity;
import com.ryantang.rtcommondemo.slidingmenu.MainSlidingMenuActivity;
/**
 * Main Activity
 * @author Ryan
 * Create at 2013-12-6 下午12:23:43
 */
public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/**
		 * open new activity and bring a parameter
		 */
		this.findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Bundle bundle = new Bundle();
				bundle.putString("params", "TEST");
				openActivity(SecondActivity.class, bundle);
				
				/* Other ways to open new Activity */
//				openActivity(SecondActivity.class);
//				openActivity(action, pBundle)
//				openActivity(action)
				
				//close current activity
//				closeActivity();
			}
		});
		
		/**
		 * Open PullListView activity
		 */
		this.findViewById(R.id.btn_pulllistview).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				openActivity(TestRTPullListViewActivity.class);
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
		
		/**
		 * Open image loader activity
		 */
		this.findViewById(R.id.btn_imageloader).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				openActivity(TestImageLoaderActivity.class);
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
		RTActivityManager.printActivityCount();
	}
}
