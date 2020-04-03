package com.habib.securityproject.securityproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "FACULTY_MODEL")
public class FacultyModel {
    @Id
    String facultyId;

    String facultyName;

    String facultyPhone;

    String facultyEmail;

    String facultyDept;
}
