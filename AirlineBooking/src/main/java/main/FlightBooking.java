package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.TicketService;

public class FlightBooking {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        TicketService ticketService = (TicketService) context.getBean("ticketService");
        
        System.out.println(ticketService.confirmBooking("FL123", "USER456")); 
        System.out.println(ticketService.confirmBooking("FL123", "USER789"));
        System.out.println(ticketService.confirmBooking("FL123", "USER999")); 
        System.out.println(ticketService.confirmBooking("FL456", "USER888"));

	}

}
