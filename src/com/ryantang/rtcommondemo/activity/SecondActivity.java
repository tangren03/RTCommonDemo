package com.ryantang.rtcommondemo.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.ryantang.rtcommondemo.R;
import com.ryantang.rtcommondemo.adapter.MyAdapter;
import com.ryantang.rtcommondemo.adapter.TestEntity;
/**
 * 
 * SecondActivity.java
 * @author Ryan
 * Create at 2013-12-6 下午1:22:23
 */
public class SecondActivity extends BaseActivity {

	private ListView listView;
	private TextView textView;
	private List<TestEntity> list;
	private MyAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		textView = (TextView) this.findViewById(R.id.txt);
		listView = (ListView)this.findViewById(R.id.lv_list);
		
		//Get parameter from last activity
		String paramsString = getIntent().getStringExtra("params");
		textView.setText(paramsString);

		//Use custom Adapter for ListView
		list = new ArrayList<TestEntity>();
		TestEntity entity = null;
		for (int i = 0; i < 10; i++) {
			entity = new TestEntity();
			entity.setId(i+"");
			entity.setName("Name"+i);
			list.add(entity);
			entity = null;
		}
		//MyAdapter extends from RTAdapter
		adapter = new MyAdapter(this, list);
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				list.remove(0);
				adapter.notifyDateSetUpdate(list);
			}
		});
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
}
