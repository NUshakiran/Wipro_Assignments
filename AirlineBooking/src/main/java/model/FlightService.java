package model;

import java.util.HashMap;
import java.util.Map;

public class FlightService {
	
	  private Map<String, Integer> flightSeats;
	  
	  
	  public FlightService() {
	        flightSeats = new HashMap<>();
	        flightSeats.put("FL123", 2);
	        flightSeats.put("FL456", 0);
	    }

	
	  
	  

	  public Map<String, Integer> getFlightSeats() {
		  return flightSeats;
	  }

	  public void setFlightSeats(Map<String, Integer> flightSeats) {
		  this.flightSeats = flightSeats;
	  }
	  
	  
	    public boolean bookSeat(String flightNo) {
	        Integer seats = flightSeats.get(flightNo);
	        if (seats != null && seats > 0) {
	            flightSeats.put(flightNo, seats - 1);
	            return true;
	        }
	        return false;
	    }
	  

}
