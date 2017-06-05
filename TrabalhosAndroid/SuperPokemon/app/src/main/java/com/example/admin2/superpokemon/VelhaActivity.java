package com.example.admin2.superpokemon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class VelhaActivity extends AppCompatActivity {

    private static int TOTAL_JOGADAS = 9;
    private Game_jvelha l1, l2, l3, c1, c2, c3, d1, d2;

    //array das imagens
    private ImageButton[] iB = new ImageButton[9];
    private int jogadas;
    private int jogador=0;

    //Nome do Jogador da vez
    private  String[] pl = {"Humano", "Computador"};

    //Criando Array para o endereço das imagens
    private int[] img = {R.drawable.humano, R.drawable.computador};

    //metodo que manipula o evento de clique
    public void clickListener(View view){

        ImageButton b = (ImageButton)view;

        //endereço da imagem e jogador que é int
        b.setImageResource(img[jogador]);

        //Incremetar a serie escolhida do jogador
        Game_jvelha g = ((Games_jvelha) b.getTag()).gamesAddSeries(jogador);

        TextView t = (TextView) findViewById(R.id.tv_jogada);
        t.setText((g != null) ? fimJogo(g.getImageButtons(), jogador): verificarVelha(++jogadas));
    }

    public void clickListenerReiniciar(View v){
        //Atividade - Reiniciar o Jogo
        TOTAL_JOGADAS = 9;
        jogadas = 0;
        jogador=0;
        for(int a=0; a<9;a++){
            iB[a].setImageResource(0);
            iB[a].setEnabled(true);
            iB[a].animate().rotationY(0).setDuration(0);
        }

        l1 = null;
        l2 = null;
        l3 = null;
        c1 = null;
        c2 = null;
        c3 = null;
        d1 = null;
        d2 = null;

        l1 = new Game_jvelha(iB[0],iB[1],iB[2]);
        l2 = new Game_jvelha(iB[3],iB[4],iB[5]);
        l3 = new Game_jvelha(iB[6],iB[7],iB[8]);
        c1 = new Game_jvelha(iB[0],iB[3],iB[6]);
        c2 = new Game_jvelha(iB[1],iB[4],iB[7]);
        c3 = new Game_jvelha(iB[2],iB[5],iB[8]);
        d1 = new Game_jvelha(iB[0],iB[4],iB[8]);
        d2 = new Game_jvelha(iB[2],iB[4],iB[6]);


        //Primeira fila
        iB[0].setTag(new Games_jvelha(l1, c1, d1));
        iB[1].setTag(new Games_jvelha(l1, c2));
        iB[2].setTag(new Games_jvelha(l1, c3, d2));
        //Segunda fila
        iB[3].setTag(new Games_jvelha(l2, c1));
        iB[4].setTag(new Games_jvelha(l2, c2, d1, d2));
        iB[5].setTag(new Games_jvelha(l2, c3));
        //Terceira fila
        iB[6].setTag(new Games_jvelha(l3, c1, d2));
        iB[7].setTag(new Games_jvelha(l3, c2));
        iB[8].setTag(new Games_jvelha(l3, c3, d1));



        TextView t = (TextView) findViewById(R.id.tv_jogada);
        t.setText("");



    }


    private Button btn_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_velha );

        btn_voltar = (Button) findViewById(R.id.btn_voltar2);
        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(VelhaActivity.this, MenuActivity.class);
                startActivity(intent5);
            }
        });

        //lista de botões
        iB[0]= (ImageButton) findViewById(R.id.b0);
        iB[1]= (ImageButton) findViewById(R.id.b1);
        iB[2]= (ImageButton) findViewById(R.id.b2);
        iB[3]= (ImageButton) findViewById(R.id.b3);
        iB[4]= (ImageButton) findViewById(R.id.b4);
        iB[5]= (ImageButton) findViewById(R.id.b5);
        iB[6]= (ImageButton) findViewById(R.id.b6);
        iB[7]= (ImageButton) findViewById(R.id.b7);
        iB[8]= (ImageButton) findViewById(R.id.b8);

        //objeto da lista de possibilidades
        l1 = new Game_jvelha(iB[0], iB[1], iB[2]);
        l2 = new Game_jvelha(iB[3], iB[4], iB[5]);
        l3 = new Game_jvelha(iB[6], iB[7], iB[8]);

        c1 = new Game_jvelha(iB[0], iB[3], iB[6]);
        c2 = new Game_jvelha(iB[1], iB[4], iB[7]);
        c3 = new Game_jvelha(iB[2], iB[5], iB[8]);

        d1 = new Game_jvelha(iB[0], iB[4], iB[8]);
        d2 = new Game_jvelha(iB[2], iB[4], iB[6]);

        //Primeira fila
        iB[0].setTag(new Games_jvelha(l1, c1, d1));
        iB[1].setTag(new Games_jvelha(l1, c2));
        iB[2].setTag(new Games_jvelha(l1, c3, d2));
        //segunda fila
        iB[3].setTag(new Games_jvelha(l2, c1));
        iB[4].setTag(new Games_jvelha(l2, c2, d1, d2));
        iB[5].setTag(new Games_jvelha(l2, c3));
        //terceira fila
        iB[6].setTag(new Games_jvelha(l3, c1, d2));
        iB[7].setTag(new Games_jvelha(l3, c2));
        iB[8].setTag(new Games_jvelha(l3, c3, d1));




    }

    private String fimJogo(List<ImageButton> buttons, int jogador){
        for (ImageButton button : buttons)
            button.animate().rotation(360).setDuration(1000);
        disableButtons();
        return getResources().getString(R.string.vencedor,pl[jogador]);
    }

    private String verificarVelha(int jogadas){
        //muda o jogador
        jogador = (jogador ==0) ? 1:0;
        if (jogadas == TOTAL_JOGADAS)
            disableButtons();
        return (jogadas == TOTAL_JOGADAS) ? "Deu Velha!" : getResources().getString(R.string.jogador,pl[jogador]);
    }

    private void disableButtons() {
        for (int b =0; b<9; b++) iB[b].setEnabled(false);
    }







}

