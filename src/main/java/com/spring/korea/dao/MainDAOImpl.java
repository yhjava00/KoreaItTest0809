package com.spring.korea.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.korea.dto.MemberDTO;

@Repository("mainDAO")
public class MainDAOImpl implements MainDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int updatePointMinus(Map<String, Object> info) {
		return sqlSession.update("main.updatePointMinus", info);
	}
	
	@Override
	public int updateOnePoint() {
		return sqlSession.update("main.updateOnePoint");
	}
	
	@Override
	public int updatePointPlus(String id) {
		return sqlSession.update("main.updatePointPlus", id);
	}
	
	@Override
	public int insertMember(MemberDTO member) {
		return sqlSession.insert("main.insertMember", member);
	}
	
	@Override
	public MemberDTO selectMember(String id) {
		return sqlSession.selectOne("main.selectMember", id);
	}
	
	@Override
	public List<MemberDTO> selectMemberList() {
		return sqlSession.selectList("main.selectMemberList");
	}
	
}
