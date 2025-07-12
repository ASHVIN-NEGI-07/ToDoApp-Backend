package com.ashvin.todo.to_do_app.controller;

import com.ashvin.todo.to_do_app.entity.Task;
import com.ashvin.todo.to_do_app.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

   @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskRepository.save(task);
   }

   @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id){
        taskRepository.deleteById(id);
   }

   @PutMapping("/{id}")
    public Task updateTask(@PathVariable String id, @RequestBody Task updatedTask){
        Task task = taskRepository.findById(id).orElseThrow();
        task.setCompleted(updatedTask.isCompleted());
        task.setName(updatedTask.getName());
        return taskRepository.save(task);
   }

}
