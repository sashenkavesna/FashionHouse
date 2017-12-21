package com.example.fashionhouse;


public class LookController {
    private Look look;
    LookController(){
        look=new Look();
    }

    public void setLook(Look look) {
        this.look = look;
    }

    public Look getLook() {
        return look;
    }
}
