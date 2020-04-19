package com.example.milkman.Utils;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.milkman.Activity.MainActivity;
import com.example.milkman.Activity.MultiplePermissions;
import com.example.milkman.Activity.navigation;
import com.example.milkman.R;

public class Splash_Screen extends AppCompatActivity {
    SharedPreferences sp;
    private static int SPLASH_SCREEN_TIME_OUT = 3000;
    ImageView splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //This is used to cover entire screen
        sp=getSharedPreferences("login",MODE_PRIVATE);

        setContentView(R.layout.activity_splash__screen);
        startAnimations();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sp.getBoolean("logged", false)) {
                    startActivity(new Intent(getApplicationContext(), navigation.class));
                    finish();
                } else {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, SPLASH_SCREEN_TIME_OUT);

    }

    private void startAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        splash = findViewById(R.id.splash_image);
        splash.clearAnimation();
        splash.startAnimation(anim);
    }
}
