package com.spring.korea.service;

import java.util.List;

import com.spring.korea.dto.MemberDTO;

public interface MainService {
	
	public String purchase(String id, int point);
	
	public String plusPoint(String id);
	
	public String login(MemberDTO member);
	
	public String signUp(MemberDTO member);
	
	public MemberDTO getMember(String id);
	
	public List<MemberDTO> getMemberList();

}
