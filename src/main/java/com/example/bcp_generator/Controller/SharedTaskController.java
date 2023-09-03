package com.example.bcp_generator.Controller;

import com.example.bcp_generator.DTO.AddSharedTaskRequest;
import com.example.bcp_generator.DTO.CreateSharedTaskDTO;
import com.example.bcp_generator.Model.MonthlyTaskModel;
import com.example.bcp_generator.Service.MonthlyTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.bcp_generator.Model.SharedTaskModel;
import com.example.bcp_generator.Model.UserModel;
import com.example.bcp_generator.Repository.UserRepository;
import com.example.bcp_generator.Service.SharedTaskService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class SharedTaskController {

    private final SharedTaskService sharedTaskService;
    private final UserRepository userRepository;
    private final MonthlyTaskService monthlyTaskService;



    @Autowired
    public SharedTaskController(SharedTaskService sharedTaskService,
                                UserRepository userRepository,
                                MonthlyTaskService monthlyTaskService) {
        this.sharedTaskService = sharedTaskService;
        this.userRepository = userRepository;
        this.monthlyTaskService = monthlyTaskService ;
    }

    @PostMapping("/create")
    public ResponseEntity<SharedTaskModel> createTask(@RequestBody CreateSharedTaskDTO taskDTO, @RequestParam Long userId) {
        Optional<UserModel> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            UserModel user = userOptional.get();

            // Add the task for the user by passing the DTO and user
            SharedTaskModel createdTask = sharedTaskService.addTask(taskDTO, user);

            // Return the created task in the response
            return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
        } else {
            // Handle the case where the user is not found (e.g., return a 404 response)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




    @GetMapping("/getAll")
    public ResponseEntity<List<SharedTaskModel>> getAllTasks() {
        List<SharedTaskModel> tasks = sharedTaskService.getAllTasks();

        if (!tasks.isEmpty()) {
            // Return the list of tasks if not empty
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        } else {
            // Handle the case where no tasks are found (e.g., return a 404 response)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/{monthlyTaskId}/add-shared-task")
    public ResponseEntity<MonthlyTaskModel> addSharedTaskToMonthlyTask(
            @PathVariable Long monthlyTaskId,
            @RequestParam Long sharedTaskId
    ) {
        MonthlyTaskModel updatedMonthlyTask = sharedTaskService.addSharedTaskToMonthlyTask(monthlyTaskId, sharedTaskId);

        if (updatedMonthlyTask != null) {
            return new ResponseEntity<>(updatedMonthlyTask, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
