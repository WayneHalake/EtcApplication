package com.dao;

import com.adapter.ArticleAdapter;
import com.adapter.NoteAdapter;

public interface Show{
	
	/**
	 * 显示所有文章
	 * @return ArticleAdapter
	 */
	public ArticleAdapter showAllArticle();
	
	/**
	 * 显示所有帖子
	 * @return NoteAdapter
	 */
	public NoteAdapter showAllNote();
		
}
