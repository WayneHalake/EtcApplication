package com.example.fragmentactivity;

import java.util.ArrayList;
import java.util.List;

import com.adapter.ArticleAdapter;
import com.entity.Articlelist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class IndexContent extends Fragment {
	
	private ListView listv;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//1.找布局
		View viewcontent=inflater.inflate(R.layout.index_content, null);
		//2.找组件
		listv=(ListView) viewcontent.findViewById(R.id.listview);
		
		//3.布局赋值
		//声明一个ListValue来封装信息
		
		Articlelist list=new Articlelist();
		
//		list.setArticlename(aritlename);
//		list.setArticlecontent(artilcecontent);
//		list.setUsername(username);
		//list.setPublishedtime(publishedtime);
		
		//声明一个List集合来存储ListValue的信息
		List<Articlelist> listvalue=new ArrayList<Articlelist>();
		listvalue.add(list);
		
		
		//将list的值加入到自定义适配器Adapter中
		ArticleAdapter articleAdapter=new ArticleAdapter(getActivity(), listvalue);
		
		//将自定义的适配器设置到listview
		listv.setAdapter(articleAdapter);
		
		return viewcontent;
	}
}
