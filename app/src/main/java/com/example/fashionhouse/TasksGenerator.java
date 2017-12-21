package com.example.fashionhouse;


import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class TasksGenerator {
    private Task task;
    private List<String> colors;
    private List<String> prints;
    private List<String> tissuesMaterial;
    private List<String> styles;
    private List<String> clients;
    private List<String> occasions;
    String taskText = "Hello! I need a fashion look for ";

    TasksGenerator() {
        colors = new ArrayList<String>();
        prints = new ArrayList<String>();
        tissuesMaterial = new ArrayList<String>();
        styles = new ArrayList<String>();
        clients = new ArrayList<String>();
        occasions = new ArrayList<String>();
        addClient();
        addOccasion();
    }

   /* public void addClients(String client){
        clients.add(client);
    }*/

    public void addColors(String color) {
        colors.add(color);
    }

    public void addPrints(String print) {
        prints.add(print);
    }

    public void addTissue(String tissue) {
        tissuesMaterial.add(tissue);
    }

    public void addStyle(String style) {
        styles.add(style);
    }

    private void addClient() {
        clients.add("Maria");
        clients.add("Katya");
        clients.add("Lena");
    }

    private void addOccasion() {
        occasions.add("date with new boyfrend");
        occasions.add("going out with friends");
        occasions.add("shopping at mall");
        occasions.add("going at party");
    }

    public Task generateTask() {
        int clientNum = (int) (Math.random() * clients.size());
        task = new Task(clients.get(clientNum));
        int styleNum = (int) (Math.random() * styles.size());
        task.getClothes().setStyle(styles.get(styleNum));
        int occasionNum = (int) (Math.random() * occasions.size());
        String taskText = "Hello!I need a fashion look for ";
        taskText = taskText.concat(occasions.get(occasionNum) + ". ");
        taskText = taskText.concat("I prefer " + styles.get(styleNum) + "." + " I would like clothes to be ");
        if (!styles.get(styleNum).equals("dress")) {
            for (int i = 0; i < 2; i++) {
                generateTissue();
            }
        }
        task.setTaskText(taskText);
        taskText = "";
        return task;
    }

    private void generateTissue() {
        int num = (int) (Math.random() * 3);
        switch (num) {
            case 0:
                int colorNum = (int) (Math.random() * colors.size());
                task.getClothes().setColor(colors.get(colorNum));
                taskText = taskText.concat(colors.get(colorNum) + " ");
                break;
            case 1:
                int printNum = (int) (Math.random() * prints.size());
                task.getClothes().setPrint(prints.get(printNum));
                taskText = taskText.concat(prints.get(printNum) + " ");
                break;
            case 2:
                int materialNum = (int) (Math.random() * tissuesMaterial.size());
                task.getClothes().setTissue(tissuesMaterial.get(materialNum));
                taskText = taskText.concat(tissuesMaterial.get(materialNum) + " ");
                break;
        }
    }

}
