package com.example.fashionhouse;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import static android.support.constraint.R.id.parent;


public class TasksListAdapter extends BaseAdapter {
    private List<Task> tasks;
    private Activity context;
    private LayoutInflater inflater;
    private LookController lookController;
    private TaskController taskController;
    private BonusController bonusController;

    TasksListAdapter(TaskController taskController, Activity context, LookController lookController, BonusController bonusController) {
        this.taskController = taskController;
        this.tasks = taskController.getTasks().getTasks();
        this.lookController = lookController;
        this.bonusController = bonusController;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public BonusController getBonusController() {
        return bonusController;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public LookController getLookController() {
        return lookController;
    }

    public TaskController getTaskController() {
        return taskController;
    }

    public Activity getContext() {
        return context;
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int i) {
        return tasks.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.tasks_item, viewGroup, false);
        }
        Task task = tasks.get(i);
        TextView name = (TextView) view.findViewById(R.id.task_name);
        name.setText(" " + task.getClient());
        TextView taskText = (TextView) view.findViewById(R.id.task);
        taskText.setText(task.getTaskText());
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkBox);
        checkBox.setTag(i);
        CheckBoxListener checkBoxListener = new CheckBoxListener(this);
        checkBox.setOnCheckedChangeListener(checkBoxListener);
        return view;
    }
}
