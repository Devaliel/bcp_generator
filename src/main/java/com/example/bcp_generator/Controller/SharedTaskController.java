package com.example.bcp_generator.Controller;

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

    @Autowired
    public SharedTaskController(SharedTaskService sharedTaskService, UserRepository userRepository) {
        this.sharedTaskService = sharedTaskService;
        this.userRepository = userRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<SharedTaskModel> createTask(@RequestBody SharedTaskModel task, @RequestParam Long userId) {
        Optional<UserModel> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            UserModel user = userOptional.get();

            // Add the task for the user by passing both the task and user
            SharedTaskModel createdTask = sharedTaskService.addTask(task, user);

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


    // Add other controller methods for managing shared tasks (e.g., updating tasks, deleting tasks)
}
