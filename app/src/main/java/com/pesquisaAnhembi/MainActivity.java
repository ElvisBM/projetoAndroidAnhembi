package com.pesquisaAnhembi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import java.security.AccessController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonEntra = findViewById(R.id.buttonEntrar);
        buttonEntra.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                TextView usuario = (TextView) findViewById(R.id.usuario);
                TextView senha = (TextView) findViewById(R.id.senha);

                if( usuario.getText().toString().equals("admin") && senha.getText().toString().equals("1") ){
                    //System.out.println("Button Clicked");
                    Intent activityInstrucoes = new Intent(getApplicationContext(), instrucoes.class);
                    startActivity(activityInstrucoes);
                }else{
                    Toast.makeText(getApplicationContext(), " Dados de acesso errado ", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
