package com.example.movietickets_booking_app_rest_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movietickets_booking_app_rest_api.model.Theater;
import com.example.movietickets_booking_app_rest_api.service.TheaterService;


@RestController
@RequestMapping("/api")
public class TheaterController {
	
	@Autowired
	TheaterService theaterService;

	@GetMapping("/theaters")
	public List<Theater> getAllTheaters(){
		return theaterService.getAllMovies();		
		
	}
	
	@PostMapping("theaters")
	public Theater createTheater(@RequestBody Theater theater) {
		return theaterService.saveTheater(theater);
	}
	
	
	@GetMapping("/theaters/{id}")
	public ResponseEntity<Theater> getTheaterById(@PathVariable Long id) {
		Theater theater = theaterService.getById(id);
		return  new ResponseEntity<Theater>(theater,HttpStatus.OK) ;
	}
	
	@PutMapping("/theaters/{id}")
	public Theater updateTheater(@RequestBody Theater theater,@PathVariable Long id) {
		Theater existingTheater = theaterService.getById(id);
		existingTheater.setLocation(theater.getLocation());
		existingTheater.setName(theater.getName());
		
		Theater result = theaterService.saveTheater(existingTheater);
		return result;
	}
 	
	@DeleteMapping("/theaters/{id}")
	public String deleteTheater(@PathVariable Long id) {
		theaterService.deleteTheater(id);
		return "Theater deleted with this "+id;
	}
	

}
