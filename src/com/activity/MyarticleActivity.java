package com.activity;

import java.util.List;

import com.adapter.ArticleAdapter;
import com.entity.Articlelist;
import com.example.fragmentactivity.R;
import com.example.fragmentactivity.R.id;
import com.example.fragmentactivity.R.layout;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

public class MyarticleActivity extends Activity {
	private ListView listv;
	private ArticleAdapter articleAdapter;

	private List<Articlelist> listvalue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_myarticle);

		// 2.找组件
		TextView tv = (TextView) findViewById(R.id.content_tv);

		listv = (ListView) findViewById(R.id.listview);
		
		//通过intent将listvalue的值传过来
		Intent intent=getIntent();
		
		listvalue=(List<Articlelist>) getIntent().getSerializableExtra("articlelist");
		
		articleAdapter = new ArticleAdapter(MyarticleActivity.this, listvalue);
		
		articleAdapter.notifyDataSetChanged();
		// 3.组件赋值
		listv.setAdapter(articleAdapter);
	}

}
