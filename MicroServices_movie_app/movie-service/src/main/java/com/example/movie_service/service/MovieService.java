package com.example.movie_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_service.model.Movie;
import com.example.movie_service.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

  
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

 
    public Movie updateMovie(Long id, Movie updatedMovie) {
        return movieRepository.findById(id).map(movie -> {
            movie.setTitle(updatedMovie.getTitle());
            movie.setGenre(updatedMovie.getGenre());
            return movieRepository.save(movie);
        }).orElse(null);
    }

  
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
