package com.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.activity.Single;
import com.entity.Articlelist;
import com.example.fragmentactivity.ArticleContent;
import com.example.fragmentactivity.R;
import com.example.net.HttpTask;
import com.utils.Util;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ArticleAdapter extends BaseAdapter {
	private Context context;// 上下文
	private List<Articlelist> list;// 数据
	Articleclass articleview=new Articleclass();
	
	Map<String, String> map = new HashMap<String, String>();
	HttpTask task;
	String data = null;
	
	public ArticleAdapter(Context context, List<Articlelist> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	int p;
	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		 p=position;
		// 1.找布局 item.xml
		if (convertView ==null){
			// 加载上下文
			LayoutInflater inflater = LayoutInflater.from(context); 
			// 加载子布局item
			convertView = inflater.inflate(R.layout.list_main, null);
			
			//2.加载组件
			
			articleview.title=(TextView) convertView.findViewById(R.id.list_title);
			articleview.content=(TextView) convertView.findViewById(R.id.list_content);
			articleview.date=(TextView) convertView.findViewById(R.id.list_date);
			articleview.username=(TextView) convertView.findViewById(R.id.list_author);
			
			articleview.title.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Articlelist article = list.get(p);
					map.put("type", "article");
					map.put("id",article.getArticleid()+"");
					
					Log.d("position",""+p);
					
					data = Util.getPair(map);

				//	task = new HttpTask();

				//  task.setCallback(ArticleContent.this);

				//	task.execute(Util.URL + Util.comment, data);
					
					Log.d("xie", "data:" + data);
					Log.d("adapter","点击了title"+p);
				}
			});
			
			//将组件组加入到View
			convertView.setTag(articleview);
		}
		else{
			convertView.getTag();
		}
		//3.给组件赋值
		articleview.title.setText(list.get(position).getArticlename());
		articleview.content.setText(list.get(position).getArticlecontent());
		articleview.date.setText((CharSequence) list.get(position).getPublishedtime());
		articleview.username.setText(list.get(position).getUsername());
		//4.返回View
		return convertView;
	}
}

class Articleclass {
	TextView title, content,username,date;
}