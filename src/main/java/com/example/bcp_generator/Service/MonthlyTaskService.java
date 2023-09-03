package com.example.bcp_generator.Service;


import com.example.bcp_generator.DTO.MonthlyTaskDTO;
import com.example.bcp_generator.Model.MonthlyTaskModel;

import java.time.LocalDate;
import java.time.LocalTime;

public interface MonthlyTaskService {
    MonthlyTaskModel addMonthlyTaskWithEmptySharedTask(Long userId, MonthlyTaskDTO monthlyTaskDTO);
}
