package com.infinityy.infinityy.model;

import jakarta.persistence.*;

@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    private boolean present;

    @ManyToOne
    private Student student;

    public Attendance() {}

    public Attendance(String date, boolean present, Student student) {
        this.date = date;
        this.present = present;
        this.student = student;
    }

    // Getters & Setters
    public Long getId() { 
        return id; 
    }

    public void setId(Long id) { 
        this.id = id; 
    }

    public String getDate() { 
        return date; 
    }

    public void setDate(String date) { 
        this.date = date; 
    }

    public boolean isPresent() { 
        return present; 
    }

    public void setPresent(boolean present) { 
        this.present = present; 
    }

    public Student getStudent() { 
        return student; 
    }

    public void setStudent(Student student) { 
        this.student = student; 
    }

    // 🔥 Required by AttendanceController
    public void setStudentId(Long studentId) {
        if (this.student == null) {
            this.student = new Student();
        }
        this.student.setId(studentId);
    }
}
