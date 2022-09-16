package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Jpa3Application implements CommandLineRunner{

	@Autowired
	MemberRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(Jpa3Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		MemberEntity m = new MemberEntity();
		// m.setIdx(2);
		m.setId("test1");
		m.setPassword("1111");
		repo.save(m);
		
		repo.findAll().forEach(System.out::println);
	}

}
