package com.example.viewpagerdemo;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

public class FragmentPageAdapter extends FragmentPagerAdapter {
	private Map<Integer, String> mFragmentTags;
    private FragmentManager mFragmentManager;
    
    // constructor method which is used to pass parameters. 
	public FragmentPageAdapter(FragmentManager fm, Context context) {
		super(fm);
		mFragmentManager = fm;
		mFragmentTags = new HashMap<Integer, String>();
		
	}

	
	@Override
	public Fragment getItem(int arg0) {
	
		switch (arg0)
		{
		case 0:
				return new Fragment1();
		case 1: 
				return new Fragment2();
		case 2:
				return new Fragment3();
		default:
				break;
		}
		return null;
	}
	
	// here you have to return the number of fragments. If it is dynamic, return the size of the array or
	//keep a tab of the number of fragments which you can pass to the FragmentPageAdapter. 
	
	@Override
	public int getCount() {
		return 3;
	}
	
	//In this method, we are instantiating the fragment based on position
	@Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object obj = super.instantiateItem(container, position);
        if (obj instanceof Fragment) {
            
            Fragment f = (Fragment) obj;
            
            // record the fragment tag here.
            String tag = f.getTag();
            //save the tag in a hashmap
            mFragmentTags.put(position, tag);
        }
        return obj;
    }
	
	public Fragment getFragment(int position) {
        String tag = mFragmentTags.get(position);
        if (tag == null)
            return null;
        return mFragmentManager.findFragmentByTag(tag);
    }
	

}
