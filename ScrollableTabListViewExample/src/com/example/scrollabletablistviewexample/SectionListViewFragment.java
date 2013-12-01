package com.example.scrollabletablistviewexample;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * A dummy fragment representing a section of the app, but that simply
 * displays dummy text.
 */
public class SectionListViewFragment extends Fragment {
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	public static final String ARG_SECTION_NUMBER = "section_number";
	public static final int MAX_LIST_SIZE = 20;
	
	private ListView mListView;
	private ItemData[] mDatas;
	private int mSection;

	public SectionListViewFragment() {
		mDatas = new DummyData().getData();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_listview, container,
				false);
		mListView = (ListView) rootView.findViewById(R.id.listView);
		mListView.setOnItemClickListener(listener);
		
		// get section number
		mSection = getArguments().getInt(ARG_SECTION_NUMBER)-1;

		// set Adapter
		ExampleAdapter adapter = new ExampleAdapter(getActivity(),
				R.layout.listitem, mSection);

		adapter.addAll(getArrayItemData(mSection));
		mListView.setAdapter(adapter);
		
		return rootView;
	}
	
	private ItemData[] getArrayItemData(int section) {
		List<ItemData> list = new ArrayList<ItemData>();
		for (int i = 0; i < MAX_LIST_SIZE; i++) {
			if(section * MAX_LIST_SIZE + i < mDatas.length){
				list.add(mDatas[section * MAX_LIST_SIZE + i]);
			}
		}
		return list.toArray(new ItemData[list.size()]);
	}

	private ItemData getItemData(int position) {
		if(mSection * MAX_LIST_SIZE + position >= mDatas.length ) {
			return null;
		}
		return mDatas[mSection * MAX_LIST_SIZE + position];
	}
	
	private final OnItemClickListener listener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			ItemData data = getItemData(position);
			Uri uri = Uri.parse("http://" + data.getUrl());
			Intent i = new Intent(Intent.ACTION_VIEW, uri);
			startActivity(i);
		}
	};

}
