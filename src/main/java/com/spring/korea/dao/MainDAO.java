package com.spring.korea.dao;

import java.util.List;
import java.util.Map;

import com.spring.korea.dto.MemberDTO;

public interface MainDAO {
	
	public int updatePointMinus(Map<String, Object> info);
	
	public int updatePointPlus(String id);
	
	public int updateOnePoint();
	
	public int insertMember(MemberDTO member);
	
	public MemberDTO selectMember(String id);
	
	public List<MemberDTO> selectMemberList();

}
