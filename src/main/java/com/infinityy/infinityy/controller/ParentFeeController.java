package com.infinityy.infinityy.controller;

import com.infinityy.infinityy.model.Student;
import com.infinityy.infinityy.repository.FeeRepository;
import com.infinityy.infinityy.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ParentFeeController {

    private final FeeRepository feeRepository;
    private final StudentRepository studentRepository;

    public ParentFeeController(FeeRepository feeRepository, StudentRepository studentRepository) {
        this.feeRepository = feeRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/parent/fees")
    public String viewFees(Model model) {

        if (studentRepository.findAll().isEmpty()) {
            model.addAttribute("error", "No students found. Please ask the teacher to add students first.");
            return "parent-fees";
        }

        Student student = studentRepository.findAll().get(0);

        model.addAttribute("student", student);
        model.addAttribute("fees", feeRepository.findByStudentId(student.getId()));

        return "parent-fees";
    }
}
