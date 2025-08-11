package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.AppointmentService;

public class HealthCare {
	public static void main(String[] args) {
		
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		 
	     AppointmentService service = (AppointmentService) context.getBean("AppointmentService");
	     
	     String res1 = service.book("DOC101", "2025-04-10");  
	     String res2 = service.book("DOC202", "2025-05-13");
	     
	     System.out.println(res1);
	     System.out.println(res2);
	         
	}

}
