package com.example.bcp_generator.Repository;

import com.example.bcp_generator.Model.MonthlyReportModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthlyReportRepository extends JpaRepository<MonthlyReportModel, Long> {
}
