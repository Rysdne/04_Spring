package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@SpringBootApplication
public class Jpa1Application implements CommandLineRunner{

	@Autowired
	NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	MemberRepository jpa;
	// DB를 사용할 수 있는 repository
	
	public static void main(String[] args) {
		SpringApplication.run(Jpa1Application.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {

//		MemberEntity m = new MemberEntity();
//		m.setId("test4");
//		m.setPassword("qwer");
//		jpa.save(m);
		
//		Optional<MemberEntity> m = jpa.findById((long)1);
//		System.out.println(m);
		
//		List<MemberEntity> list = jpa.findAll();
//		System.out.println(list);
		
//		jpa.findAll().forEach(System.out::println);
		
	}

}
