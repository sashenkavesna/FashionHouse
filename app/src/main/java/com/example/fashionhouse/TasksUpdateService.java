package com.example.fashionhouse;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TasksUpdateService extends Service {
    private CurrentTasks tasks;
    private TasksGenerator generator;
    public TasksUpdateService(){}
    public TasksUpdateService(CurrentTasks tasks,TasksGenerator generator) {
        this.tasks=tasks;
        this.generator=generator;
    }
    public void onCreate(){
        super.onCreate();
    }
    public int onStartCommand(Intent intent,int flags,int startId){
        Timer timer=new Timer();
        TimerTask timerTask= new TimerTask() {
            @Override
            public void run() {
                tasks=new CurrentTasks();
                for(int iter=0;iter<4;iter++) {
                    tasks.addTask(generator.generateTask());
                }
            }

        };
        timer.schedule(timerTask,10000,10000);
        return super.onStartCommand(intent, flags, startId);
    }
    public void onDestroy(){
        super.onDestroy();
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }



}
