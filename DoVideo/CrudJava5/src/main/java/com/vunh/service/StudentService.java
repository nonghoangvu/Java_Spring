package com.vunh.service;

import com.vunh.entity.Student;
import com.vunh.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return this.studentRepository.findById(id).orElseThrow(() -> new NullPointerException("Student not found"));
    }

    public void addOrUpdateStudent(Student student) {
        this.studentRepository.save(student);
    }
    public void deleteStudentById(int id) {
        this.studentRepository.deleteById(id);
    }
}
