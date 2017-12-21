package com.example.fashionhouse;

import android.os.AsyncTask;

public class TaskThread extends AsyncTask<Void, Void, CurrentTasks> {
    private CurrentTasks curTasks;
    private TasksGenerator generator;
private TaskController taskController;
    TaskThread (TasksGenerator generator,TaskController taskController){
        curTasks=new CurrentTasks();
        this.generator=generator;
        this.taskController=taskController;
    }

    @Override
    protected CurrentTasks doInBackground(Void... voids) {
        for(int iter=0;iter<4;iter++) {;
            curTasks.addTask(generator.generateTask());
            taskController.setTasks(curTasks);
        }
        return curTasks;
    }
}