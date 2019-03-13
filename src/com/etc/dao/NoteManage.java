package com.etc.dao;

import java.util.List;

import com.etc.entity.Notes;

public interface NoteManage {
	/**
	 * ��ʾ���е�������Ϣ 
	 * @return List<Notes>
	 */
	public List<Notes> showAll();
	
	/**
	 * ɾ������
	 * ɾ�����ӵ�ͬʱ��Ҫɾ�������ӵ�������Ϣ
	 * @param noteid  ����id
	 *
	 */
	public void delete(int noteid);
	
	
	/**
	 *�鿴һƪ���ӵ����� 
	 * @param noteid ����id
	 * @return Notes
	 */
	public Notes shownote(int noteid);
}
