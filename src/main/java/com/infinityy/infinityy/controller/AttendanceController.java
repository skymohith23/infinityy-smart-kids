package com.infinityy.infinityy.controller;

import com.infinityy.infinityy.model.Attendance;
import com.infinityy.infinityy.model.Student;
import com.infinityy.infinityy.repository.AttendanceRepository;
import com.infinityy.infinityy.repository.StudentRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teacher")
public class AttendanceController {

    private final StudentRepository studentRepository;
    private final AttendanceRepository attendanceRepository;

    public AttendanceController(StudentRepository studentRepository,
                                AttendanceRepository attendanceRepository) {
        this.studentRepository = studentRepository;
        this.attendanceRepository = attendanceRepository;
    }

    @GetMapping("/attendance")
    public String chooseStudent(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "attendance-select-student";
    }

    @GetMapping("/attendance/mark/{studentId}")
    public String markAttendanceForm(@PathVariable Long studentId, Model model) {
        Student student = studentRepository.findById(studentId).orElse(null);
        model.addAttribute("student", student);
        return "mark-attendance";
    }

    @PostMapping("/attendance/mark")
    public String saveAttendance(@RequestParam Long studentId,
                                 @RequestParam boolean present,
                                 @RequestParam String date) {

        Attendance att = new Attendance();
        att.setStudentId(studentId);
        att.setPresent(present);
        att.setDate(date);

        attendanceRepository.save(att);

        return "redirect:/teacher/attendance";
    }
}
