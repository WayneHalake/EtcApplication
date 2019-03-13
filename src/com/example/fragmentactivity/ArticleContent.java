package com.example.fragmentactivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.activity.MyarticleActivity;
import com.activity.Single;
import com.adapter.ArticleAdapter;
import com.entity.Articlelist;
import com.entity.Commentlist;
import com.example.net.HttpCallBack;
import com.example.net.HttpTask;
import com.utils.Util;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class ArticleContent extends Fragment implements OnItemClickListener,
		HttpCallBack {
	private ListView listv;
	private ArticleAdapter articleAdapter;

	private List<Articlelist> articlelist;

	

	public List<Articlelist> getArticlelist() {
		return articlelist;
	}

	public void setArticlelist(List<Articlelist> articlelist) {
		this.articlelist = articlelist;
	}

	public ArticleAdapter getArticleAdapter() {
		return articleAdapter;
	}

	public void setArticleAdapter(ArticleAdapter articleAdapter) {
		this.articleAdapter = articleAdapter;
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// 1.找布局
		View viewcontent = inflater.inflate(R.layout.article_content, null);
		// 2.找组件
		TextView tv = (TextView) viewcontent.findViewById(R.id.content_tv);

		listv = (ListView) viewcontent.findViewById(R.id.listview);

		// 3.组件赋值
		listv.setAdapter(articleAdapter);
		
		listv.setOnItemClickListener(this);

		return viewcontent;
	}

	int position=0;
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void callBack(String str) {
		// TODO Auto-generated method stub
		//接收来自后台响应的值
		List<Commentlist> commentlist = new ArrayList<Commentlist>();
		try {

			JSONArray array = new JSONArray(str);
			for (int i = 0; i < array.length(); i++) {

				JSONObject obj = array.getJSONObject(i);

				Commentlist list = new Commentlist();

				
				list.setArticleid(obj.getInt("articleid"));
				Log.d("articleid",obj.getInt("articleid")+"");
				
				list.setContent(obj.getString("content"));
				Log.d("content",obj.getString("content"));
				
				list.setCommenttime(obj.getString("commenttime"));
				Log.d("commenttime",obj.getString("commenttime"));
				
				list.setCommentuserid(obj.getInt("commentuserid"));
				Log.d("commentuserid",obj.getInt("commentuserid")+"");
				
				list.setUsername(obj.getString("username"));
				Log.d("username",obj.getString("username"));

				commentlist.add(list);
			}
			//通过intent将articlelist传到MyarticleActivity中
			Intent intent=new Intent(getActivity(),Single.class);
			Bundle bundle=new Bundle();
			
			bundle.putSerializable("commentlist", (Serializable) commentlist);
			
			Articlelist article = articlelist.get(position);
			bundle.putSerializable("article", article);
			
			intent.putExtras(bundle);
			intent.putExtra("type", "article");
			
			startActivity(intent);

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}
		
	}

}
