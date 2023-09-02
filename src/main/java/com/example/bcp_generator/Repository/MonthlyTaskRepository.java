package com.example.bcp_generator.Repository;


import com.example.bcp_generator.Model.MonthlyTaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthlyTaskRepository extends JpaRepository<MonthlyTaskModel,Long> {
}
