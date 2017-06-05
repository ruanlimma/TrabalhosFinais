package com.example.admin2.superpokemon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity{
    private Button btn_selecionar1;
    private Button btn_selecionar2;
    private Button btn_selecionar3;
    private TextView tv_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_menu);

        btn_selecionar1 = (Button) findViewById(R.id.btn_selecionar1);
        btn_selecionar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Score.energia3 > 69){
                    Score.energia3 = 100;
                }else {
                    Score.energia3 += 30;
                }

                if (Score.energia2 > 69){
                    Score.energia2 = 100;
                }else {
                    Score.energia2 += 30;
                }

                Intent selecionar1 = new Intent(getBaseContext(), Escolha1Activity.class);
                int poke = 1;
                selecionar1.putExtra("poke", poke);
                startActivity(selecionar1);
            }
        });

        btn_selecionar2 = (Button) findViewById(R.id.btn_selecionar2);
        btn_selecionar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Score.energia3 > 69){
                    Score.energia3 = 100;
                }else {
                    Score.energia3 += 30;
                }

                if (Score.energia1 > 69){
                    Score.energia1 = 100;
                }else {
                    Score.energia1 += 30;
                }
                Intent selecionar1 = new Intent(getBaseContext(), Escolha1Activity.class);
                int poke = 2;
                selecionar1.putExtra("poke", poke);
                startActivity(selecionar1);
            }
        });

        btn_selecionar3 = (Button) findViewById(R.id.btn_selecionar3);
        btn_selecionar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Score.energia1 > 69){
                    Score.energia1 = 100;
                }else {
                    Score.energia1 += 30;
                }

                if (Score.energia2 > 69){
                    Score.energia2 = 100;
                }else {
                    Score.energia2 += 30;
                }


                Intent selecionar1 = new Intent(getBaseContext(), Escolha1Activity.class);
                int poke = 3;
                selecionar1.putExtra("poke", poke);
                startActivity(selecionar1);
            }
        });

        tv_score = (TextView) findViewById(R.id.tv_score);
        tv_score.setText(Integer.toString(Score.score));

    }
}
