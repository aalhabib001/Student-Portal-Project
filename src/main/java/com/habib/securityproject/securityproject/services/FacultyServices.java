package com.habib.securityproject.securityproject.services;


import com.habib.securityproject.securityproject.dto.request.AddCourses;
import com.habib.securityproject.securityproject.dto.request.CourseOffer;
import com.habib.securityproject.securityproject.model.CourseModel;
import com.habib.securityproject.securityproject.model.StudentInfoModel;
import com.habib.securityproject.securityproject.repository.CourseRepository;
import com.habib.securityproject.securityproject.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor

@Service
public class FacultyServices {
    private  final CourseRepository courseRepository;
    private  final StudentRepository studentRepository;

    private final com.habib.securityproject.securityproject.services.SignUpAndSignInService signUpAndSignInService ;

    public ResponseEntity<String> courseOffer(CourseOffer courseOffer) {
        CourseModel courseModel = new CourseModel();
        courseModel.setCourseCode(courseOffer.getCourseCode());
        courseModel.setCourseName(courseOffer.getCourseName());

        courseRepository.save(courseModel);
        return new ResponseEntity(courseOffer.getCourseName()+" is Created and Ready for Offer", HttpStatus.CREATED);

    }

    public ResponseEntity addCourses(AddCourses addCourses, String id) {
        Optional<StudentInfoModel> studentInfoModelOptional = studentRepository.findById(id);
        StudentInfoModel studentInfoModel = studentInfoModelOptional.get();
        studentInfoModel.setCourseModels(getCourseSet(addCourses.getCourseCodes()));
        studentInfoModel.setAdviserName(signUpAndSignInService.getLoggedAuthUserName());

        studentRepository.save(studentInfoModel);
        return new ResponseEntity("Course Added to "+studentInfoModel.getStudentName(),HttpStatus.CREATED);
    }

    public Set<CourseModel> getCourseSet(Set<String> courses){
        Set<CourseModel> courseModelSet = new HashSet<>();
        for (String course:courses){
            Optional<CourseModel> courseModelOptional = courseRepository.findById(course);
            if(!courseModelOptional.isPresent()){
                throw new ResourceAccessException("Course Not Found");
            }
            courseModelSet.add(courseModelOptional.get());
        }
        return  courseModelSet;
    }
}
