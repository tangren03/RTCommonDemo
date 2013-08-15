package com.ryantang.rtcommondemo.slidingmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ryantang.common.R;
/**
 * 滑动菜单
 * @author Ryan
 */
public class MenuFragment extends ListFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		ListView listView = (ListView)inflater.inflate(R.layout.sm_menu_list, null);
		listView.setCacheColorHint(0);
		return listView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		/**
		 * Custom the menu
		 */
		String[] colors = new String[]{"Main","Fragment","Activity"};
		ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(getActivity(), 
				android.R.layout.simple_list_item_1, android.R.id.text1, colors);
		setListAdapter(colorAdapter);
	}

	/**
	 * The click listener for item of the menu
	 */
	@Override
	public void onListItemClick(ListView lv, View v, int position, long id) {

		switch (position) {
		case 0://Main page
			MainPageFragment mainPageFragment = new MainPageFragment();
			switchFragment(mainPageFragment);
			break;
		case 1://Change fragment
			NewFragment newContent = new NewFragment();
			switchFragment(newContent);
			break;
			
		case 2://Start new activity
			Intent intent = new Intent(getActivity(),NewActivity.class);
			getActivity().startActivity(intent);
			break;
		}		
		
	}

	// the meat of switching the above fragment
	private void switchFragment(Fragment fragment) {
		if (getActivity() == null)
			return;
		
		if (getActivity() instanceof MainSlidingMenuActivity) {
			MainSlidingMenuActivity fca = (MainSlidingMenuActivity) getActivity();
			fca.switchContent(fragment);
		} 
	}
}
