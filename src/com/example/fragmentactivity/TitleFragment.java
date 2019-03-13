package com.example.fragmentactivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TitleFragment extends Fragment {
	
	public TextView title_tv;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.title, null);

		title_tv=(TextView) view.findViewById(R.id.title_tv);
		
		return view;
	}
}
