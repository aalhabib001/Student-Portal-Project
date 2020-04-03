package com.habib.securityproject.securityproject.dto.response;

import com.habib.securityproject.securityproject.model.CourseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfo {
    String studentId;
    String studentName;
    String studentDept;
    List<CourseModel> courseModels;
}
