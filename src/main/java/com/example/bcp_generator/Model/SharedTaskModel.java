package com.example.bcp_generator.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @ManyToMany
    @JoinTable(
            name = "monthly_task_shared_task",
            joinColumns = @JoinColumn(name = "shared_task_id"),
            inverseJoinColumns = @JoinColumn(name = "monthly_task_id")
    )
    @JsonBackReference
    private List<MonthlyTaskModel> monthlyTasks;
    // Getter and setters
}
