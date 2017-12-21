package com.example.fashionhouse;


import android.app.Activity;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

public class CheckBoxListener implements CompoundButton.OnCheckedChangeListener {
    private List<Task> tasks;
    TasksListAdapter adapter;
    LookController lookController;
    TaskController taskController;
    BonusController bonusController;
    Activity context;
    CheckBoxListener(TasksListAdapter adapter){
        this.tasks=adapter.getTasks();
        this.adapter=adapter;
        this.lookController=adapter.getLookController();
        this.taskController=adapter.getTaskController();
        this.bonusController= adapter.getBonusController();
        this.context=adapter.getContext();
    }
    @Override

    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        compoundButton.setChecked(false);
        int itemNum=(Integer)compoundButton.getTag();
        CurrentTasks curTasks=taskController.getTasks();
        Task task=curTasks.getTasks().get(itemNum);
        TaskChecker checker=new TaskChecker(task.getClothes(),lookController.getLook().getLook(), bonusController.getBonus());
        bonusController.setBonus(checker.getBonus());
        TextView text=(TextView)context.findViewById(R.id.coins);
        text.setText(" "+bonusController.getBonus().getCoins());
        tasks.remove(tasks.get(itemNum));
        adapter.notifyDataSetChanged();
    }
}
