package com.neuedu.user.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.neuedu.comon.MD5.Md5Utils;
import com.neuedu.user.entity.User;
import com.neuedu.user.mapper.UserMapper;

public class Login {

	private static final long serialVersionUID = -5965885617410849125L;

	@Autowired
	private UserMapper usermapper;
	private User user;

	public String findUser() throws ServletException, IOException {

		System.out.println("���ڵ�½������");

		// ����http���Э�� ����������� ������Json��ʽ������
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();

		// ������ص�sessionID
		HttpSession se = request.getSession();
		// ��ȡ��¼����Ϣ
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		
		System.out.println(name + " " + pass);
		

		String data = "1";

		if (name != null && pass != null) {
			// ��ȡ���ݿ���Ϣ
			user = usermapper.getUser(name);
			if (user != null) {
				if (name.equals(user.getUserName())
						&& pass.equals(user.getUserPwd())) {
					user = (User) se.getAttribute("account");
					se.setAttribute("status", Integer.valueOf(1));
					data = "1";

				} else {
					data = "0";
				}
			} else {
				data = "-1";
			}

		} else {
			data = "0";
		}
		// ���������json��ʽ�ͻ�ȥ
		Gson gson = (new GsonBuilder()).create();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(data));
		out.close();

		System.out.println(gson.toJson(data));
		System.out.println(se);
		return null;
	}

	public String cheackUser() throws IOException {

		// ����http���Э�� ����������� ������Json��ʽ������
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();

		// ��ȡ��¼����Ϣ
		String name = request.getParameter("username");
		user = usermapper.getUser(name);
		String data = "1";
		
		if(name!=null){
			user = usermapper.getUser(name);
			if (user != null) {
				data="0";
			}else{
				data="1";
			}
			
		}

		// ���������json��ʽ�ͻ�ȥ
		Gson gson = (new GsonBuilder()).create();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(data));
		out.close();

		System.out.println(gson.toJson(data));

		return null;
	}
	
	public String zhuce() throws IOException {

		// ����http���Э�� ����������� ������Json��ʽ������
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();

		String shuju=request.getParameter("user");
		Gson gson=new Gson();
		User newuser=gson.fromJson(shuju, User.class);
		
		String data = "1";
	
		if(newuser==null){
			data="0";
		}else{
			usermapper.insertUser(newuser);
			data="1";
		}

		// ���������json��ʽ�ͻ�ȥ
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(data));
		out.close();

		return null;
	}
	public  String  findoneuser() throws IOException
	{
		 String data="0";
		System.out.println("���ڲ�ѯ������");
		// ����http���Э�� ����������� ������Json��ʽ������
		       
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpServletResponse response = ServletActionContext.getResponse();
				String name =request.getParameter("userName");
				Gson gson1=new Gson();
				String username=gson1.fromJson(name, String.class);
				System.out.println(username);
				
				// ����
				HttpSession se = request.getSession();
				if(name!=null){
					user = usermapper.getUser(username);
					System.out.println(user);
					if (user != null) {
						data="0";
					}else{
						data="1";
					}
			
				}
				// ���������json��ʽ�ͻ�ȥ
				Gson gson = (new GsonBuilder()).create();
				response.setContentType("application/json; charset=utf-8");
				PrintWriter out = response.getWriter();
				if(user!=null){
					out.print(gson.toJson(user));
					//out.print(gson.toJson(data));
				}
				out.close();
				System.out.println(gson.toJson(user));
				//System.out.println(gson.toJson(data));
				return null;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
