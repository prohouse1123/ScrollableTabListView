package com.example.scrollabletablistviewexample;

public class ItemData{
	
	private String title;
	private String date;
	private String url;
	
	public ItemData(String title, String date, String url) {
		this.title = title;
		this.date = date;
		this.url = url;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getUrl(){
		return url;
	}
}
