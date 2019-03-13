package com.adapter;

import java.util.List;

import com.entity.Notelist;
import com.example.fragmentactivity.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NoteAdapter extends BaseAdapter {

	private Context context;// 上下文
	private List<Notelist> list;// 数据
	Noteclass noteview=new Noteclass();
	
	public NoteAdapter(Context context, List<Notelist> list) {
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

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		// 1.找布局 item.xml
		if (convertView ==null){
			// 加载上下文
			LayoutInflater inflater = LayoutInflater.from(context); 
			// 加载子布局item
			convertView = inflater.inflate(R.layout.list_main, null);
			
			//2.加载组件
			
			noteview.title=(TextView) convertView.findViewById(R.id.list_title);
			noteview.content=(TextView) convertView.findViewById(R.id.list_content);
			noteview.date=(TextView) convertView.findViewById(R.id.list_date);
			noteview.username=(TextView) convertView.findViewById(R.id.list_author);
			
			//将组件组加入到View
			convertView.setTag(noteview);
		}
		else{
			convertView.getTag();
		}
		//3.给组件赋值
		noteview.title.setText(list.get(position).getNotename());
		noteview.content.setText(list.get(position).getNotecontent());
		noteview.date.setText((CharSequence) list.get(position).getPublishedtime());
		noteview.username.setText(list.get(position).getUsername());
		//4.返回View
		return convertView;
	}
}

class Noteclass {
	TextView title, content,username,date;
}