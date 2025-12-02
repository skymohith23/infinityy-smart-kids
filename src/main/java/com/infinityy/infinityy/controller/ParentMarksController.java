package com.infinityy.infinityy.controller;

import com.infinityy.infinityy.model.Student;
import com.infinityy.infinityy.repository.MarksRepository;
import com.infinityy.infinityy.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ParentMarksController {

    private final MarksRepository marksRepository;
    private final StudentRepository studentRepository;

    public ParentMarksController(MarksRepository marksRepository, StudentRepository studentRepository) {
        this.marksRepository = marksRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/parent/marks")
    public String viewMarks(Model model) {

        // If there are no students yet, show a message instead of crashing
        if (studentRepository.findAll().isEmpty()) {
            model.addAttribute("error", "No students found. Please ask the teacher to add students first.");
            return "parent-marks";
        }

        // For now, just use the first student
        Student student = studentRepository.findAll().get(0);

        model.addAttribute("student", student);
        model.addAttribute("marks", marksRepository.findByStudentId(student.getId()));

        return "parent-marks";
    }
}
