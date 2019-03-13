package com.example.fragmentactivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.activity.MainActivity;
import com.activity.MyarticleActivity;
import com.activity.MynoteActivity;
import com.activity.UpdateActivity;
import com.adapter.ArticleAdapter;
import com.entity.Articlelist;
import com.entity.Notelist;
import com.entity.Users;
import com.example.net.HttpCallBack;
import com.example.net.HttpTask;
import com.utils.Util;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

import android.view.ViewGroup;
import android.widget.Button;

public class ContentSet extends Fragment implements OnClickListener,
		HttpCallBack {

	private Button personal, myarticle, mynote, exit;
	Map<String, String> map = new HashMap<String, String>();
	HttpTask task;
	String data = null;

	int userid = MainActivity.userid;

	String username = MainActivity.name;

	int contentsetResultcode = 7;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View viewcontent = inflater.inflate(R.layout.content_set, null);

		personal = (Button) viewcontent.findViewById(R.id.personal);
		myarticle = (Button) viewcontent.findViewById(R.id.myarticle);
		mynote = (Button) viewcontent.findViewById(R.id.mynote);
		exit = (Button) viewcontent.findViewById(R.id.exit);

		personal.setOnClickListener(this);
		myarticle.setOnClickListener(this);
		mynote.setOnClickListener(this);
		exit.setOnClickListener(this);

		return viewcontent;
	}
	//callBack函数，接收后台过来的数据
	@Override
	public void callBack(String str) {
		// TODO Auto-generated method stub

		String index = str.substring(0, str.indexOf("?"));
		//Log.d("xie", "..." + index);
		str = str.substring(str.indexOf("?") + 1);
		
		if (index.equals(Util.Users)) {
			//从后台响应回来的用户信息
			showuser(str);
		}else if(index.equals(Util.MyArticlelist)){
			//从后台响应回来的文章信息
			showmyarticle(str);
		}else if(index.equals(Util.MyNotelist)){
			//从后台响应回来的帖子信息
			showmynote(str);
		}

	}
	
	//展示我的文章信息
	public void showmyarticle(String str){
		
		List<Articlelist> articlelist = new ArrayList<Articlelist>();
		try {

			JSONArray array = new JSONArray(str);
			for (int i = 0; i < array.length(); i++) {

				JSONObject obj = array.getJSONObject(i);

				Articlelist list = new Articlelist();

				list.setArticlename(obj.getString("articlename"));
				Log.d("articlename",obj.getString("articlename"));
				
				list.setArticleid(obj.getInt("articleid"));
				Log.d("articleid",obj.getInt("articleid")+"");
				
				list.setArticlecontent(obj.getString("articlecontent"));
				Log.d("articlecontent",obj.getString("articlecontent"));
				
				list.setPublishedtime(obj.getString("publishedtime"));
				Log.d("publishedtime",obj.getString("publishedtime"));
				
				list.setUserid(obj.getInt("userid"));
				Log.d("userid",obj.getInt("userid")+"");
				
				list.setUsername(obj.getString("username"));
				Log.d("username",obj.getString("username"));

				articlelist.add(list);
			}
			//通过intent将articlelist传到MyarticleActivity中
			Intent intent=new Intent(getActivity(),MyarticleActivity.class);
			Bundle bundle=new Bundle();
			
			bundle.putSerializable("articlelist", (Serializable) articlelist);
			intent.putExtras(bundle);

			startActivity(intent);

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}
		
	}
	
	//展示用户信息
 	public void showuser(String str){
		Users user = new Users();
		try {
			JSONObject obj = new JSONObject(str);

			String userid = obj.getString("userid");
			String username = obj.getString("username");
			String name = obj.getString("name");
			String gender = obj.getString("gender");
			String type = obj.getString("type");
			String intake = obj.getString("intake");
			String outtake = obj.getString("outtake");

			user.setUserid(userid);
			user.setUsername(username);
			user.setName(name);
			user.setType(type);
			user.setGender(gender);
			user.setOuttake(outtake);
			user.setIntake(intake);

			// 利用intent传递对象
			Intent intent = new Intent(getActivity(), UpdateActivity.class);
			Bundle bundle = new Bundle();

			bundle.putSerializable("user", user);
			intent.putExtras(bundle);

			startActivity(intent);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

 	//展示我的帖子信息
 	public void showmynote(String str){
 		
 		List<Notelist> notelist = new ArrayList<Notelist>();
		try {

			JSONArray array = new JSONArray(str);
			for (int i = 0; i < array.length(); i++) {

				JSONObject obj = array.getJSONObject(i);

				Notelist list = new Notelist();

				list.setNotename(obj.getString("notename"));
				Log.d("notename",obj.getString("notename"));
				
				list.setNoteid(obj.getInt("noteid"));
				Log.d("noteid",obj.getInt("noteid")+"");
				
				list.setNotecontent(obj.getString("notecontent"));
				Log.d("notecontent",obj.getString("notecontent"));
				
				list.setPublishedtime(obj.getString("publishedtime"));
				Log.d("publishedtime",obj.getString("publishedtime"));
				
				list.setUserid(obj.getInt("userid"));
				Log.d("userid",obj.getInt("userid")+"");
				
				list.setUsername(obj.getString("username"));
				Log.d("username",obj.getString("username"));

				notelist.add(list);
			}
			//通过intent将articlelist传到MyarticleActivity中
			Intent intent=new Intent(getActivity(),MynoteActivity.class);
			Bundle bundle=new Bundle();
			
			bundle.putSerializable("notelist", (Serializable) notelist);
			intent.putExtras(bundle);

			startActivity(intent);

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}
 	}	
 	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.personal:
			// 个人中心
			// 将前台数据加入HashMap，以键值对是形式传送到后台
			map.put("action", "showusermessage");
			map.put("userid", userid + "");
			map.put("username", username);

			data = Util.getPair(map);

			task = new HttpTask(getActivity());

			task.setCallback(ContentSet.this);

			task.execute(Util.URL + Util.user, data);
			Log.d("xie", "data:" + data);

			break;
		case R.id.myarticle:
			// 我的文章
			map.put("action", "showmyarticle");
			map.put("userid", userid + "");

			data = Util.getPair(map);

			task = new HttpTask(getActivity());

			task.setCallback(ContentSet.this);

			task.execute(Util.URL + Util.user, data);

			Log.d("xie", "data:" + data);

			break;
		case R.id.mynote:
			// 我的帖子

			map.put("action", "showmynote");
			map.put("userid", userid + "");

			data = Util.getPair(map);

			task = new HttpTask(getActivity());

			task.setCallback(ContentSet.this);

			task.execute(Util.URL + Util.user, data);

			Log.d("xie", "data:" + data);

			break;
		case R.id.exit:
			// 退出
			Log.d("eixt", "1111111111");
			MainActivity.instance.finish();
			break;
		default:
			break;
		}

	}
}
