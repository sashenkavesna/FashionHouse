package com.example.fashionhouse;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александра on 28.09.2016.
 */


public class ShowingImageButtonListener implements View.OnClickListener {
    Activity context;
    ImageView girl;

    //show

    ShowingImageButtonListener(Activity con) {
        context = con;
        girl = new ImageView(context);
    }

    @Override
    public void onClick(View view) {
        if (girl.getVisibility() == View.VISIBLE) {
            girl.setVisibility(View.INVISIBLE);
        }
        switch (view.getId()) {
            case R.id.button_girl1:
                girl = (ImageView) context.findViewById(R.id.image_girl1);
                break;
            case R.id.button_girl2:
                girl = (ImageView) context.findViewById(R.id.image_girl2);
                break;
            case R.id.button_girl3:
                girl = (ImageView) context.findViewById(R.id.image_girl3);
                break;
        }
        girl.setVisibility(View.VISIBLE);
    }

}
