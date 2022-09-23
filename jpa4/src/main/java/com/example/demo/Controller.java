package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class Controller {

	@Autowired
	MemberService service;

	// findAll
	// curl -v -X GET "http://localhost:8080/members"
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

//	// curl "http://localhost:8080/members/page/1"
//	// test code
//	@GetMapping(value = "/page/{page}")
//	public String member(@PathVariable int page) {
//		System.out.println(page);
//		return "page";
//	}

	// curl "http://localhost:8080/members/page/1"
	// curl -v -X GET "http://localhost:8080/members/page/1"
	@GetMapping(value = "/page/{p}")
	public Page<MemberEntity> memberPage(@PathVariable int p) {
		//Pageable pageable = Pageable.ofSize(page);
		Pageable pageable = PageRequest.of(p, 5);
		
		Page<MemberEntity> page = service.findAll(pageable);
		
		System.out.println(page.toList());
		return page;
		//return service.memberPage(page);
	}

//	// curl "http://localhost:8080/members/requestpage?page=1&size=10"
//	@GetMapping(value = "/requestpage")
//	public List<MemberEntity> memberPage(@RequestParam int page) {
//		Pageable pageable = PageRequest.of(page, 5);
//		
//		List<MemberEntity> list = service.findAll(pageable);
//		
//		return list;
//		//return service.memberPage(page);
//	}

//	// insert 1
//	@PostMapping
//	public MemberEntity postMember(MemberEntity member) {
//		MemberEntity m=new MemberEntity();
//		m.setId(member.getId());
//		m.setPassword(member.getPassword());
//		return service.save(m);
//	}

//	// insert 2
//	// curl "http://localhost:8080/members" -v -X POST -H "Content-Type: application/json" -d "{\"id\":\"test4\",\"password\":\"1234\"}"
//	@PostMapping
//	public String postMember(@RequestBody MemberEntity member) {
//		System.out.println(member.toString());
//		return "test";
//	}

	// insert 3
	// curl "http://localhost:8080/members" -v -X POST -H "Content-Type: application/json" -d "{\"id\":\"test4\",\"password\":\"1234\"}"
	@PostMapping
	public ResponseEntity<MemberEntity> postMember(@RequestBody MemberEntity member) {
		System.out.println(member.toString());
		return new ResponseEntity<MemberEntity> (service.save(member),HttpStatus.OK); 
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
