package com.example.bcp_generator.ServiceImpl;

import com.example.bcp_generator.DTO.MonthlyTaskDTO;
import com.example.bcp_generator.Model.MonthlyTaskModel;
import com.example.bcp_generator.Model.SharedTaskModel;
import com.example.bcp_generator.Model.UserModel;
import com.example.bcp_generator.Repository.MonthlyTaskRepository;
import com.example.bcp_generator.Repository.SharedTaskRepository;
import com.example.bcp_generator.Repository.UserRepository;
import com.example.bcp_generator.Service.MonthlyTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MonthlyTaskServiceImpl implements MonthlyTaskService {

    private final MonthlyTaskRepository monthlyTaskRepository;
    private final UserRepository userRepository;
    private final SharedTaskRepository sharedTaskRepository;

    @Autowired
    public MonthlyTaskServiceImpl(MonthlyTaskRepository monthlyTaskRepository,
                                  UserRepository userRepository,
                                  SharedTaskRepository sharedTaskRepository) {
        this.monthlyTaskRepository = monthlyTaskRepository;
        this.userRepository = userRepository;
        this.sharedTaskRepository = sharedTaskRepository;
    }

    @Override
    public MonthlyTaskModel addMonthlyTaskWithEmptySharedTask(Long userId, MonthlyTaskDTO monthlyTaskDTO) {
        // Extract the data from the DTO
        LocalDate date = monthlyTaskDTO.getDate();
        LocalTime startTime = monthlyTaskDTO.getStartTime();
        LocalTime endTime = monthlyTaskDTO.getEndTime();

        // Fetch the user from the UserRepository
        Optional<UserModel> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            UserModel user = userOptional.get();

            // Create a new MonthlyTaskModel and set the user, date, times, and an empty shared task list
            MonthlyTaskModel monthlyTask = new MonthlyTaskModel();
            monthlyTask.setDate(date);
            monthlyTask.setStartTime(startTime);
            monthlyTask.setEndTime(endTime);
            monthlyTask.setUser(user);

            // Initialize an empty list for shared tasks
            List<SharedTaskModel> sharedTasks = new ArrayList<>();

            // Set the empty list of shared tasks
            monthlyTask.setSharedTasks(sharedTasks);

            // Save the monthly task to the database
            return monthlyTaskRepository.save(monthlyTask);
        } else {
            // Handle the case where the user is not found (e.g., throw an exception or return null)
            return null;
        }
    }


}


