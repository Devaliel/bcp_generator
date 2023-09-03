package com.example.bcp_generator.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthlyTaskDTO {
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    // Getters and setters
}
