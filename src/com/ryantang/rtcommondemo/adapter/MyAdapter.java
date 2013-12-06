package com.ryantang.rtcommondemo.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ryantang.common.adapter.RTAdapter;
import com.ryantang.rtcommondemo.R;
/**
 * Custom Adapter for ListView or GridView and so on
 * Use this class you can focus on the custom item view and operation
 * @Author Ryan
 * @Create 2013-8-15 上午10:26:09
 */
public class MyAdapter extends RTAdapter<TestEntity> {

	private List<TestEntity> list;
	
	//View inflater
	private LayoutInflater layoutInflater;
	
	private Context context;
	
	public MyAdapter(Context context, List<TestEntity> list) {
		this.context = context;
		this.list = list;
		//Set list for adapter
		setList(this.list);
		//Initial view inflater
		layoutInflater = LayoutInflater.from(this.context);
	}

	/**
	 * Custom your item view here
	 */
	@Override
	protected View getItemView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			convertView = layoutInflater.inflate(R.layout.item_simple_list, null);
			viewHolder = new ViewHolder();
			viewHolder.tv_id = (TextView)convertView.findViewById(R.id.tv_id);
			viewHolder.tv_name = (TextView)convertView.findViewById(R.id.tv_name);
			convertView.setTag(viewHolder);
		}else {
			viewHolder = (ViewHolder)convertView.getTag();
		}
		
		TestEntity entity = this.list.get(position);
		viewHolder.tv_id.setText(entity.getId());
		viewHolder.tv_name.setText(entity.getName());
		
		return convertView;
	}

	/*
	 * Item view entity
	 */
	private static class ViewHolder{
		private TextView tv_id;
		private TextView tv_name;
	}
}

