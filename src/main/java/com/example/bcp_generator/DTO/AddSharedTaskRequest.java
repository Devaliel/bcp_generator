package com.example.bcp_generator.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddSharedTaskRequest {
    private Long monthlyTaskId;
    private Long sharedTaskId;

    // Getters and setters
}

