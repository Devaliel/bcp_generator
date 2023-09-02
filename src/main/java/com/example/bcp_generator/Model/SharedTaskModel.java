package com.example.bcp_generator.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SharedTaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String title;

    @ManyToMany(mappedBy = "sharedTasks")
    private List<UserModel> sharedByUsers;

    @ManyToMany
    @JoinTable(
            name = "monthly_report_shared_task",
            joinColumns = @JoinColumn(name = "monthly_report_id"),
            inverseJoinColumns = @JoinColumn(name = "shared_task_id")
    )
    private List<SharedTaskModel> sharerdTask;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;


    // Getters and setters
}
