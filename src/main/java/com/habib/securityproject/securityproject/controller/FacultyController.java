package com.habib.securityproject.securityproject.controller;

import com.habib.securityproject.securityproject.dto.request.AddCourses;
import com.habib.securityproject.securityproject.dto.request.CourseOffer;
import com.habib.securityproject.securityproject.services.FacultyServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyServices facultyServices;
    @PutMapping("/addCourses/{id}")
    public ResponseEntity addCoursesToStudent(@PathVariable String id, @RequestBody AddCourses addCourses){
        return facultyServices.addCourses(addCourses,id);
    }

    @PostMapping("/courseOffer")
//    @Secured("FACULTY")
    public ResponseEntity<String> courseOffer(@RequestBody CourseOffer courseOffer){
        return facultyServices.courseOffer(courseOffer);
    }
}
