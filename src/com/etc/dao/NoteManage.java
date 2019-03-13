package com.etc.dao;

import java.util.List;

import com.etc.entity.Notes;

public interface NoteManage {
	/**
	 * 显示所有的帖子信息 
	 * @return List<Notes>
	 */
	public List<Notes> showAll();
	
	/**
	 * 删除帖子
	 * 删除帖子的同时需要删除该帖子的评论信息
	 * @param noteid  帖子id
	 *
	 */
	public void delete(int noteid);
	
	
	/**
	 *查看一篇帖子的内容 
	 * @param noteid 帖子id
	 * @return Notes
	 */
	public Notes shownote(int noteid);
}
