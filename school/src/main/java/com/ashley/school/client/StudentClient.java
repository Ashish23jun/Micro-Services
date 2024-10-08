package com.ashley.school.client;

import com.ashley.school.Students;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service",url = "${application.config.students-url}")
public interface StudentClient {
    @GetMapping("/school/{school-id}")
    List<Students> findAllStudentsBySchool(
            @PathVariable("school-id")
            Long schoolId);
}
