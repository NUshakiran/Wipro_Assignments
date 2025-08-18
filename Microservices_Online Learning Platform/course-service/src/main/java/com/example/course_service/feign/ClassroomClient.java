package com.example.course_service.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.course_service.dto.ClassroomDTO;

@FeignClient(name = "classroom-service")
public interface ClassroomClient {
    @PostMapping("/api/classrooms")
    ClassroomDTO createClassroom(@RequestBody ClassroomDTO dto);
}
