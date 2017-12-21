package com.example.fashionhouse;


public class BonusController {
    private Bonus bonus;
    BonusController(){
        bonus=new Bonus();
    }

    public Bonus getBonus() {
        return bonus;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }
}
