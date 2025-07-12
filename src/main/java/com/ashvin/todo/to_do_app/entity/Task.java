package com.ashvin.todo.to_do_app.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public class Task {

    @Id
    private String id;
    private String name;
    private boolean completed;

    // CONSTRUCTORS

    public Task(){}

    public Task(String name,boolean completed) {
        this.name = name;
        this.completed = completed;
    }

    // GETTERS AND SETTERS
     public String getId() {
        return id;
     }

     public void setId(String id) {
        this.id = id;
     }

     public String getName() {
        return name;
     }

     public void setName(String name) {
        this.name = name;
     }

     public boolean isCompleted() {
        return completed;
     }

     public void setCompleted(boolean completed) {
        this.completed = completed;
     }

}

