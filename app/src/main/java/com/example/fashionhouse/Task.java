package com.example.fashionhouse;


import android.app.Activity;

import java.util.List;

public class Task {
    private Clothes clothes;
    private String client;
    private String taskText;

    Task(String clnt) {
        client = clnt;
        clothes = new Clothes();
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public String getTaskText() {
        return taskText;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public String getClient() {
        return client;
    }
}
