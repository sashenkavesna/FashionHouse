package com.example.fashionhouse;


import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class CurrentTasks {
    private List<Task> tasks;
    CurrentTasks(){
        tasks=new ArrayList<Task>();
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
