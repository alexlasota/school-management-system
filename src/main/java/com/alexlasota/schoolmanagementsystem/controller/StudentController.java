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
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/lastName/{lastName}")
    public List<Student> getStudentsByLastName(@PathVariable String lastName) {
        return studentService.getStudentListByLastName(lastName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
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