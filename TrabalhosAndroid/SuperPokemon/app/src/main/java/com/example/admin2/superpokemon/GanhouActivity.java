package com.example.admin2.superpokemon;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GanhouActivity extends AppCompatActivity {
    private static int TEMPO = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_ganhou);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent ir = new Intent(getBaseContext(), VelhaActivity.class);
                Score.score = 1000;
                Score.energia1 = 100;
                Score.energia2 = 100;
                Score.energia3 = 100;
                startActivity(ir);
                finish();
            }
        },TEMPO);

    }
}
