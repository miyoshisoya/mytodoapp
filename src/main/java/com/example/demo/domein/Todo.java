package com.example.demo.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // ①
public class Todo {
    @Id // ②
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ③
    private Long id;
    private String name;

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

    @Override
    public String toString() {
        return "Player [id=" + id + ", name=" + name +  "]";
    }
}

