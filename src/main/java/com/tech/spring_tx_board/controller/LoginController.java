package com.tech.spring_tx_board.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.spring_tx_board.util.Constant;



	@Controller
	public class LoginController {
	
		public JdbcTemplate template;
		
		public void setTemplate(JdbcTemplate template) {
			this.template = template;
			Constant.template=this.template;
		}
		@Autowired
		private SqlSession sqlSession;


		@RequestMapping("/login")
		public String login() {		
			System.out.println("pass by login()");
			
return "login/loginForm";
		
		}
		@RequestMapping("/loginProc")
		public String loginProc(HttpServletRequest requset, Model model) {
			System.out.println("pass by loginProc()");
			String uid=requset.getParameter("id");
			
			//일치처리
		requset.getSession().setAttribute("uid", uid);
			
return "redirect:list";
		
		}
		@RequestMapping("/loginoutProc")
		public String loginoutProc(HttpServletRequest requset, Model model) {
			System.out.println("pass by loginoutProc()");
		
			
			//일치처리
		requset.getSession().invalidate();
			
return "redirect:list";
	}
	}


