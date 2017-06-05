package com.example.admin2.superpokemon;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class JogadaActivity extends AppCompatActivity {
    private TextView tv_valor;
    private TextView tv_golpe;
    private ImageView iv_computador;
    private TextView tv_velocidade_computador;
    private ImageView poke;

    private static int TEMPO = 6000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_jogada);
        tv_valor = (TextView) findViewById(R.id.tv_valor);
        tv_golpe = (TextView) findViewById(R.id.tv_golpe);
        iv_computador = (ImageView) findViewById(R.id.iv_computador);
        tv_velocidade_computador = (TextView) findViewById(R.id.tv_velocidade_computador);
        poke = (ImageView) findViewById(R.id.poke);

        //
        Intent i = getIntent();
        Bundle valor = i.getExtras();

        String getValor = (String) valor.get("valor");
        int valorJogador = Integer.valueOf(getValor);
        tv_valor.setText(getValor);

        String getGolpe = (String) valor.get("golpe");
        tv_golpe.setText(getGolpe);

        int escolhapoke = (int) valor.get("poke");

        if(escolhapoke == 1){
            poke.setImageResource(R.drawable.j1);
        }else if(escolhapoke == 2){
            poke.setImageResource(R.drawable.j2);
        }else if(escolhapoke == 3) {
            poke.setImageResource(R.drawable.j3);
        }

        int escolhaComputador = (int) (Math.random()*100)+1;
        int personagemComputador = (int) (Math.random()*4)+1;

        if(personagemComputador == 1){
            iv_computador.setImageResource(R.drawable.c1);
        }else if(personagemComputador == 2){
            iv_computador.setImageResource(R.drawable.c2);
        }else if(personagemComputador == 3) {
            iv_computador.setImageResource(R.drawable.c3);
        }else if(personagemComputador == 4) {
            iv_computador.setImageResource(R.drawable.c4);
        }

        tv_velocidade_computador.setText(Integer.toString(escolhaComputador));

        if(escolhaComputador == valorJogador){
            Toast.makeText(getBaseContext(),
                    "EMPATE",Toast.LENGTH_LONG).show();
        }else if(escolhaComputador < valorJogador){
            Toast.makeText(getBaseContext(),
                    "JOGADOR GANHOU",Toast.LENGTH_LONG).show();
                    Score.score += 500;
        }else{
            Toast.makeText(getBaseContext(),
                    "JOGADOR PERDEU",Toast.LENGTH_LONG).show();
                    Score.score -= 250;
        }

        if (Score.score > 0 && Score.score < 3000){

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(getBaseContext(), MenuActivity.class);
                    startActivity(i);
                    finish();
                }
            },TEMPO);

        }else if (Score.score >= 3000){

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(getBaseContext(), GanhouActivity.class);
                    startActivity(i);
                    finish();
                }
            },TEMPO);

        }else if (Score.score <= 0){

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(getBaseContext(), PerdeuActivity.class);
                    startActivity(i);
                    finish();
                }
            },TEMPO);

        }

    }
}
