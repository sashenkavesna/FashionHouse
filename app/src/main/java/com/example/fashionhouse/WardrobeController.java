package com.example.fashionhouse;

public class WardrobeController {
    Wardrobe wardrobe;

    WardrobeController() {
        wardrobe = new Wardrobe();
    }

    public void setWardrobe(Wardrobe wrdrb) {
        wardrobe = wrdrb;
    }

    public Wardrobe getWardrobe() {
        return wardrobe;
    }
}
