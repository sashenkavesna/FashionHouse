package com.example.fashionhouse;

import android.support.constraint.ConstraintLayout;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.GridView;

import com.example.fashionhouse.R;

import java.util.ArrayList;
import java.util.List;


public class SwipeListener implements View.OnTouchListener {
    float x; // МЕТОДЫ ОТКРЫТИЯ И ЗАКРЫТИЯ ШКАФА

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GridView grid = (GridView) view.findViewById(R.id.clothesTable);
        ConstraintLayout layout = (ConstraintLayout) view.findViewById(R.id.grid_layout);

        if (motionEvent.getAction() == motionEvent.ACTION_DOWN) {
            x = motionEvent.getX();
        }
        if (motionEvent.getAction() == motionEvent.ACTION_MOVE) {

            if (motionEvent.getX() < x) {
                TranslateAnimation anim = new TranslateAnimation(1200, 0, 0, 0);
                anim.setDuration(200);
                anim.setFillAfter(true);
                layout.startAnimation(anim);

            } else if (motionEvent.getX() > x) {
                TranslateAnimation anim = new TranslateAnimation(0, 1200, 0, 0);
                anim.setDuration(200);
                anim.setFillAfter(true);
                layout.startAnimation(anim);
            }

        }
        return true;
    }

}
