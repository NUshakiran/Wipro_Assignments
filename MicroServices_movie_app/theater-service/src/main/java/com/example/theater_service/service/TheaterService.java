package com.example.theater_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.theater_service.model.Theater;
import com.example.theater_service.repository.TheaterRepository;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    
    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    
    public Theater getTheaterById(Long id) {
        return theaterRepository.findById(id).orElse(null);
    }

    
    public Theater createTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

  
    public Theater updateTheater(Long id, Theater updated) {
        Theater theater = theaterRepository.findById(id).orElse(null);
        if (theater != null) {
            theater.setName(updated.getName());
            theater.setLocation(updated.getLocation());
            return theaterRepository.save(theater);
        }
        return null;
    }

    
    public void deleteTheater(Long id) {
        theaterRepository.deleteById(id);
    }
}
