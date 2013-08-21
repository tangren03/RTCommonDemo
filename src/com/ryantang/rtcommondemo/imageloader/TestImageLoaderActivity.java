package com.ryantang.rtcommondemo.imageloader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.ryantang.rtcommondemo.R;
import com.ryantang.rtcommondemo.imageloader.Constants.Extra;
/**
 * Main page Activity
 * @Author Ryan
 * @Create 2013-7-3 下午10:01:31
 */
public class TestImageLoaderActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_loader);
		
		this.findViewById(R.id.btn_listview).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(TestImageLoaderActivity.this, ImageListActivity.class);
				intent.putExtra(Extra.IMAGES, Constants.IMAGES);
				startActivity(intent);
			}
		});
		
		this.findViewById(R.id.btn_gridview).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(TestImageLoaderActivity.this, ImageGridActivity.class);
				intent.putExtra(Extra.IMAGES, Constants.IMAGES);
				startActivity(intent);
			}
		});
		
		this.findViewById(R.id.btn_viewpager).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(TestImageLoaderActivity.this, ImagePagerActivity.class);
				intent.putExtra(Extra.IMAGES, Constants.IMAGES);
				startActivity(intent);
			}
		});
	}


}
