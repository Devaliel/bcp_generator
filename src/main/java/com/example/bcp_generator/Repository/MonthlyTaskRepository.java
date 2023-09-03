package com.example.bcp_generator.Repository;


import com.example.bcp_generator.Model.MonthlyTaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface MonthlyTaskRepository extends JpaRepository<MonthlyTaskModel,Long> {
    Optional<MonthlyTaskModel> findByUserIdAndDate(Long employeeId, LocalDate taskDate);
}
