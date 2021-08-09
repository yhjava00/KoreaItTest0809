package com.spring.korea.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.spring.korea.dto.MemberDTO;

public interface MainController {
	
	public String main(HttpServletRequest request, String goods, String plus);
	
	public String purchase(HttpServletRequest request, String goods, int point);
	
	public String plusPoint(HttpServletRequest request);
	
	public String login(HttpServletRequest request, String state);
	
	public String logout(HttpServletRequest request);
	
	public String loginAction(HttpServletRequest request, MemberDTO member);

	public String signUp();
	
	public String signUpAction(HttpServletRequest request, MemberDTO member);
	
	public String adminPage();

}
