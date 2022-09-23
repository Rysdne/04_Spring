package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootApplication
public class Jpa4Application implements CommandLineRunner{

	@Autowired
	MemberRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(Jpa4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		// insert
//		MemberEntity m = new MemberEntity();
//		m.setId("test4");
//		m.setPassword("qwer");
//		repo.save(m);
		
//		// selectById
//		Optional<MemberEntity> member=repo.findById((long)3);
//		System.out.println(member);
		
//		// update
//		MemberEntity m = repo.findById(3);
//		m.setPassword("3333");
//		repo.save(m);

//		// delete
//		repo.deleteById(3);
		
//		// select
//		// List<MemberEntity> list = repo.findAll();
//		repo.findAll().forEach(System.out::println);
		
//		// pageable
//		Pageable pageable = PageRequest.of(0, 5);
//		Page<MemberEntity> page = repo.findAll();
//		System.out.println(page.toList());
		
	}

}
