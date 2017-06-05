package com.example.admin2.superpokemon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Escolha1Activity extends AppCompatActivity {
    private Button btn_golpe1;
    private Button btn_golpe2;
    private Button btn_golpe3;
    private TextView tv_golpe1;
    private TextView tv_golpe2;
    private TextView tv_golpe3;

    int valor = 0;
    private TextView tv_energia;
    private ImageView poke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_escolha1);

        tv_energia = (TextView) findViewById(R.id.tv_energia);
        tv_golpe1 = (TextView) findViewById(R.id.tv_golpe1);
        tv_golpe2 = (TextView) findViewById(R.id.tv_golpe2);
        tv_golpe3 = (TextView) findViewById(R.id.tv_golpe3);
        poke = (ImageView) findViewById(R.id.poke);
        btn_golpe1 = (Button) findViewById(R.id.btn_golpe1);
        btn_golpe2 = (Button) findViewById(R.id.btn_golpe2);
        btn_golpe3 = (Button) findViewById(R.id.btn_golpe3);

        Intent i = getIntent();
        Bundle escolha = i.getExtras();

        int escolhapoke = (int) escolha.get("poke");

        if(escolhapoke == 1) {

            poke.setImageResource(R.drawable.j1);
            tv_energia.setText(Integer.toString(Score.energia1));
            tv_golpe1.setText("Força do golpe: 25 e Custo do golpe: 30");
            tv_golpe2.setText("Força do golpe: 50 e Custo do golpe: 50");
            tv_golpe3.setText("Força do golpe: 80 e Custo do golpe: 70");
            btn_golpe1.setText("Cabeçada");
            btn_golpe2.setText("Bolhas");
            btn_golpe3.setText("Jato D'água");





            btn_golpe1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Score.energia1 > 29) {
                        valor = 25;
                        Score.energia1 -= 30;

                        String valorTexto = Integer.toString(valor);
                        Intent ir = new Intent(getBaseContext(), JogadaActivity.class);
                        ir.putExtra("valor", valorTexto);
                        ir.putExtra("golpe", btn_golpe1.getText().toString());
                        int poke = 1;
                        ir.putExtra("poke", poke);
                        startActivity(ir);
                    } else {
                        Toast.makeText(getBaseContext(), "ENERGIA INSUFICIENTE", Toast.LENGTH_LONG).show();
                        Intent ir = new Intent(getBaseContext(), MenuActivity.class);
                        startActivity(ir);
                    }
                }
            });


            btn_golpe2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Score.energia1 > 49) {
                        valor = 50;
                        Score.energia1 -= 50;

                        String valorTexto = Integer.toString(valor);
                        Intent ir = new Intent(getBaseContext(), JogadaActivity.class);
                        ir.putExtra("valor", valorTexto);
                        ir.putExtra("golpe", btn_golpe2.getText().toString());
                        int poke = 1;
                        ir.putExtra("poke", poke);
                        startActivity(ir);
                    } else {
                        Toast.makeText(getBaseContext(), "ENERGIA INSUFICIENTE", Toast.LENGTH_LONG).show();
                        Intent ir = new Intent(getBaseContext(), MenuActivity.class);
                        startActivity(ir);
                    }
                }
            });


            btn_golpe3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Score.energia1 > 69) {
                        valor = 80;
                        Score.energia1 -= 70;

                        String valorTexto = Integer.toString(valor);
                        Intent ir = new Intent(getBaseContext(), JogadaActivity.class);
                        ir.putExtra("valor", valorTexto);
                        ir.putExtra("golpe", btn_golpe3.getText().toString());
                        int poke = 1;
                        ir.putExtra("poke", poke);
                        startActivity(ir);
                    } else {
                        Toast.makeText(getBaseContext(), "ENERGIA INSUFICIENTE", Toast.LENGTH_LONG).show();
                        Intent ir = new Intent(getBaseContext(), MenuActivity.class);
                        startActivity(ir);
                    }
                }
            });

        }else if(escolhapoke == 2) {

            poke.setImageResource(R.drawable.j2);
            tv_energia.setText(Integer.toString(Score.energia2));
            tv_golpe1.setText("Força do golpe: 25 e Custo do golpe: 35");
            tv_golpe2.setText("Força do golpe: 45 e Custo do golpe: 50");
            tv_golpe3.setText("Força do golpe: 90 e Custo do golpe: 85");
            btn_golpe1.setText("Garras");
            btn_golpe2.setText("Brasas");
            btn_golpe3.setText("Lança-Chamas");


            btn_golpe1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Score.energia2 > 34) {
                        valor = 25;
                        Score.energia2 -= 35;

                        String valorTexto = Integer.toString(valor);

                        Intent ir = new Intent(getBaseContext(), JogadaActivity.class);
                        ir.putExtra("valor", valorTexto);
                        ir.putExtra("golpe", btn_golpe1.getText().toString());
                        int poke = 2;
                        ir.putExtra("poke", poke);
                        startActivity(ir);
                    }else{
                        Toast.makeText(getBaseContext(),"ENERGIA INSUFICIENTE",Toast.LENGTH_LONG).show();
                        Intent ir = new Intent(getBaseContext(), MenuActivity.class);
                        startActivity(ir);
                    }
                }
            });


            btn_golpe2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Score.energia2 > 49) {
                        valor = 45;
                        Score.energia2 -= 50;
                        String valorTexto = Integer.toString(valor);
                        Intent ir = new Intent(getBaseContext(), JogadaActivity.class);
                        ir.putExtra("valor", valorTexto);
                        ir.putExtra("golpe", btn_golpe2.getText().toString());
                        int poke = 2;
                        ir.putExtra("poke", poke);
                        startActivity(ir);
                    }else{
                        Toast.makeText(getBaseContext(),"ENERGIA INSUFICIENTE",Toast.LENGTH_LONG).show();
                        Intent ir = new Intent(getBaseContext(), MenuActivity.class);
                        startActivity(ir);
                    }
                }
            });


            btn_golpe3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Score.energia2 > 84) {
                        valor = 90;
                        Score.energia2 -= 85;
                        String valorTexto = Integer.toString(valor);
                        Intent ir = new Intent(getBaseContext(), JogadaActivity.class);
                        ir.putExtra("valor", valorTexto);
                        ir.putExtra("golpe", btn_golpe3.getText().toString());
                        int poke = 2;
                        ir.putExtra("poke", poke);
                        startActivity(ir);
                    }else{
                        Toast.makeText(getBaseContext(),"ENERGIA INSUFICIENTE",Toast.LENGTH_LONG).show();
                        Intent ir = new Intent(getBaseContext(), MenuActivity.class);
                        startActivity(ir);
                    }
                }
            });


        }else if(escolhapoke == 3) {

            poke.setImageResource(R.drawable.j3);
            tv_energia.setText(Integer.toString(Score.energia3));
            tv_golpe1.setText("Força do golpe: 20 e Custo do golpe: 30");
            tv_golpe2.setText("Força do golpe: 45 e Custo do golpe: 60");
            tv_golpe3.setText("Força do golpe: 100 e Custo do golpe: 100");
            btn_golpe1.setText("Chicote de Vinha");
            btn_golpe2.setText("Folha Navalha");
            btn_golpe3.setText("Raio Solar");

            btn_golpe1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Score.energia3 > 29) {
                        valor = 20;
                        Score.energia3 -= 30;

                        String valorTexto = Integer.toString(valor);
                        Intent ir = new Intent(getBaseContext(), JogadaActivity.class);
                        ir.putExtra("valor", valorTexto);
                        ir.putExtra("golpe", btn_golpe1.getText().toString());
                        int poke = 3;
                        ir.putExtra("poke", poke);
                        startActivity(ir);
                    } else {
                        Toast.makeText(getBaseContext(), "ENERGIA INSUFICIENTE", Toast.LENGTH_LONG).show();
                        Intent ir = new Intent(getBaseContext(), MenuActivity.class);
                        startActivity(ir);
                    }
                }
            });


            btn_golpe2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Score.energia3 > 59) {
                        valor = 45;
                        Score.energia3 -= 60;

                        String valorTexto = Integer.toString(valor);
                        Intent ir = new Intent(getBaseContext(), JogadaActivity.class);
                        ir.putExtra("valor", valorTexto);
                        ir.putExtra("golpe", btn_golpe2.getText().toString());
                        int poke = 3;
                        ir.putExtra("poke", poke);
                        startActivity(ir);
                    } else {
                        Toast.makeText(getBaseContext(), "ENERGIA INSUFICIENTE", Toast.LENGTH_LONG).show();
                        Intent ir = new Intent(getBaseContext(), MenuActivity.class);
                        startActivity(ir);
                    }
                }
            });

            btn_golpe3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Score.energia3 > 99) {
                        valor = 100;
                        Score.energia3 -= 100;

                        String valorTexto = Integer.toString(valor);
                        Intent ir = new Intent(getBaseContext(), JogadaActivity.class);
                        ir.putExtra("valor", valorTexto);
                        ir.putExtra("golpe", btn_golpe3.getText().toString());
                        int poke = 3;
                        ir.putExtra("poke", poke);
                        startActivity(ir);
                    } else {
                        Toast.makeText(getBaseContext(), "ENERGIA INSUFICIENTE", Toast.LENGTH_LONG).show();
                        Intent ir = new Intent(getBaseContext(), MenuActivity.class);
                        startActivity(ir);
                    }
                }
            });

        }
    }
}
