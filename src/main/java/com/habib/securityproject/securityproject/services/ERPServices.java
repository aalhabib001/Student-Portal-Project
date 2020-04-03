package com.habib.securityproject.securityproject.services;

import com.habib.securityproject.securityproject.dto.request.AddFaculty;
import com.habib.securityproject.securityproject.dto.request.AddStudent;
import com.habib.securityproject.securityproject.dto.request.SignUpForm;
import com.habib.securityproject.securityproject.dto.response.IdentityResponse;
import com.habib.securityproject.securityproject.model.*;
import com.habib.securityproject.securityproject.model.Role;
import com.habib.securityproject.securityproject.model.User;
import com.habib.securityproject.securityproject.repository.FacultyRepository;
import com.habib.securityproject.securityproject.repository.RoleRepository;
import com.habib.securityproject.securityproject.repository.StudentRepository;
import com.habib.securityproject.securityproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ERPServices {

    private final FacultyRepository facultyRepository;
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    PasswordEncoder encoder;

//    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity addFaculty(AddFaculty addFaculty){
        FacultyModel facultyModel = new FacultyModel();
        facultyModel.setFacultyId(addFaculty.getFacultyId());
        facultyModel.setFacultyName(addFaculty.getFacultyName());
        facultyModel.setFacultyDept(addFaculty.getFacultyDept());
        facultyModel.setFacultyEmail(addFaculty.getFacultyEmail());
        facultyModel.setFacultyPhone(addFaculty.getFacultyPhone());

        User faculty = new User();
        UUID id = UUID.randomUUID();
        String uuid = id.toString();
        faculty.setId(uuid);
        faculty.setEmail(addFaculty.getFacultyEmail());
        faculty.setName(addFaculty.getFacultyName());
        faculty.setUsername(addFaculty.getFacultyUserName());
        faculty.setRoles(getRolesOrThrow(addFaculty.getRole()));
        faculty.setPassword(encoder.encode(addFaculty.getFacultyPassword()));

        facultyRepository.save(facultyModel);
        userRepository.save(faculty);

        return new ResponseEntity(addFaculty.getFacultyName()+" Your Id is Created",HttpStatus.CREATED);

    }







    private Set<Role> getRolesOrThrow(Set<String> roles2) {
        Set<Role> roles = new HashSet<>();
        for (String role : roles2) {
            Optional<Role> roleOptional = roleRepository.findByName(com.habib.securityproject.securityproject.model.RoleName.valueOf(role));
            System.out.println(roleOptional.get());
            if (!roleOptional.isPresent()) {
                throw new ValidationException("Role '" + role + "' does not exist.");
            }
            roles.add(roleOptional.get());
        }
        return roles;
    }

    public ResponseEntity<String> addStudent(AddStudent addStudent) {
        StudentInfoModel studentInfoModel = new StudentInfoModel();
        studentInfoModel.setStudentId(addStudent.getStudentId());
        studentInfoModel.setStudentName(addStudent.getStudentName());
        studentInfoModel.setBatchNumber(addStudent.getBatchNumber());
        studentInfoModel.setShift(addStudent.getShift());
        studentInfoModel.setStudentDept(addStudent.getStudentDept());
        studentInfoModel.setStudentPhoneNumber(addStudent.getStudentPhoneNumber());

        User student = new User();
        UUID id = UUID.randomUUID();
        String uuid = id.toString();
        student.setId(uuid);
        student.setUsername(addStudent.getStudentUsername());
        student.setName(addStudent.getStudentName());
        student.setEmail(addStudent.getStudentEmail());
        student.setRoles(getRolesOrThrow(addStudent.getRole()));
        student.setPassword(encoder.encode(addStudent.getStudentPassword()));

        studentRepository.save(studentInfoModel);
        userRepository.save(student);

        return new ResponseEntity<>(addStudent.getStudentName()+"'s Id is created",HttpStatus.CREATED);
    }
}

