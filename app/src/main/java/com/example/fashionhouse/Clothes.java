package com.example.fashionhouse;

import android.content.Context;
import android.util.Log;

public class Clothes {
     // private enum String{
      //   shoes, top, all, bottom
    // }
    private String name;
    private String type;
    private String tissue;
    private String color;
    private String print;
    private String style;
    private int imgId;
    private Context context;

    public void setContext(Context context) {
        this.context=context;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(String imgName) {
        imgId = context.getResources().getIdentifier(imgName, "drawable", context.getPackageName());
    }

    public void setStyle(String sty) {
        style = sty;
    }

    public String getStyle() {
        return style;
    }

    public String getTissue() {
        return tissue;
    }

    public String getColor() {
        return color;
    }

    public String getPrint() {
        return print;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String nme) {
        name = nme;
    }

    public void setType(String tpe) {
        type = tpe;
    }

    public void setTissue(String tssue) {
        tissue = tssue;
    }

    public void setColor(String clr) {
        color = clr;
    }

    public void setPrint(String prnt) {
        print = prnt;
    }

}
