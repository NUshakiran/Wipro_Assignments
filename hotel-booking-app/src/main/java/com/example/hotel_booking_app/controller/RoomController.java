package com.example.hotel_booking_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel_booking_app.model.Room;
import com.example.hotel_booking_app.service.RoomService;

@RestController
@RequestMapping("/api")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping("/rooms")
    public Room addRoom(@RequestBody Room room) {
        return roomService.saveRoom(room);
    }
}