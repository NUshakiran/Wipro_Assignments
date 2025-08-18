package com.example.classroom_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.classroom_service.model.Classroom;
import com.example.classroom_service.repository.ClassroomRepository;

@Service
public class ClassroomService {
	
	@Autowired
	private ClassroomRepository classroomRepository;

    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public Classroom createClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public Classroom getClassroomById(Long id) {
        return classroomRepository.findById(id).orElse(null);
    }

    public List<Classroom> getClassroomsByCourse(Long courseId) {
        return classroomRepository.findByCourseId(courseId);
    }

    public List<Classroom> getClassroomsByTeacher(Long teacherId) {
        return classroomRepository.findByTeacherId(teacherId);
    }

    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }

    public void deleteClassroom(Long id) {
        classroomRepository.deleteById(id);
    }

}
