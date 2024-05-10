package com.alexlasota.schoolmanagementsystem.repository;

import com.alexlasota.schoolmanagementsystem.model.Gender;
import com.alexlasota.schoolmanagementsystem.model.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TeacherRepository {
    private final List<Teacher> teachers = new ArrayList<>();

    public List<Teacher> getTeachers() {
        return new ArrayList<>(teachers);
    }

    public List<Teacher> getTeacherListByGender(Gender gender) {
        return teachers.stream()
                .filter(teacher -> teacher.getGender().equals(gender))
                .toList();
    }

    public Optional<Teacher> getTeacherById(Long id) {
        return teachers.stream()
                .filter(teacher -> teacher.getId().equals(id))
                .findFirst();
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        long nextId = teachers.stream().mapToLong(Teacher::getId).max().orElse(1) + 1L;
        teacher.setId(nextId);
    }

    public void removeTeacherById(Long id) {
        teachers.removeIf(teacher -> teacher.getId().equals(id));
    }

    public void editTeacher(Teacher teacher, Teacher newTeacherData) {
        teacher.setPhoneNumber(newTeacherData.getPhoneNumber());
        teacher.setFirstName(newTeacherData.getFirstName());
        teacher.setLastName(newTeacherData.getLastName());
        teacher.setBirthday(newTeacherData.getBirthday());
        teacher.setPesel(newTeacherData.getPesel());
        teacher.setGender(newTeacherData.getGender());
        teacher.setSalary(newTeacherData.getSalary());
    }

//    public Teacher updateTeacherPhoneNumber(Teacher teacher, String newPhoneNumber) {
//        teacher.setPhoneNumber(newPhoneNumber);
//        return teacher;
//    } Long id? Nie poniewaz repo?

    public Teacher updateTeacherSalary(Teacher teacher, Double newSalary) {
        teacher.setSalary(newSalary);
        return teacher;
    }
}

