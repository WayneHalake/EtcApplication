package com.example.fragmentactivity;

import java.util.List;

import com.adapter.NoteAdapter;
import com.entity.Notelist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class NoteContent extends Fragment {
	private ListView listv;
	private NoteAdapter noteAdapter;
	
	private List<Notelist> notelist;
	
	public List<Notelist> getArticlelist() {
		return notelist;
	}

	public void setNotelist(List<Notelist> articlelist) {
		this.notelist = articlelist;
	}
	
	public NoteAdapter getNoteAdapter() {
		return noteAdapter;
	}

	public void setNoteAdapter(NoteAdapter noteAdapter) {
		this.noteAdapter = noteAdapter;
	}


	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// 1.找布局
		View viewcontent = inflater.inflate(R.layout.note_content, null);
		// 2.找组件
		TextView tv = (TextView) viewcontent.findViewById(R.id.content_tv);

		listv = (ListView) viewcontent.findViewById(R.id.listview);

		// 3.组件赋值
		listv.setAdapter(noteAdapter);

		return viewcontent;
	}
}
