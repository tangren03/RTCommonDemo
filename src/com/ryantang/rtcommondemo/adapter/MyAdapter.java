package com.ryantang.rtcommondemo.adapter;

import java.util.List;

import android.view.View;
import android.view.ViewGroup;

import com.ryantang.common.adapter.RTAdapter;
/**
 * Custom adapter for ListView or GridView
 * @Author Ryan
 * @Create 2013-8-15 上午10:26:09
 */
public class MyAdapter extends RTAdapter<TestEntity> {

	private List<TestEntity> list;
	
	public MyAdapter(List<TestEntity> list) {
		super(list);
		this.list = list;
		
		//Set list for adapter
		setList(this.list);
	}

	@Override
	protected View getItemView(int position, View convertView, ViewGroup parent) {
		/**
		 * Custom your item here
		 */
		return null;
	}

}

