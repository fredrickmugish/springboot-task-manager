package com.example.demo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private boolean completed;

// constructor
    public Task(){

    }

//getter and setters
public  void setId(long id){
    this.id = id;
}
 public long getId(){
     return id;
 }

 public void setTitle(String title){
   this.title = title;
 }

 public String getTitle(){
    return title;
 }

 public void setDescription(String description){
    this.description = description;
 }

 public String getDescription( ){
    return description;
 }

public void setCompleted(boolean completed){
     this.completed = completed;
}

public boolean isCompleted(){
    return completed;
}

}
