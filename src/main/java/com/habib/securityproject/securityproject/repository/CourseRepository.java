package com.habib.securityproject.securityproject.repository;


import com.habib.securityproject.securityproject.model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseModel,String> {
}
