package com.ashvin.todo.to_do_app.repository;

import com.ashvin.todo.to_do_app.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {

}
