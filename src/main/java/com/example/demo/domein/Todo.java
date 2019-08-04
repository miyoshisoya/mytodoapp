package com.example.demo.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


@Entity // ①
public class Todo {
    @Id // ②
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ③
    private Long id;
    private String name;
    private String deadline;

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

    @Override
    public String toString() {
        return "Todo [id=" + id + ", name=" + name + ", deadline=" + deadline + "]";
    }
}

