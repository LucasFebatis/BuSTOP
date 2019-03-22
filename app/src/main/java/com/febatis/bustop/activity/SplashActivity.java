package com.febatis.bustop.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.febatis.bustop.R;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Timer da splash screen
        int SPLASH_TIME_OUT = 3000;
        new Handler().postDelayed(new Runnable() {
            /*
             * Exibindo splash com um timer.
             */
            @Override
            public void run() {
                // Esse método será executado sempre que o timer acabar
                // E inicia a activity principal
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);

                // Fecha esta activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
