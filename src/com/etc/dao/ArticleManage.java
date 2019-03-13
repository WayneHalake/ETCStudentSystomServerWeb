package com.etc.dao;

import java.util.List;

import com.etc.entity.Articles;

public interface ArticleManage {
	
	/**
	 * 显示所有的文章信息 
	 * @return List<Articles>
	 */
	public List<Articles> showAll();
	
	/**
	 * 删除文章
	 * 删除文章的同时需要删除该文章的评论信息
	 * @param articleid  文章id
	 *
	 */
	public void delete(int articleid);
	
	
	/**
	 *查看一篇文章的内容 
	 * @param articleid 文章id
	 * @return Articles
	 */
	public Articles showArticle(int articleid);
}
