package com.example.fashionhouse;

import com.example.fashionhouse.Clothes;

import java.util.ArrayList;
import java.util.List;

public class Look {
    private List<Clothes> look;

    Look() {
        look = new ArrayList<Clothes>();
    }

    public void addClothes(Clothes cloth) {
        if (!look.isEmpty()) {
            compare(cloth);
        }
        look.add(cloth);
    }

    public Clothes getLatestClothes() {
        return look.get(look.size() - 1);
    }

    public Clothes getPreviousClothes() {
        if (look.size() < 2) {
            return null;
        }
        return look.get(look.size() - 2);
    }

    public List<Clothes> getLook() {
        return look;
    }

    protected void compare(Clothes newClothes) {
        for (Clothes clothe : look) {
            Clothes clothes = (Clothes) clothe;
            if (clothes.getType().equals(newClothes.getType())) {
                look.remove(clothes);
                break;
            } else if (!clothes.getType().equals("shoes")) {
                    if ((clothes.getType().equals("top") && newClothes.getType().equals("all")) ||
                        (clothes.getType().equals("bottom") && newClothes.getType().equals("all")) ||
                        (clothes.getType().equals("all"))) {
                    look.remove(clothes);
                    break;
                }
            }
        }
    }
}