package com.habib.securityproject.securityproject.dto.request;

import com.habib.securityproject.securityproject.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AddFaculty {
    String facultyId;

    String facultyUserName;

    String facultyName;

    String facultyPhone;

    String facultyEmail;

    String facultyDept;

    private Set<String> role;

    String facultyPassword;
}
