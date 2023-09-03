package com.example.bcp_generator.Controller;


import com.example.bcp_generator.DTO.MonthlyTaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.bcp_generator.Model.MonthlyTaskModel;
import com.example.bcp_generator.Service.MonthlyTaskService;

@RestController
@RequestMapping("/monthly-tasks")
public class MonthlyTaskController {

    private final MonthlyTaskService monthlyTaskService;

    @Autowired
    public MonthlyTaskController(MonthlyTaskService monthlyTaskService) {
        this.monthlyTaskService = monthlyTaskService;
    }

    @PostMapping("/{userId}/create")
    public ResponseEntity<MonthlyTaskModel> createMonthlyTask(
            @PathVariable Long userId,
            @RequestBody MonthlyTaskDTO monthlyTaskDTO
    ) {
        MonthlyTaskModel createdTask = monthlyTaskService.addMonthlyTaskWithEmptySharedTask(userId, monthlyTaskDTO);

        if (createdTask != null) {
            return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}

