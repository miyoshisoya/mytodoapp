package com.example.demo.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Todo {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String deadline;
    public String isDone;

    
    public Todo (){
        isDone = "No";
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getDone() {
        return isDone;
    }

    public void setDone(){
        this.isDone = "Yes";
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", name=" + name + ", deadline=" + deadline + ", isDone=" + isDone + "]";
    }
}

