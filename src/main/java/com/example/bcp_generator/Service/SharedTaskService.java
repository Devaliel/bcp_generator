package com.example.bcp_generator.Service;

import com.example.bcp_generator.DTO.AddSharedTaskRequest;
import com.example.bcp_generator.DTO.CreateSharedTaskDTO;
import com.example.bcp_generator.Model.MonthlyTaskModel;
import com.example.bcp_generator.Model.SharedTaskModel;
import com.example.bcp_generator.Model.UserModel;

import java.util.List;

public interface SharedTaskService {
    SharedTaskModel addTask(CreateSharedTaskDTO taskDTO, UserModel user);
    List<SharedTaskModel> getAllTasks();

    MonthlyTaskModel addSharedTaskToMonthlyTask(Long monthlyTaskId, Long sharedTaskId);

}
