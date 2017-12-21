package com.example.fashionhouse;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.os.Bundle;


public class LogoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_logo);
        overridePendingTransition(0, R.anim.fade_in_anim);

        // new Handler().postDelayed(new Runnable() {
        // @Override
        // public void run() {
        Intent intent = new Intent(LogoActivity.this, GameActivity.class);
        startActivity(intent);
        finish();
        //     }
        //   }, 3000);
    }

}
