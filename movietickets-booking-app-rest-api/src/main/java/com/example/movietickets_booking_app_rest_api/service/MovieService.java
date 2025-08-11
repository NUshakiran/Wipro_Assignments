package com.example.movietickets_booking_app_rest_api.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movietickets_booking_app_rest_api.model.Movie;
import com.example.movietickets_booking_app_rest_api.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepository;
	
	public List<Movie> getAllMovies(){
		return movieRepository.findAll();
	}
	
	public Movie getMovieById(Long id) {
		return movieRepository.findById(id).get();
	}
	
	public Movie saveMovie(Movie movie) {
		movieRepository.save(movie);
		return movie;	
	}
	
	public void deleteMovie(Long id) {
		movieRepository.deleteById(id);
	}
	
	
	
	

}
