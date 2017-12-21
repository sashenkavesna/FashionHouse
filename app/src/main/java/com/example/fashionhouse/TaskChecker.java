package com.example.fashionhouse;


import java.util.List;

public class TaskChecker {
    private Bonus bonus;
    private int coins = 10;
    private int totalCoins = 0;

    TaskChecker(Clothes tasksClothes, List<Clothes> curLook, Bonus bonus) {
        this.bonus = bonus;
        for (Clothes clothe : curLook) {
            Clothes clothes = (Clothes) clothe;
            compareClothesAttributes(tasksClothes.getStyle(), clothes.getStyle());
            compareClothesAttributes(tasksClothes.getColor(), clothes.getColor());
            compareClothesAttributes(tasksClothes.getPrint(), clothes.getPrint());
            compareClothesAttributes(tasksClothes.getTissue(), clothes.getTissue());
        }
    }

    public Bonus getBonus(){
        return bonus;
    }

    private void compareClothesAttributes(String taskAtr, String lookAtr) {
        if (taskAtr != null) {
            if (taskAtr == lookAtr) {
                if (totalCoins > 0) {
                    bonus.addCoins(coins + (coins * 30 / 100));
                } else {
                    bonus.addCoins(coins);
                }
                totalCoins += coins;
            }
        }
    }
}
