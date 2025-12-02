package com.infinityy.infinityy.controller;

import com.infinityy.infinityy.model.Student;
import com.infinityy.infinityy.repository.AttendanceRepository;
import com.infinityy.infinityy.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ParentAttendanceController {

    private final AttendanceRepository attendanceRepository;
    private final StudentRepository studentRepository;

    public ParentAttendanceController(AttendanceRepository attendanceRepository,
                                      StudentRepository studentRepository) {
        this.attendanceRepository = attendanceRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/parent/attendance")
    public String viewAttendance(Model model) {

        if (studentRepository.findAll().isEmpty()) {
            model.addAttribute("error", "No students found. Please ask the teacher to add students first.");
            return "parent-attendance";
        }

        Student student = studentRepository.findAll().get(0);

        model.addAttribute("student", student);
        model.addAttribute("attendance", attendanceRepository.findByStudentId(student.getId()));

        return "parent-attendance";
    }
}
