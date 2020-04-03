package com.habib.securityproject.securityproject.controller;


import com.habib.securityproject.securityproject.dto.request.AddFaculty;
import com.habib.securityproject.securityproject.services.ERPServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@AllArgsConstructor

@RestController
@RequestMapping("/erp")
public class ERPController {

    private final ERPServices erpServices;
//    @PostMapping("/addStudent")
//    public IdentityResponse addStudent(@RequestBody AddStudent addStudent){
//        return erpServices.addStudent(addStudent);
//    }
    @PostMapping("/addFaculty")
    public ResponseEntity addFaculty(@RequestBody AddFaculty addFaculty){

        return erpServices.addFaculty(addFaculty);
    }

//    @PutMapping("/editStudent")
//    public void editStudent(@RequestMapping ){
//
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> signIn(@RequestBody SignInRequestForm signInRequestForm){
//        return erpServices.signIn(signInRequestForm);
//    }
//
//    @DeleteMapping("/deleteStudent/{id}")
//    public void deleteStudent(@PathVariable String id){
//
//    }

}
