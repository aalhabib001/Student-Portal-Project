package com.habib.securityproject.securityproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AddStudent {
    String studentId;

    String studentName;

    String studentDept;

    String batchNumber;

    String studentPhoneNumber;

    String shift;

    @NotBlank
    @Size(min = 3, max = 50)
    private String studentUsername;

    @NotBlank
    @Size(max = 60)
    @Email
    private String studentEmail;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String studentPassword;
}
