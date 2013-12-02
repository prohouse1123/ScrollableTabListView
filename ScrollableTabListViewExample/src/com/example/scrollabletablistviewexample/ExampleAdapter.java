package com.example.scrollabletablistviewexample;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ExampleAdapter extends ArrayAdapter<ItemData>{
	private int mSection;
	private int mItemLayout;
	private ViewHolder mHolder;

	public ExampleAdapter(Context context, int resource, int section) {
		super(context, resource);
		this.mSection = section;
		mItemLayout = resource;
		mHolder = new ViewHolder();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ItemData data = getItem(position);
		Log.d("debug3", data.getDate()+":"+data.getUrl()+"sec:"+mSection+" pos:"+position);
		View v = convertView;

	      if(v==null){
	        LayoutInflater inflater = 
	          (LayoutInflater)
	            getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        v = inflater.inflate(mItemLayout, null);
	      }
	      
	      mHolder.title =(TextView)v.findViewById(R.id.tv_item_title);
	      mHolder.date =(TextView)v.findViewById(R.id.tv_item_date);
	      mHolder.title.setText(data.getTitle());
	      mHolder.date.setText(data.getDate());
	      v.setTag(mHolder);
		
		return v;
	}
	
	class ViewHolder {
		TextView title;
		TextView date;
	}
	
	
}
