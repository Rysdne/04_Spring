package com.example.demo;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

@SpringBootApplication
public class JavaemailApplication implements CommandLineRunner {

	@Autowired
	JavaMailSender mail;

	public static void main(String[] args) {
		SpringApplication.run(JavaemailApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		final MimeMessagePreparator p = new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {

				final MimeMessageHelper message= new MimeMessageHelper(mimeMessage, "UTF-8");
				message.setTo("");
				message.setSubject("");
				
				
			}
		};
	}
}