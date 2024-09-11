package com.ashley.school;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolServices service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSchool(
            @RequestBody School school)
    {
        service.saveSchool(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAllSchool() {
        return ResponseEntity.ok(service.findAllSchool());
    }

    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> findAllSchool(
            @PathVariable("school-id") Long schoolId
    ) {
        return ResponseEntity.ok(service.findSchoolWithStudents(schoolId));
    }
}
