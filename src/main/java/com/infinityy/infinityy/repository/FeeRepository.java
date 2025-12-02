package com.infinityy.infinityy.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.infinityy.infinityy.model.Fee;

public interface FeeRepository extends JpaRepository<Fee, Long> {
    List<Fee> findByStudentId(Long studentId);
}
