package com.activity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.adapter.ArticleAdapter;
import com.adapter.CommentAdapter;
import com.entity.Articlelist;
import com.entity.Commentlist;
import com.example.fragmentactivity.R;
import com.example.net.HttpTask;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Single extends Activity {
	
	private TextView author,title,content,date;
	private ListView listview;
	private EditText comment_et;
	private Button commen_btn;
	
	private CommentAdapter commentAdapter;
	
	private Articlelist article;
	
	private List<Commentlist> listvalue;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_single);
		
		//声明组件
		author=(TextView) findViewById(R.id.list_author);
		title=(TextView) findViewById(R.id.list_title);
		content=(TextView) findViewById(R.id.list_content);
		date=(TextView) findViewById(R.id.list_date);
		
		comment_et=(EditText) findViewById(R.id.comment_et);
		commen_btn=(Button) findViewById(R.id.commen_btn);
		
		listview=(ListView) findViewById(R.id.listview);
		//从intent中获取Article传过来的值
		
		article=new Articlelist();
		Intent intent=getIntent();
		listvalue=(List<Commentlist>) getIntent().getSerializableExtra("commentlist");
		
		article=(Articlelist) getIntent().getSerializableExtra("article");
		
		
		//自定义适配器赋值
		commentAdapter=new CommentAdapter(Single.this, listvalue);
		
		commentAdapter.notifyDataSetChanged();
		// 3.组件赋值
		author.setText(article.getUsername());
		title.setText(article.getArticlename());
		content.setText(article.getArticlecontent());
		date.setText(article.getPublishedtime());
		
		listview.setAdapter(commentAdapter);
		
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.single, menu);
		return true;
	}

}
