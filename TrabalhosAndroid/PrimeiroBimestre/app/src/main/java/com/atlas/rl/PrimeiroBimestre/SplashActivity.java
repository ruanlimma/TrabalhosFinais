package com.atlas.rl.PrimeiroBimestre;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
        public void run() {
       // Esse método será executado sempre que o tempo acabar
       // E inicia a activity principal

                Intent i = new Intent(SplashActivity.this, Splash_logo.class);
                startActivity(i);
                // Fecha esta activity
                           finish();
                       }
        }, SPLASH_TIME_OUT);
    }
}
