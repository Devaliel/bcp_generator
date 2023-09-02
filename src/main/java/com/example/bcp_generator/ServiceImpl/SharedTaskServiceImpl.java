package com.example.bcp_generator.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.bcp_generator.Model.SharedTaskModel;
import com.example.bcp_generator.Model.UserModel;
import com.example.bcp_generator.Repository.SharedTaskRepository;
import com.example.bcp_generator.Service.SharedTaskService;

@Service
public class SharedTaskServiceImpl implements SharedTaskService {

    private final SharedTaskRepository sharedTaskRepository;

    @Autowired
    public SharedTaskServiceImpl(SharedTaskRepository sharedTaskRepository) {
        this.sharedTaskRepository = sharedTaskRepository;
    }

    @Override
    public SharedTaskModel addTask(SharedTaskModel task, UserModel user) {
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

}
