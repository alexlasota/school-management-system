package com.alexlasota.schoolmanagementsystem.controller;

import com.alexlasota.schoolmanagementsystem.model.Student;
import com.alexlasota.schoolmanagementsystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getStudents(@RequestParam(required = false) String lastName) {
        return studentService.getStudents(lastName);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeStudentById(@PathVariable Long id) {
        studentService.removeStudentById(id);
    }

    @PutMapping("/{id}")
    public Student editStudent(@PathVariable Long id, @RequestBody Student newStudentData) {
        return studentService.editStudent(id, newStudentData);
    }

    @PatchMapping("/{id}/phoneNumber")
    public Student updateStudentPhoneNumber(@PathVariable Long id, @RequestBody String newPhoneNumber) {
        return studentService.updateStudentPhoneNumber(id, newPhoneNumber);
    }
}