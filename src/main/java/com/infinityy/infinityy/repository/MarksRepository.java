package com.infinityy.infinityy.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.infinityy.infinityy.model.Marks;

public interface MarksRepository extends JpaRepository<Marks, Long> {
    List<Marks> findByStudentId(Long studentId);
}
