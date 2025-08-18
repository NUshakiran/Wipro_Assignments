package com.example.course_service.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course_service.dto.ClassroomDTO;
import com.example.course_service.feign.ClassroomClient;
import com.example.course_service.model.Course;
import com.example.course_service.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
    private CourseRepository courseRepository;
	@Autowired
	private ClassroomClient classroomClient;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

   /* public Course createCourse(Course course) {
        return courseRepository.save(course);
    }*/

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course updateSyllabus(Long id, String syllabus) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        course.setSyllabus(syllabus);
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
    
    
    public Course createCourse(Course course) {
        Course saved = courseRepository.save(course);

        ClassroomDTO dto = new ClassroomDTO();
        dto.setCourseId(saved.getId());
        dto.setTopic("Intro to " + saved.getTitle());
        dto.setScheduleTime(LocalDateTime.now().plusDays(1));

        classroomClient.createClassroom(dto);

        return saved;
    }
}
