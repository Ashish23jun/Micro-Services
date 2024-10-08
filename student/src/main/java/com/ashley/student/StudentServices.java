package com.ashley.student;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServices {
    private final StudentRepository studentRepository;

    public void saveStudent(Student student) {
        studentRepository.save(student);

    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }


    public List<Student> findAllStudentsBySchool(Long schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }
}