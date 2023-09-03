package com.example.bcp_generator.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSharedTaskDTO {
    private String description;
    private String title;
    private Long userId;

    // Getters and setters
}
