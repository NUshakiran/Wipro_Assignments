package com.example.movietickets_booking_app_rest_api.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movietickets_booking_app_rest_api.model.Theater;
import com.example.movietickets_booking_app_rest_api.repository.TheaterRepository;

@Service
public class TheaterService {
	
	@Autowired
	TheaterRepository theaterRepository;
	
	public List<Theater> getAllMovies(){
		return theaterRepository.findAll();
	}
	
	public Theater getById(Long id) {
		return theaterRepository.findById(id).get();
	}
	
	public Theater saveTheater(Theater theater) {
		return theaterRepository.save(theater);
	}
	
	public void deleteTheater(Long id) {
		theaterRepository.deleteById(id);
	}

}

