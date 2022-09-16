package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
//@Component
public class Demo3Application {

	@Autowired
	TestVO t;

	public static void main(String[] args) {
		SpringApplication.run(Demo3Application.class, args);
	}
	
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println(t.getTitle());
//	}
	
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

//	@RequestMapping("/helloview")
//	public String helloview() {
//		return "helloview";
//	}

	// @RequestMapping("/helloview")
	@RequestMapping("${url.test}")
	public String helloview() {
		return "helloview";
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

	@GetMapping("/wcome")
	public String welcome(Model model) {
		model.addAttribute("msg", "springboot");
		return "wcome";
	}

}
