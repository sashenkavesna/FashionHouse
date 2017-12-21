package com.example.fashionhouse;


public class TaskController {
    CurrentTasks tasks;

    TaskController() {
        tasks = new CurrentTasks();
    }

    public void setTasks(CurrentTasks tasks) {
        this.tasks = tasks;
    }

    public CurrentTasks getTasks() {
        return tasks;
    }
}
