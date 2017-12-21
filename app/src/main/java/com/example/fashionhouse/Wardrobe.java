package com.example.fashionhouse;


import com.example.fashionhouse.Clothes;

import java.util.ArrayList;
import java.util.List;

public class Wardrobe {
    private List<Clothes> clothesList;

    Wardrobe() {
        clothesList = new ArrayList<Clothes>();
    }

    public void addClothes(Clothes cloth) {
        clothesList.add(cloth);
    }

    public List getClothesList() {
        return clothesList;
    }
}