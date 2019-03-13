package com.activity;

import java.util.List;

import com.adapter.NoteAdapter;
import com.entity.Notelist;
import com.example.fragmentactivity.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.ListView;
import android.widget.TextView;

public class MynoteActivity extends Activity {

	private ListView listv;
	private NoteAdapter noteAdapter;

	private List<Notelist> listvalue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mynote);

		// 2.找组件
		TextView tv = (TextView) findViewById(R.id.content_tv);

		listv = (ListView) findViewById(R.id.listview);
		
		//通过intent将listvalue的值传过来
		Intent intent=getIntent();
		
		listvalue=(List<Notelist>) getIntent().getSerializableExtra("notelist");
		
		noteAdapter = new NoteAdapter(MynoteActivity.this, listvalue);
		
		noteAdapter.notifyDataSetChanged();
		// 3.组件赋值
		listv.setAdapter(noteAdapter);
	}
}
