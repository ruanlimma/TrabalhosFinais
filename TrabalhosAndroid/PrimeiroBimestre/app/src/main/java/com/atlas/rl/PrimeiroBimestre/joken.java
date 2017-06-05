package com.atlas.rl.PrimeiroBimestre;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class joken extends AppCompatActivity {

    public Button btn_pedra;
    public Button btn_papel;
    public Button btn_tesoura;
    public ImageView img_jogador;
    public ImageView img_computador;
    public TextView tv_jogador;
    public TextView tv_computador;
    int placarJogador =0;
    int placarComputador =0;

    private Button btn_voltar;
    private TextView tv_jogador3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_play);

        btn_papel = (Button) findViewById(R.id.btn_papel);
        btn_pedra = (Button) findViewById(R.id.btn_pedra);
        btn_tesoura = (Button) findViewById(R.id.btn_tesoura);
        img_jogador = (ImageView) findViewById(R.id.img_jogador);
        img_computador = (ImageView) findViewById(R.id.img_computador);
        tv_jogador = (TextView) findViewById(R.id.tv_jogador);
        tv_computador = (TextView) findViewById(R.id.tv_computador);



        tv_jogador3 = (TextView) findViewById(R.id.tv_jogador3);
        Intent intent = getIntent();
        Bundle mensagem = intent.getExtras();
        if (mensagem != null) {
            String getTarefa = (String) mensagem.get("teste");
            tv_jogador3.setText(getTarefa);
        }

        btn_voltar = (Button) findViewById(R.id.btn_voltar3);
        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(joken.this, Jogar.class);
                startActivity(intent5);
            }
        });


        btn_pedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int escolhaComputador = (int) (Math.random()*3)+ 1;
                img_jogador.setImageResource(R.drawable.pedra);

                if (escolhaComputador ==1){
                    //Escolhemos a imagem como pedra
                    img_computador.setImageResource(R.drawable.pedra);
                    //Mensagem pro jogador
                    Toast.makeText(getBaseContext(),"Empate",Toast.LENGTH_SHORT).show();

                }if (escolhaComputador ==2){
                    //Escolhemos a imagem como papel
                    img_computador.setImageResource(R.drawable.papel);
                    //Mensagem pro jogador
                    Toast.makeText(getBaseContext(),"Computador Ganhou",Toast.LENGTH_SHORT).show();
                    //Atualizar placar
                    placarComputador++;
                    tv_computador.setText(String.valueOf(placarComputador));

                }if (escolhaComputador ==3){
                    //Escolhemos a imagem como tesoura
                    img_computador.setImageResource(R.drawable.tesoura);
                    //Mensagem pro jogador
                    Toast.makeText(getBaseContext(),"Jogador Ganhou",Toast.LENGTH_SHORT).show();
                    //Atualizar placar
                    placarJogador++;
                    tv_jogador.setText(String.valueOf(placarJogador));
                }
            }
        });
        btn_papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int escolhaComputador = (int) (Math.random()*3)+ 1;
                img_jogador.setImageResource(R.drawable.papel);

                if (escolhaComputador ==1){
                    //Escolhemos a imagem do jogador como pedra
                    img_computador.setImageResource(R.drawable.pedra);
                    //Mensagem pro jogador
                    Toast.makeText(getBaseContext(),"Jogador Ganhou",Toast.LENGTH_SHORT).show();

                    placarJogador++;
                    tv_jogador.setText(String.valueOf(placarJogador));

                }if (escolhaComputador ==2){
                    //Escolhemos a imagem do jogador como papel
                    img_computador.setImageResource(R.drawable.papel);
                    //Mensagem pro jogador
                    Toast.makeText(getBaseContext(),"Empate",Toast.LENGTH_SHORT).show();
                    //Atualizar placar


                }if (escolhaComputador ==3){
                    //Escolhemos a imagem do jogador como tesoura
                    img_computador.setImageResource(R.drawable.tesoura);
                    //Mensagem pro jogador
                    Toast.makeText(getBaseContext(),"Computador Ganhou",Toast.LENGTH_SHORT).show();
                    //Atualizar placar

                    placarComputador++;
                    tv_computador.setText(String.valueOf(placarComputador));
                }
            }
        });
        btn_tesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int escolhaComputador = (int) (Math.random()*3)+ 1;
                img_jogador.setImageResource(R.drawable.tesoura);

                if (escolhaComputador ==1){
                    //Escolhemos a imagem do jogador como pedra
                    img_computador.setImageResource(R.drawable.pedra);
                    //Mensagem pro jogador
                    Toast.makeText(getBaseContext(),"Computador Ganhou",Toast.LENGTH_SHORT).show();

                    placarComputador++;
                    tv_computador.setText(String.valueOf(placarComputador));

                }if (escolhaComputador ==2){
                    //Escolhemos a imagem do jogador como papel
                    img_computador.setImageResource(R.drawable.papel);
                    //Mensagem pro jogador
                    Toast.makeText(getBaseContext(),"Jogador Ganhou",Toast.LENGTH_SHORT).show();
                    //Atualizar placar
                    placarJogador++;
                    tv_jogador.setText(String.valueOf(placarJogador));

                }if (escolhaComputador ==3){
                    //Escolhemos a imagem do jogador como tesoura
                    img_computador.setImageResource(R.drawable.tesoura);
                    //Mensagem pro jogador
                    Toast.makeText(getBaseContext(),"Empate",Toast.LENGTH_SHORT).show();
                    //Atualizar placar

                }
            }
        });
    }
}
