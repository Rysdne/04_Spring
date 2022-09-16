package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	MemberRepository repo;
	
	public List<MemberEntity> findAll() {
		
		List<MemberEntity> members = new ArrayList();
		// ????
		repo.findAll().forEach(e->members.add(e));
		
		return members; 
	}
	
	public MemberEntity findById(long idx) {
		MemberEntity member = repo.findById(idx);
		return member;
	}

	public void deleteById(long idx) {
		repo.deleteById(idx);
	}

	public MemberEntity save(MemberEntity member) {
		
		return repo.save(member);
	}
	
}
