package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.mybatis.MemberService;

@SpringBootApplication
public class MybatisApplication {

	public class Main {
		public static void main(String[] args) {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("com/example/demo/mybatis/config.xml");
			MemberService service = (MemberService) ctx.getBean("memberservice", com.example.demo.mybatis.MemberServiceImpl.class);
			// service.insert("aaaa1","1111");
			System.out.println(service.select("aaaa1"));
		}
	}
}
