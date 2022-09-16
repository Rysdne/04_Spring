package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class Controller {

	@Autowired
	MemberService service;

	// findAll
	@GetMapping
	public List<MemberEntity> members() {

		return service.findAll();
	}

	// findById
	@GetMapping(value = "/{idx}")
	// @PathVariable : 전달값을 받아오는 명령어
	public MemberEntity member(@PathVariable long idx) {
		return service.findById(idx);
	}

	// insert
	@PostMapping
	public MemberEntity postMember(MemberEntity member) {
		MemberEntity m=new MemberEntity();
		m.setId(member.getId());
		m.setPassword(member.getPassword());
		return service.save(m);
	}

	// update
	@PutMapping(value = "/{idx}")
	public String putMember() {

		return "update";
	}

	// delete
	@DeleteMapping(value = "/{idx}")
	public void deleteMember(@PathVariable long idx) {
		service.deleteById(idx);
		System.out.println(idx + " 삭제 완료");
	}

}
