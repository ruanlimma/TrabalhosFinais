package com.atlas.rl.PrimeiroBimestre;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_jogar;
    private Button btn_toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_jogar = (Button) findViewById(R.id.btn_jogar);
        btn_jogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Jogar.class);
                intent.putExtra("mensagem", "Aproveite!");
                startActivity(intent);

            }
        });

        btn_toast = (Button) findViewById(R.id.btn_toast);
        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getBaseContext(),DelayedMessageService2.class);
                intent2.putExtra(DelayedMessageService2.EXTRA_MESSAGE, "Clique em 'Aplicativos'");
                startService(intent2);
            }
        });




    }
}
