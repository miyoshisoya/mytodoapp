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
    private String body;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String name) {
        this.body = name;
    }

    @Override
    public String toString() {
        return "Player [id=" + id + ", body=" + body +  "]";
    }
}

