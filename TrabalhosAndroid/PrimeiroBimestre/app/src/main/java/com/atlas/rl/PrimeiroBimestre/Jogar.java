package com.atlas.rl.PrimeiroBimestre;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Jogar extends AppCompatActivity {

    private TextView jogar;
    private Button btn_joken;
    private Button btn_velha;
    private Button btn_imc;

    private EditText ed_nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogar);

        ed_nome = (EditText) findViewById(R.id.ed_nome);

        jogar = (TextView) findViewById(R.id.jogar);
        Intent intent = getIntent();
        Bundle mensagem = intent.getExtras();
        if (mensagem != null){
            String getTarefa= (String) mensagem.get("mensagem");
            jogar.setText(getTarefa);
        }

        Intent intent2 = new Intent(getBaseContext(),DelayedMessageService.class);
        intent2.putExtra(DelayedMessageService.EXTRA_MESSAGE, getResources().getString(R.string.mensagem));
        startService(intent2);



        btn_velha = (Button) findViewById(R.id.btn_velha);
        btn_velha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Jogar.this, JogoVelha.class);
                intent3.putExtra("teste", ed_nome.getText().toString());
                startActivity(intent3);
            }
        });

        btn_joken = (Button) findViewById(R.id.btn_joken);
        btn_joken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(Jogar.this, joken.class);
                intent4.putExtra("teste", ed_nome.getText().toString());
                startActivity(intent4);
            }
        });

        btn_imc = (Button) findViewById(R.id.btn_imc);
        btn_imc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(Jogar.this, IMCActivity.class);
                intent5.putExtra("teste", ed_nome.getText().toString());
                startActivity(intent5);
            }
        });


    }
}
