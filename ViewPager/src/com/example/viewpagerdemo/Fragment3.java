package com.example.viewpagerdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment3 extends Fragment {
		
	View myFragmentView;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{	
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	Bundle savedInstanceState) {
	  
		
		myFragmentView = inflater.inflate(R.layout.fragment3, container, false);
	  
	  
	  return myFragmentView;
	 }
	
	@Override
	public void onResume()
	{

		//The problem with view pager tabs is that the next tabs to the one selected are pre-loaded. So even if 
		//you make any change in the current tab which requires the tab to the left or the right to refresh on load
		//that does not happen automatically.
		//So you have to put in the logic in FragmentPageAdapter that onResume will get called everytime the a new 
		//tab is clicked.
		//in OnResume, you can put your logic to refresh the data as you deem fit. It may be to refresh a listview
		//or to pull data again from Database to populate arrays. 
		
		super.onResume();	
	}
}