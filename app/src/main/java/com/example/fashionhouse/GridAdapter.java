package com.example.fashionhouse;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


public class GridAdapter extends BaseAdapter {
    List clothesList;
    Context context;

    GridAdapter(List clothes, Context cntxt) {
        clothesList = clothes;
        context = cntxt;
    }

    @Override
    public int getCount() {
        return clothesList.size();
    }

    @Override
    public Object getItem(int i) {
        return clothesList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LinearLayout layout;
        if (view == null) {
            layout = new LinearLayout(context);
            layout.setBackgroundResource(R.drawable.rectangle);
            layout.setOrientation(LinearLayout.VERTICAL);

            LinearLayout.LayoutParams imgParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            imgParams.height = 240;
            imgParams.gravity = Gravity.TOP;

            ImageView img = new ImageView(context);
            Clothes currentClothes = (Clothes) clothesList.get(i);
            img.setImageResource(currentClothes.getImgId());
            layout.addView(img, imgParams);

            TextView name = new TextView(context);
            name.setText(currentClothes.getName());
            name.setGravity(Gravity.CENTER);
            layout.addView(name);
        } else {
            layout = (LinearLayout) view;
        }
        layout.setId(i);
        return layout;
    }
}
