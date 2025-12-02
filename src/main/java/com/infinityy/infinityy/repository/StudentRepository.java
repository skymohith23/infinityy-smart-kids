package com.infinityy.infinityy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.infinityy.infinityy.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
