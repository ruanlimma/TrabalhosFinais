package com.atlas.rl.PrimeiroBimestre;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IMCActivity extends AppCompatActivity {
    private EditText ed_peso;
    private EditText ed_altura;
    private Button btn_calcular;
    private TextView tv_resultado;
    private TextView tv_jogador;
    private Button btn_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imc);

        ed_peso = (EditText) findViewById(R.id.ed_peso);
        ed_altura = (EditText) findViewById(R.id.ed_altura);
        btn_calcular = (Button) findViewById(R.id.btn_calcular);
        btn_voltar = (Button) findViewById(R.id.btn_voltar);
        tv_resultado = (TextView) findViewById(R.id.tv_resultado);

        tv_jogador = (TextView) findViewById(R.id.tv_jogador);
        Intent intent = getIntent();
        Bundle mensagem = intent.getExtras();
        if (mensagem != null) {
            String getTarefa = (String) mensagem.get("teste");
            tv_jogador.setText(getTarefa);
        }

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float peso = Float.parseFloat(ed_peso.getText().toString());
                float altura = Float.parseFloat(ed_altura.getText().toString());

                float resultado = peso / (altura* altura);

                String resultToast =  String.format("%.2f", resultado);



                if (resultado < 19){
                    tv_resultado.setText("Abaixo do peso, procure ajuda médica.");
                    Toast.makeText(getBaseContext(), resultToast, Toast.LENGTH_LONG).show();
                }else if(resultado > 32){
                    tv_resultado.setText("Acima do peso, procure ajuda médica.");
                    Toast.makeText(getBaseContext(), resultToast, Toast.LENGTH_LONG).show();
                }else{
                    tv_resultado.setText("Parabéns, você está dentro do peso correto. Visite o médico regularmente para continuar assim.");
                    Toast.makeText(getBaseContext(), resultToast, Toast.LENGTH_LONG).show();
                }

            }
        });

        btn_voltar = (Button) findViewById(R.id.btn_voltar);
        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(IMCActivity.this, Jogar.class);
                startActivity(intent5);
            }
        });

    }
}
