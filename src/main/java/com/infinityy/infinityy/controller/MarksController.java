package com.infinityy.infinityy.controller;

import com.infinityy.infinityy.model.Marks;
import com.infinityy.infinityy.model.Student;
import com.infinityy.infinityy.repository.MarksRepository;
import com.infinityy.infinityy.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teacher")
public class MarksController {

    private final StudentRepository studentRepository;
    private final MarksRepository marksRepository;

    public MarksController(StudentRepository studentRepository, MarksRepository marksRepository) {
        this.studentRepository = studentRepository;
        this.marksRepository = marksRepository;
    }

    @GetMapping("/marks")
    public String selectStudent(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "select-student-marks";
    }

    @GetMapping("/marks/add/{studentId}")
    public String addMarksForm(@PathVariable Long studentId, Model model) {
        Student student = studentRepository.findById(studentId).orElse(null);
        model.addAttribute("student", student);
        return "add-marks";
    }

    @PostMapping("/marks/add")
    public String saveMarks(@RequestParam Long studentId,
                            @RequestParam String subject,
                            @RequestParam int score) {

        Marks marks = new Marks();
        marks.setStudentId(studentId);
        marks.setSubject(subject);
        marks.setScore(score);

        marksRepository.save(marks);

        return "redirect:/teacher/marks";
    }
}
