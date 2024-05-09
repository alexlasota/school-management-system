package com.alexlasota.schoolmanagementsystem.service;

import com.alexlasota.schoolmanagementsystem.model.Student;
import com.alexlasota.schoolmanagementsystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getStudents(String lastName) {
        return Optional.ofNullable(lastName).isPresent() ? studentRepository.getStudentListByLastName(lastName)
                : studentRepository.getStudents();

    }

    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student with given id doesnt exist"));
    }

    public Student addStudent(Student student) {
        studentRepository.addStudent(student);
        return student;
    }

    public void removeStudentById(Long id) {
        studentRepository.removeStudentById(id);
    }

    public Student editStudent(Long id, Student newStudentData) {
        Student studentToEdit = studentRepository.getStudentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student with given id doesnt exist"));

        studentRepository.editStudent(studentToEdit, newStudentData);
        return studentToEdit;
    }

    public Student updateStudentPhoneNumber(Long studentId, String newPhoneNumber) {
        Student student = studentRepository.getStudentById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student with given ID doesn't exist"));

        return studentRepository.updateStudentPhoneNumber(student, newPhoneNumber);
    }
}
