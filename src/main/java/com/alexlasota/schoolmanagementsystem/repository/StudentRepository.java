package com.alexlasota.schoolmanagementsystem.repository;

import com.alexlasota.schoolmanagementsystem.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class StudentRepository {
    private final List<Student> students;

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public List<Student> getStudentListByLastName(String lastName) {
        return students.stream()
                .filter(student -> student.getLastName().equals(lastName))
                .toList();
    }

    public Optional<Student> getStudentById(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    public void addStudent(Student student) {
        students.add(student);
        long nextId = students.stream().mapToLong(Student::getId).max().orElse(1) + 1L;
        student.setId(nextId);
    }

    public void removeStudentById(Long id) {
        students.removeIf(student -> student.getId().equals(id));

    }

    public void editStudent(Student student, Student newStudentData) {
        student.setPhoneNumber(newStudentData.getPhoneNumber());
        student.setFirstName(newStudentData.getFirstName());
        student.setLastName(newStudentData.getLastName());
        student.setBirthday(newStudentData.getBirthday());
        student.setPesel(newStudentData.getPesel());
        student.setGender(newStudentData.getGender());
    }

    public Student updateStudentPhoneNumber(Student student, String newPhoneNumber) {
        student.setPhoneNumber(newPhoneNumber);
        return student;
    }
}