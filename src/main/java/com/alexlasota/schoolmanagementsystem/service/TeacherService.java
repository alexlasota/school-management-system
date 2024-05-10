package com.alexlasota.schoolmanagementsystem.service;

import com.alexlasota.schoolmanagementsystem.model.Gender;
import com.alexlasota.schoolmanagementsystem.model.Teacher;
import com.alexlasota.schoolmanagementsystem.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getTeachers(Gender gender) {
        return Optional.ofNullable(gender).isPresent() ? teacherRepository.getTeacherListByGender(gender)
                : teacherRepository.getTeachers();
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.getTeacherById(id)
                .orElseThrow(() -> new IllegalArgumentException("Teacher with given id doesn't exist"));
    }

    public Teacher addTeacher(Teacher teacher) {
        teacherRepository.addTeacher(teacher);
        return teacher;
    }

    public void removeTeacherById(Long id) {
        teacherRepository.removeTeacherById(id);
    }

    public Teacher editTeacher(Long id, Teacher newTeacherData) {
        Teacher teacherToEdit = teacherRepository.getTeacherById(id)
                .orElseThrow(() -> new IllegalArgumentException("Teacher with given id doesn't exist"));

        teacherRepository.editTeacher(teacherToEdit, newTeacherData);
        return teacherToEdit;
    }

    public Teacher updateTeacherSalary(Long teacherId, Double newSalary) {
        Teacher teacher = teacherRepository.getTeacherById(teacherId)
                .orElseThrow(() -> new IllegalArgumentException("Teacher with given ID doesn't exist"));

        return teacherRepository.updateTeacherSalary(teacher, newSalary);
    }
}
