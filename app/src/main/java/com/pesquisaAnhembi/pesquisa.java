package com.pesquisaAnhembi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pesquisa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);
        Button buttonAvanca = findViewById(R.id.buttonAvanca);
        Button buttonVoltar = findViewById(R.id.buttonVoltar);


        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityInstrucoes = new Intent(getApplicationContext(), instrucoes.class);
                startActivity(activityInstrucoes);
            }
        });

        buttonAvanca.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityFinaliza = new Intent(getApplicationContext(), finaliza.class);
                startActivity(activityFinaliza);
            }
        });

    }
}
