package com.example.demo;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class HibernateApplication {

	public static void main(String[] args) {
		//SpringApplication.run(HibernateApplication.class, args);
		
		//Configuration configuration = new Configuration();
        //configuration.addResource("hibernate.cfg.xml");
        //configuration.configure();
        
		//1)등록작업 : hibernate.cfg.xml
		StandardServiceRegistry reg=
		new StandardServiceRegistryBuilder().configure("com/example/demo/hibernate.cfg.xml").build();
        //ServiceRegistry reg = 
        //new StandardServiceRegistryBuilder().applySettings(
        //configuration.getProperties()).build();
		
		//2)metadata : 정보의 정보(이 객체는 sessionFactory 정보제공)
		Metadata metadata=new MetadataSources(reg).getMetadataBuilder().build();
		
		SessionFactory sf=metadata.getSessionFactoryBuilder().build();
		
		//3)세션연결작업
		Session session= sf.openSession();
		
		//4)트랜잭션작업
		session.beginTransaction();
		
		//5)sql사용 save, load, update, delete
		MemberEntity m=new MemberEntity();
		m.setId("test");
		m.setPassword("1111");
		session.save(m);
		session.getTransaction().commit();
		
		sf.close();
		
		
		
		
		
		
	}

}
