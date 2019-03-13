package com.etc.dao;

import java.util.List;

import com.etc.entity.Articles;

public interface ArticleManage {
	
	/**
	 * ��ʾ���е�������Ϣ 
	 * @return List<Articles>
	 */
	public List<Articles> showAll();
	
	/**
	 * ɾ������
	 * ɾ�����µ�ͬʱ��Ҫɾ�������µ�������Ϣ
	 * @param articleid  ����id
	 *
	 */
	public void delete(int articleid);
	
	
	/**
	 *�鿴һƪ���µ����� 
	 * @param articleid ����id
	 * @return Articles
	 */
	public Articles showArticle(int articleid);
}
