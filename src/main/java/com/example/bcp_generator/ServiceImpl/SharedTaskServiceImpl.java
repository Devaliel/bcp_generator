package com.example.bcp_generator.ServiceImpl;

import com.example.bcp_generator.DTO.AddSharedTaskRequest;
import com.example.bcp_generator.DTO.CreateSharedTaskDTO;
import com.example.bcp_generator.Model.MonthlyTaskModel;
import com.example.bcp_generator.Repository.MonthlyTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.bcp_generator.Model.SharedTaskModel;
import com.example.bcp_generator.Model.UserModel;
import com.example.bcp_generator.Repository.SharedTaskRepository;
import com.example.bcp_generator.Service.SharedTaskService;

@Service
public class SharedTaskServiceImpl implements SharedTaskService {

    private final SharedTaskRepository sharedTaskRepository;
    private final MonthlyTaskRepository monthlyTaskRepository;

    @Autowired
    public SharedTaskServiceImpl(SharedTaskRepository sharedTaskRepository,
                                 MonthlyTaskRepository monthlyTaskRepository) {
        this.sharedTaskRepository = sharedTaskRepository;
        this.monthlyTaskRepository = monthlyTaskRepository;
    }

    @Override
    public SharedTaskModel addTask(CreateSharedTaskDTO taskDTO, UserModel user) {
        // Create a new SharedTaskModel and populate its fields from the DTO
        SharedTaskModel task = new SharedTaskModel();
        task.setDescription(taskDTO.getDescription());
        task.setTitle(taskDTO.getTitle());

        // Associate the task with the user
        task.setUser(user);

        // Implement any additional logic or validation here

        // Save the task to the database
        return sharedTaskRepository.save(task);
    }

    @Override
    public List<SharedTaskModel> getAllTasks() {
        return sharedTaskRepository.findAll();
    }


    @Override
    public MonthlyTaskModel addSharedTaskToMonthlyTask(Long monthlyTaskId, Long sharedTaskId) {
        // Find the MonthlyTaskModel and SharedTaskModel from their respective repositories
        MonthlyTaskModel monthlyTask = monthlyTaskRepository.findById(monthlyTaskId).orElse(null);
        SharedTaskModel sharedTask = sharedTaskRepository.findById(sharedTaskId).orElse(null);

        // Check if both models exist
        if (monthlyTask != null && sharedTask != null) {
            // Add the shared task to the monthly task
            monthlyTask.getSharedTasks().add(sharedTask);

            // Set the monthly task for the shared task
            sharedTask.getMonthlyTasks().add(monthlyTask);

            // Save the updated monthly task to the database (this should also cascade to sharedTask)
            return monthlyTaskRepository.save(monthlyTask);
        } else {
            // Handle the case where either the monthly task or shared task is not found
            return null;
        }
    }


}
