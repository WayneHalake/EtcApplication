package com.activity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.json.JSONObject;

import com.entity.Users;
import com.example.fragmentactivity.R;
import com.example.fragmentactivity.R.id;
import com.example.fragmentactivity.R.layout;
import com.example.net.HttpCallBack;
import com.example.net.HttpTask;
import com.utils.Util;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateActivity extends Activity implements HttpCallBack {

	SimpleDateFormat fmtDate = new java.text.SimpleDateFormat("yyyy-MM-dd");

	public static UpdateActivity insistent;

	TextView entrDate = null;
	TextView gradDate = null;

	Calendar date1 = Calendar.getInstance(Locale.CHINA);
	Calendar date2 = Calendar.getInstance(Locale.CHINA);

	EditText UserName, Name, Pwd, Spwd;
	RadioGroup sex, custype;
	RadioButton male, female, teacher, student;
	Button save;
	String Gender = "female", Type = "teacher";

	Users user = new Users();

	DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// 修改日历控件的年，月，日
			// 这里的year,monthOfYear,dayOfMonth的值与DatePickerDialog控件设置的最新值一致
			date1.set(Calendar.YEAR, year);
			date1.set(Calendar.MONTH, monthOfYear);
			date1.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			// 将页面TextView的显示更新为最新时间
			upDateDate1();
		}
	};

	DatePickerDialog.OnDateSetListener t = new DatePickerDialog.OnDateSetListener() {
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// 修改日历控件的年，月，日
			// 这里的year,monthOfYear,dayOfMonth的值与DatePickerDialog控件设置的最新值一致
			date2.set(Calendar.YEAR, year);
			date2.set(Calendar.MONTH, monthOfYear);
			date2.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			// 将页面TextView的显示更新为最新时间
			upDateDate2();
		}
	};

	private void upDateDate1() {
		entrDate.setText(fmtDate.format(date1.getTime()));
	}

	private void upDateDate2() {
		gradDate.setText(fmtDate.format(date2.getTime()));
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update);

		insistent = this;

		UserName = (EditText) findViewById(R.id.register_username_et);
		Name = (EditText) findViewById(R.id.register_name_et);
		Pwd = (EditText) findViewById(R.id.register_pwd_et);
		Spwd = (EditText) findViewById(R.id.register_spwd_et);

		sex = (RadioGroup) findViewById(R.id.rg_sex);
		custype = (RadioGroup) findViewById(R.id.rg_custype);

		male = (RadioButton) findViewById(R.id.rb_male);
		female = (RadioButton) findViewById(R.id.rb_female);
		teacher = (RadioButton) findViewById(R.id.rb_teacher);
		student = (RadioButton) findViewById(R.id.rb_student);

		entrDate = (TextView) findViewById(R.id.entr_showdate);
		entrDate.setClickable(true);
		entrDate.setFocusable(false);
		gradDate = (TextView) findViewById(R.id.grad_showdate);
		gradDate.setClickable(true);
		gradDate.setFocusable(false);

		Intent intent = getIntent();
		
		user = (Users) intent.getSerializableExtra("user");

		UserName.setText(user.getUsername());
		Name.setText(user.getName());
		entrDate.setText(user.getIntake());
		gradDate.setText(user.getOuttake());

		save = (Button) findViewById(R.id.but_save);

		sex.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				if (arg1 == male.getId()) {
					Gender = "male";
				} else {
					Gender = "female";
				}
			}
		});

		custype.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				if (arg1 == teacher.getId()) {
					Type = "teacher";

				} else {
					Type = "student";

				}
				Log.d("userName", Type);
			}
		});

		save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (Pwd.getText().toString().equals(Spwd.getText().toString())) {

					String action = "update";

					Map<String, String> map = new HashMap<String, String>();
					map.put("action", action);
					map.put("userid", user.getUserid());
					map.put("userName", UserName.getText().toString());
					map.put("Pwd", Pwd.getText().toString());
					map.put("Name", Name.getText().toString());
					map.put("userType", Type);
					map.put("intake", entrDate.getText().toString());
					map.put("outtake", gradDate.getText().toString());
					map.put("gender", Gender);

					Log.d("map", map + "");

					String data = Util.getPair(map);
					Log.d("data", data);
					HttpTask task = new HttpTask(UpdateActivity.this);
					task.setCallback(UpdateActivity.this);

					task.execute(Util.URL + Util.user, data);

				} else {
					Toast.makeText(UpdateActivity.this, "两次密码输入不一样！", 1);
				}
			}
		});

		entrDate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				DatePickerDialog dateDlg1 = new DatePickerDialog(
						UpdateActivity.this, d, date1.get(Calendar.YEAR),
						date1.get(Calendar.MONTH), date1
								.get(Calendar.DAY_OF_MONTH));

				dateDlg1.show();
			}
		});

		gradDate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				DatePickerDialog dateDlg2 = new DatePickerDialog(
						UpdateActivity.this, t, date2.get(Calendar.YEAR),
						date2.get(Calendar.MONTH), date2
								.get(Calendar.DAY_OF_MONTH));

				dateDlg2.show();

			}
		});

	}

	@Override
	public void callBack(String str) {
		// TODO Auto-generated method stub
		if (str != null) {
			try {

				JSONObject json = new JSONObject(str);
				boolean flag = json.getBoolean("flag");
				Log.d("xie", flag + "");
				String username = json.getString("username");
				String userid=json.getString("userid");
				if (flag) {
					// 跳转到MainActivity
					Intent intent = new Intent(UpdateActivity.this,
							MainActivity.class);
					// 利用intent传值
					intent.putExtra("username", username);
					intent.putExtra("userid", Integer.parseInt(userid));
					startActivity(intent);
					UpdateActivity.this.finish();
				} else {

					Toast.makeText(UpdateActivity.this, "更新失败！！！", 1).show();
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
