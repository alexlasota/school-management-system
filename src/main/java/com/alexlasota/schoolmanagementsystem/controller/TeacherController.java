package com.alexlasota.schoolmanagementsystem.controller;

import com.alexlasota.schoolmanagementsystem.model.Gender;
import com.alexlasota.schoolmanagementsystem.model.Teacher;
import com.alexlasota.schoolmanagementsystem.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public List<Teacher> getAllTeachers(@RequestParam(required = false) Gender gender) {
        return teacherService.getTeachers(gender);
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    @PutMapping("/{id}")
    public Teacher editTeacher(@PathVariable Long id, @RequestBody Teacher newTeacherData) {
        return teacherService.editTeacher(id, newTeacherData);
    }

    @PatchMapping("/{id}/salary")
    public Teacher updateTeacherSalary(@PathVariable Long id, @RequestBody Double newSalary) {
        return teacherService.updateTeacherSalary(id, newSalary);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.removeTeacherById(id);
    }
}
