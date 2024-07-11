package it.cascella.redisBridge.service;

import it.cascella.redisBridge.repository.TaskRepository;
import it.cascella.redisBridge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;


    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElse(null);
    }
    public Task saveTask(Task task){
        return taskRepository.save(task);
    }
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
    public Task updateTask(Long id, Task task){
        Task existingTask = taskRepository.findById(id).orElse(null);
        if(existingTask != null){
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setStatus(task.getStatus());
            return taskRepository.save(existingTask);
        }
        return null;
    }

    /*@Transactional*/
    public List<TaskDto> getUserTasks(Long id){
        //getReferenceById(id) è una select con l id
        return taskRepository.findByUserId(id).stream()
                .map(task ->new TaskDto(
                        task.getId(),
                        task.getTitle(),
                        task.getDescription()))
                .collect(Collectors.toList());

    }
}
