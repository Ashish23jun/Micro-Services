package com.ashley.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentServices service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(
            @RequestBody Student student)
    {
        service.saveStudent(student);
    }

    @GetMapping
   public ResponseEntity<List<Student>> findAllStudents() {
        return ResponseEntity.ok(service.findAllStudents());
    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> findAllStudents(
            @PathVariable("school-id") Long schoolId
    ) {
        return ResponseEntity.ok(service.findAllStudentsBySchool(schoolId));
    }
}
