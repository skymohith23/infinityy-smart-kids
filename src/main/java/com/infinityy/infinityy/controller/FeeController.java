package com.infinityy.infinityy.controller;

import com.infinityy.infinityy.model.Fee;
import com.infinityy.infinityy.model.Student;
import com.infinityy.infinityy.repository.FeeRepository;
import com.infinityy.infinityy.repository.StudentRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teacher")
public class FeeController {

    private final StudentRepository studentRepository;
    private final FeeRepository feeRepository;

    public FeeController(StudentRepository studentRepository, FeeRepository feeRepository) {
        this.studentRepository = studentRepository;
        this.feeRepository = feeRepository;
    }

    @GetMapping("/fees")
    public String selectStudentForFees(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "fee-select-student";
    }

    @GetMapping("/fees/update/{studentId}")
    public String updateFeeForm(@PathVariable Long studentId, Model model) {
        Student student = studentRepository.findById(studentId).orElse(null);
        model.addAttribute("student", student);
        return "update-fee";
    }

    @PostMapping("/fees/update")
    public String saveFee(@RequestParam Long studentId,
                          @RequestParam String month,
                          @RequestParam boolean paid) {

        Fee fee = new Fee();
        fee.setStudentId(studentId);
        fee.setMonth(month);
        fee.setPaid(paid);

        feeRepository.save(fee);

        return "redirect:/teacher/fees";
    }
}
