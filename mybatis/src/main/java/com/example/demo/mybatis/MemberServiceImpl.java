package com.example.demo.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberservice")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper mapper;

	@Override
	public void insert(String id, String password) {
		System.out.println(mapper.insert(id, password) == 1 ? "성공" : "실패");
	}

	@Override
	public String select(String id) {
		return mapper.select(id);
	}

	@Override
	public List<Member> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public boolean update(Member member) {
		// TODO Auto-generated method stub
		return mapper.update(member) == 1 ? true : false;
	}

	@Override
	public boolean delete(String id) {
		return mapper.delete(id) == 1 ? true : false;
	}

}
