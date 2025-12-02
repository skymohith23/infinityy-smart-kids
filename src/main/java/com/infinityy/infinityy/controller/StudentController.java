package com.infinityy.infinityy.controller;

import com.infinityy.infinityy.model.Student;
import com.infinityy.infinityy.repository.StudentRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // View students
    @GetMapping("/teacher/students")
    public String viewStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "students-list";
    }

    // Show add student form
    @GetMapping("/teacher/students/add")
    public String addStudentForm() {
        return "add-student";
    }

    // Save new student
    @PostMapping("/teacher/students/add")
    public String saveStudent(Student student) {
        studentRepository.save(student);
        return "redirect:/teacher/students";
    }
}
