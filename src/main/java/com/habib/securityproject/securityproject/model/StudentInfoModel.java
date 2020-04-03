package com.habib.securityproject.securityproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "STUDENT_INFO")
public class StudentInfoModel {
    @Id
    String studentId;

    String studentName;

    String studentDept;

    String batchNumber;

    String studentPhoneNumber;

    String shift;

    String adviserName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "STUDENT_COURSES",
            joinColumns = @JoinColumn(name = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "courseCode"))
    Set<CourseModel> courseModels = new HashSet<>();

}
