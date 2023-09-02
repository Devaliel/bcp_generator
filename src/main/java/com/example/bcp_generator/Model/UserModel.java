package com.example.bcp_generator.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    @OneToMany(mappedBy = "user")
    private List<MonthlyReportModel> monthlyReports;

    @ManyToMany
    @JoinTable(
            name = "user_shared_task",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "shared_task_id")
    )
    private List<SharedTaskModel> sharedTasks;

    // Getters and setters
}

