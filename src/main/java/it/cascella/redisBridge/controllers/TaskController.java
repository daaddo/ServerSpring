package it.cascella.redisBridge.controllers;

import it.cascella.redisBridge.dto.TaskDto;
import it.cascella.redisBridge.entities.Task;
import it.cascella.redisBridge.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sql/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping("/create")
    public Task createTask(@RequestBody Task task){
        return taskService.saveTask(task);
    }

    @GetMapping("/user/{id}")
    public List<TaskDto> getUserTasks(@PathVariable Long id ){
        return taskService.getUserTasks(id);
    }
}
