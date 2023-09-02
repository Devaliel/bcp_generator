package com.example.bcp_generator.Service;

import com.example.bcp_generator.Model.SharedTaskModel;
import com.example.bcp_generator.Model.UserModel;

import java.util.List;

public interface SharedTaskService {
    SharedTaskModel addTask(SharedTaskModel task, UserModel user);
    List<SharedTaskModel> getAllTasks();

}
