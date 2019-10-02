package com.pesquisaAnhembi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonEntra = findViewById(R.id.buttonEntrar);
        buttonEntra.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //System.out.println("Button Clicked");

                Intent activityInstrucoes = new Intent(getApplicationContext(), instrucoes.class);
                startActivity(activityInstrucoes);
            }
        });
    }
}
