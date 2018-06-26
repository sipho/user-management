package com.bs.em.controller;

import com.bs.em.dto.UserTaskDTO;
import com.bs.em.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${em.app.api-prefix}/user")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/{user_id}/task")
    @ResponseStatus(HttpStatus.CREATED)
    public UserTaskDTO create(@Validated @RequestBody UserTaskDTO dto, @PathVariable(name = "user_id") Long userId){
        return taskService.create(dto, userId);
    }

    @PutMapping("/{user_id}/task/{task_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public UserTaskDTO update(@RequestBody UserTaskDTO dto, @PathVariable(name = "user_id") Long userId, @PathVariable("task_id") Long taskId){
        return taskService.update(dto, userId, taskId);
    }

    @GetMapping("/{user_id}/task/{task_id}")
    public UserTaskDTO search(@PathVariable(name = "user_id") Long userId, @PathVariable("task_id") Long taskId){
        return taskService.search(userId, taskId);
    }

    @GetMapping("/{user_id}/task")
    public List<UserTaskDTO> findAllByUser(@PathVariable(name = "user_id") Long userId){
        return taskService.findAllByUser(userId);
    }

    @DeleteMapping("/{user_id}/task/{task_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(name = "user_id") Long userId, @PathVariable("task_id") Long taskId){
        taskService.delete(taskId, userId);
    }
    
}
