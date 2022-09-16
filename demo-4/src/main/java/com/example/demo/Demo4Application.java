package com.example.demo;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@SpringBootApplication
public class Demo4Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo4Application.class, args);
	}

	@RequestMapping("/stringjson")
	@ResponseBody
	public String json1() {
		return "{'key':'java'}";
		// return "{\"key\":\"java\"}";
	}

	@RequestMapping("/objectjson")
	@ResponseBody
	public ExamObject json2() {
		ExamObject obj=new ExamObject("jsp");
		return obj;
	}

	@RequestMapping("/fileformProc")
	@ResponseBody
	public String fileRecv(String key, MultipartFile file) throws IllegalStateException, IOException {
		
		String savedir="C:\\Users\\Rysdne\\Desktop\\Rysdne\\Document\\04. Spring\\work\\demo-4\\src\\main\\resources\\static\\file";
		if(!file.isEmpty()) {
			// 전달받은 파일의 이름을 가져옴
			String filename=file.getOriginalFilename();
			String fullpath=savedir + "\\" + filename;
			file.transferTo(new File(fullpath));
			
		}
		
		return file.toString(); 
	}
	
	@RequestMapping("/fileformjson")
	@ResponseBody
	public String fileformjson(@RequestPart("obj") String obj, @RequestPart("file1") MultipartFile file1) throws IllegalStateException, IOException {
		// @RequestPart : 요청하는 부분의 파트가 어느 부분인지 알려줌
		// 결국 변수명이 같을 필요가 없음
		
		String savedir="C:\\Users\\Rysdne\\Desktop\\Rysdne\\Document\\04. Spring\\work\\demo-4\\src\\main\\resources\\static\\file";
		if(!file1.isEmpty()) {
			// 전달받은 파일의 이름을 가져옴
			String filename=file1.getOriginalFilename();
			String fullpath=savedir + "\\" + filename;
			file1.transferTo(new File(fullpath));
			
		}
		
		return file1.toString(); 
	}
	
}
