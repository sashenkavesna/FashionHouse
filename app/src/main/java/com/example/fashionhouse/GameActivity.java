package com.example.fashionhouse;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.support.constraint.ConstraintLayout;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class GameActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_game);
        overridePendingTransition(0, R.anim.fade_out_anim);

        ConstraintLayout gridLayout = (ConstraintLayout) findViewById(R.id.grid_layout);
        gridLayout.setVisibility(View.INVISIBLE);

        WardrobeController wardController = new WardrobeController();
        LookController lookController = new LookController();
        BonusController bonusController = new BonusController();
        TaskController taskController = new TaskController();
        TasksGenerator generator = new TasksGenerator();

        WardrobeParser parser = new WardrobeParser(this, generator);
        TaskThread taskThread = new TaskThread(generator, taskController);
        parser.execute();

        try {
            wardController.setWardrobe(parser.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        taskThread.execute();

        try {
            taskController.setTasks(taskThread.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        GridAdapter gridAdapter = new GridAdapter(wardController.getWardrobe().getClothesList(), this);
        GridView grid = (GridView) findViewById(R.id.clothesTable);
        grid.setAdapter(gridAdapter);
        GridsItemListener gridListener = new GridsItemListener(this, lookController);
        grid.setOnItemClickListener(gridListener);
        grid.setOnItemLongClickListener(gridListener);

        TasksListAdapter tasksListAdapter = new TasksListAdapter(taskController, this, lookController, bonusController);
        Spinner tasksList = (Spinner) findViewById(R.id.tasksList);
        tasksList.setAdapter(tasksListAdapter);

        TextView coins = (TextView) findViewById(R.id.coins);
        coins.setText(" " + bonusController.getBonus().getCoins());

        //  TasksUpdateService tasksUpdate=new TasksUpdateService(tasks,generator);

        ImageButton but1 = (ImageButton) findViewById(R.id.button_girl1);
        ImageButton but2 = (ImageButton) findViewById(R.id.button_girl2);
        ImageButton but3 = (ImageButton) findViewById(R.id.button_girl3);

        ShowingImageButtonListener butListener = new ShowingImageButtonListener(this);
        but1.setOnClickListener(butListener);
        but2.setOnClickListener(butListener);
        but3.setOnClickListener(butListener);

        SwipeListener swipe = new SwipeListener();
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.activity_game);
        layout.setOnTouchListener(swipe);
    }
}
