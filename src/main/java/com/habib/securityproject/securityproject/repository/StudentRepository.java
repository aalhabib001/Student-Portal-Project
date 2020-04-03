package com.habib.securityproject.securityproject.repository;

import com.habib.securityproject.securityproject.model.StudentInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentInfoModel,String> {
}
