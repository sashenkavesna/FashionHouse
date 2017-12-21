package com.example.fashionhouse;


public class Bonus {
    private int coins;

    Bonus(){
        coins = 0;
    }

    public void addCoins(int coins) {
        this.coins += coins;
    }

    public int getCoins() {
        return coins;
    }
}
