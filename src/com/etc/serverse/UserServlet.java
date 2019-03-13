package com.etc.serverse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.dao.UserManage;
import com.etc.dao.impl.UserManageImpl;
import com.etc.entity.Users;

public class UserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getParameter("action");
		String tablename=req.getParameter("tablename");
		
		System.out.println("action:"+action);
		System.out.println("tablename:"+tablename);
		if("login".equals(action)){
			checkLogin(req, resp);
		}
		else if("student".equals(action)){
			//显示所有学员信息
			showAllUsers(req, resp,"student");
		}
		else if("teacher".equals(action)){
			//显示所有教员信息
			showAllUsers(req, resp,"teacher");
		}
		else if("admister".equals(action)){
			//显示所有管理员信息
			showAllUsers(req, resp,"admister");
		}
		else if("update".equals(action)){
			//更新用户信息
			try {
				updateuserMessage(req, resp, tablename);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("finduser".equals(action)){
			//查找用户信息
			findUserMessage(req, resp, tablename);
		}else if("delete".equals(action)){
			//删除用户
			deleteUserMessage(req, resp, tablename);
		}
	}
	//检查登录信息
	public void checkLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName =req.getParameter("userName");
		String userPwd=req.getParameter("userPwd");
		
		UserManage um=new UserManageImpl();
		
		if(um.checkUser(userName, userPwd,"admister")){
			System.out.println("登录成功！！！");
			resp.sendRedirect("index.jsp");	
		}
		else{
			System.out.println("登录失败！！！");
			resp.sendRedirect("login.jsp");	
		}
	}
	
	//展示全部学生的信息
	public void showAllUsers(HttpServletRequest req, HttpServletResponse resp,String tablename) throws ServletException, IOException {
		UserManage um=new UserManageImpl();
		List<Users> users = new ArrayList<Users>();
		users=um.findAllUsers(tablename);
		
		req.setAttribute(tablename, users);
		String jsppage=null;
		if(tablename.equals("student")){
			jsppage="./manageformstu.jsp";
		}
		else if(tablename.equals("teacher")){
			jsppage="./manageformtea.jsp";
		}
		else{
			jsppage="./manageformadm.jsp";
		}
		req.getRequestDispatcher(jsppage).forward(req, resp);
	}
	
	// 添加学生信息
//	public void addStuMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		String sname=req.getParameter("userName");
//		String sage=req.getParameter("userAge");
//		String spwd=req.getParameter("userPwd");
//		String sdetail=req.getParameter("userDetail");
//		
//		StudentManage sm=new UserManageImpl();
//		
//		Users stu= new Users();
//		
//		stu.setSname(sname);
//		stu.setSage(Integer.parseInt(sage));
//		stu.setSpwd(spwd);
//		stu.setSdetail(sdetail);
//		sm.addStudent(stu);
//		
//		showAllStudent(req, resp);
//	}
	//删除学生信息	
	public void deleteUserMessage(HttpServletRequest req, HttpServletResponse resp,String type) throws ServletException, IOException {
		String userid=req.getParameter("userid");
		System.out.println("deleteUserMessage userid="+userid);
		UserManage um=new UserManageImpl();
		um.deleteuserById(Integer.parseInt(userid), type);
		
		showAllUsers(req, resp, type);
	}
	//查询单个学生信息
	public void findUserMessage(HttpServletRequest req, HttpServletResponse resp,String type) throws ServletException, IOException {
		
		String userid=req.getParameter("userid");
		UserManage um=new UserManageImpl();
		
	//	List<Users> list=new ArrayList<Users>();
		System.out.println(userid);
		Users user=um.findUserById(Integer.parseInt(userid),type);
		
		user.setType(type);
		
		//list.add(user);
		
		req.setAttribute("user", user);
		if(type.equals("student")){
			req.getRequestDispatcher("./updateformstu.jsp").forward(req, resp);
		}else if(type.equals("teacher")){
			req.getRequestDispatcher("./updateformtea.jsp").forward(req, resp);
		}else{
			req.getRequestDispatcher("./updateformadm.jsp").forward(req, resp);
		}
	}
	
	//更新学生信息
	public void updateuserMessage(HttpServletRequest req, HttpServletResponse resp,String type) throws ServletException, IOException, ParseException {
		
		String usernum=req.getParameter("usernum");
		String username=req.getParameter("username");
		String gender=req.getParameter("gender");
		String intake=req.getParameter("intake");
		String outtake=req.getParameter("outtake");
		int userid=Integer.parseInt(req.getParameter("userid"));
		
		UserManage um=new UserManageImpl();
		Users user= new Users();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		
		user.setUserid(userid);
		user.setUsername(username);
		user.setUsernum(Integer.parseInt(usernum));
		user.setGender(gender);
		user.setIntake(new java.sql.Date(sdf.parse(intake).getTime()));
		user.setOuttake(new java.sql.Date(sdf.parse(outtake).getTime()));
		um.admupdateuser(user, type);
		
		showAllUsers(req, resp, type);
	}
	
}
