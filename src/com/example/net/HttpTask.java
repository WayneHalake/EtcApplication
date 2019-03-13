package com.example.net;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class HttpTask extends AsyncTask<String, Void, Void>{
	private String response;//接受响应的字符串
	private HttpCallBack callBack;//回调接口 
	private HttpHelper httphelper;//请求和响应的封装对象
	private ProgressDialog dialog = null;//进度条对话框 显示加载
	
	public HttpTask(Context context){
		super();
		httphelper=new HttpHelper();
		dialog=ProgressDialog.show(context, "提示", "正在加载后台数据", true, true);
	}
  
	 public void setCallback(HttpCallBack callBack){
		 
		 this.callBack=callBack;
	 }
	 /**
	  * 耗时操作 访问网络数据
	  * ... 传入0-N个参数
	  */
	@Override
	protected Void doInBackground(String... params) {
		// TODO Auto-generated method stub
		if(params.length>1){
			//带参数
			response = httphelper.postPage(params[0],params[1]);
		}else {
			//不带参数
			response= httphelper.postPage(params[0], null);
		}
		
		return null;
	}

	 @Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		
		//取到数据，对话框消失
		dialog.dismiss();
		
		if(callBack!=null){
			callBack.callBack(response);
		}
	}
}
