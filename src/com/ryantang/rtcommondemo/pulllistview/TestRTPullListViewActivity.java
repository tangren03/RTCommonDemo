package com.ryantang.rtcommondemo.pulllistview;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.ryantang.common.pulllistview.RTPullListView;
import com.ryantang.common.pulllistview.RTPullListView.OnRefreshListener;
import com.ryantang.rtcommondemo.R;
import com.ryantang.rtcommondemo.activity.BaseActivity;
/**
 * Use RTPullListView
 * TestRTPullListView.java
 * @author Ryan
 * Create at 2013-12-6 下午1:26:01
 */
public class TestRTPullListViewActivity extends BaseActivity {

	private static final int LOAD_MORE_SUCCESS = 1;
	private static final int LOAD_NEW_INFO = 2;
	
	private RTPullListView pullListView;
	private ProgressBar moreProgressBar;
	
	private List<String> dataList;
	private ArrayAdapter<String> adapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulllistview);
        
        pullListView = (RTPullListView) this.findViewById(R.id.pullListView);
        
        /**
         * simulation data
         */
        dataList = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			dataList.add("Item data "+i);
		}
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataList);
		pullListView.setAdapter(adapter);
		
		/**
		 * Custom button on the bottom of the ListView
		 */
        LayoutInflater inflater = LayoutInflater.from(this);
		View view = inflater.inflate(R.layout.pulllist_foot, null);
		RelativeLayout footerView =(RelativeLayout) view.findViewById(R.id.list_footview);
		moreProgressBar = (ProgressBar) view.findViewById(R.id.footer_progress);
		pullListView.addFooterView(footerView);
		
		/**
		 * Listener for pull
		 */
		pullListView.setonRefreshListener(new OnRefreshListener() {
			
			@Override
			public void onRefresh() {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							/**
							 * Simulation data refreash
							 */
							Thread.sleep(2000);
							dataList.clear();
							for (int i = 0; i < 5; i++) {
								dataList.add("Item data "+i);
							}
							myHandler.sendEmptyMessage(LOAD_NEW_INFO);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}).start();
			}
		});

		/**
		 * Listener for more
		 */
		footerView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				moreProgressBar.setVisibility(View.VISIBLE);
				
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							Thread.sleep(2000);
							for (int i = 0; i < 5; i++) {
								dataList.add("New item data "+i);
							}
							myHandler.sendEmptyMessage(LOAD_MORE_SUCCESS);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}).start();
			}
		});
    }
    
    /**
     * Handle result
     */
    @SuppressLint("HandlerLeak")
	private Handler myHandler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case LOAD_MORE_SUCCESS:
				moreProgressBar.setVisibility(View.GONE);
				adapter.notifyDataSetChanged();
				pullListView.setSelectionfoot();
				break;

			case LOAD_NEW_INFO:
				adapter.notifyDataSetChanged();
				pullListView.onRefreshComplete();
				break;
			default:
				break;
			}
		}
    	
    };
}
