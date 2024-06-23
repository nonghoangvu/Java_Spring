package com.vunh.service;

import com.vunh.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private List<Student> students;

    public StudentService() {
        this.students = new ArrayList<Student>();
        this.students.add(new Student("PH33506", "Nong Hoang Vu"));
        this.students.add(new Student("PH321", "Hacker Vuz 1"));
        this.students.add(new Student("PH123", "Hacker Vuz 2"));
        this.students.add(new Student("PH456", "Hacker Vuz 3"));
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Student> getStudents(String name) {
        return this.students.stream().filter(s -> s.getName().contains(name.trim()) || s.getId().contains(name.trim())).toList();
    }

}
