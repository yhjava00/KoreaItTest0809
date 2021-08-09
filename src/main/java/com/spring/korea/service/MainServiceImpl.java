package com.spring.korea.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.korea.dao.MainDAO;
import com.spring.korea.dto.MemberDTO;

@Service("mainService")
public class MainServiceImpl implements MainService {

	@Autowired
	MainDAO mainDAO;
	
	@Override
	public String purchase(String id, int point) {
		
		Map<String, Object> info = new HashMap<String, Object>();
		info.put("id", id);
		info.put("point", point);
		
		mainDAO.updatePointMinus(info);
		
		return "success";
	}
	
	@Override
	public String plusPoint(String id) {
		mainDAO.updatePointPlus(id);
		return "success";
	}
	
	@Override
	public String login(MemberDTO member) {
		
		MemberDTO compareMember = mainDAO.selectMember(member.getId());
		
		if(compareMember==null||!compareMember.getPw().equals(member.getPw())) {
			return "fail";
		}
		
		if(member.getId().equals("admin")) {
			return "admin";
		}
		
		return "success";
	}
	
	@Override
	public String signUp(MemberDTO member) {
		
		mainDAO.insertMember(member);
		
		return "success";
	}
	
	@Override
	public MemberDTO getMember(String id) {
		return mainDAO.selectMember(id);
	}
	
	@Override
	public List<MemberDTO> getMemberList() {
		return mainDAO.selectMemberList();
	}
	
}
