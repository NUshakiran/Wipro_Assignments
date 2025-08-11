package model;

public class TicketService {
	
	 private FlightService flightService;

	 public FlightService getFlightService() {
		 return flightService;
	 }

	 public void setFlightService(FlightService flightService) {
		 this.flightService = flightService;
	 }
	 
	 
	 public String confirmBooking(String flightNo, String userId) {
	        if (flightService.bookSeat(flightNo)) {
	            return "Booking confirmed for " + userId + " on " + flightNo;
	        } else {
	            return "Flight " + flightNo + " is full";
	        }
	    }


}
