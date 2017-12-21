package com.example.fashionhouse;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class GridsItemListener implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    Activity context;
    ImageView img1;
    ImageView img2;
    ImageView img3;
    Clothes previousClothes;
    LookController lookController;
    Look look;
    private static final String TAG = "Log";
    //метод showClothes!!!

    GridsItemListener(Activity cntxt,LookController lookController) {
        context = cntxt;
        look=new Look();
        this.lookController=lookController;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //   if (context.findViewById(R.id.grid_layout).isFocusable()) {
        ConstraintLayout layout = (ConstraintLayout) context.findViewById(R.id.activity_game);
        Clothes clothes = (Clothes) adapterView.getItemAtPosition(i);
        look.addClothes(clothes);
        lookController.setLook(look);


        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(168, 400);
        params.rightToRight = R.id.image_girl1;
        params.leftToLeft = R.id.image_girl1;
        params.topToTop = R.id.image_girl1;
        if (!clothes.getType().equals("bottom")) {
            params.leftMargin = 17;
            if (clothes.getType().equals("top")) {
                params.topMargin = 5;
            } else if (clothes.getType().equals("all")) {
                params.topMargin = 102;
            } else if (clothes.getType().equals("shoes")) {
                params.topMargin = 450; // проверить!
            }
        } else {
            params.leftMargin = 3;
            params.topMargin = 230;
        }

        if (look.getLatestClothes().getType().equals("all") || look.getLatestClothes().getType().equals("top")) {
            if (look.getLatestClothes().getType().equals("all")) {
                if (img2 != null) {
                    img2.setVisibility(View.INVISIBLE);
                }
            }
            if (img1 != null) {
                img1.setVisibility(View.INVISIBLE);
            }
            img1 = new ImageView(context);
            img1.setImageResource(look.getLatestClothes().getImgId());
            layout.addView(img1, params);
        } else if (look.getLatestClothes().getType().equals("bottom") ) {
            if(look.getPreviousClothes()!=null && look.getPreviousClothes().getType().equals("all")){
                    img1.setVisibility(View.INVISIBLE);
            }
            if (img2 != null) {
                img2.setVisibility(View.INVISIBLE);
            }
            img2 = new ImageView(context);
            img2.setImageResource(look.getLatestClothes().getImgId());
            layout.addView(img2, params);
        } else {
            if (img3 != null) {
                img3.setVisibility(View.INVISIBLE);
            }
            img3 = new ImageView(context);
            img3.setImageResource(look.getLatestClothes().getImgId());
            layout.addView(img3, params);
        }
        view.setBackgroundResource(R.drawable.rectangle);
        previousClothes = look.getLatestClothes();

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        Clothes clothes = (Clothes) adapterView.getItemAtPosition(i);
        TextView info = (TextView) context.findViewById(R.id.info);
        info.setText(" color: " + clothes.getColor() + "\n print: " + clothes.getPrint() + "\n tissue: " + clothes.getTissue());
        view.setBackgroundResource(R.drawable.black_rectangle);
        return false;
    }
}
