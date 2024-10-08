package com.ashley.school;


import com.ashley.school.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolServices {
    private final SchoolRepository schoolRepository;

    private final StudentClient client;

    public void saveSchool(School school) {
        schoolRepository.save(school);

    }

    public List<School> findAllSchool() {
        return schoolRepository.findAll();
    }


    public FullSchoolResponse findSchoolWithStudents(Long schoolId) {
        var school= schoolRepository.findById(schoolId)
                .orElse(
                        School.builder()
                                .name("School not found")
                                .email("School not found")
                                .build()
                );
        var students = client.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}