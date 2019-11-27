package com.pesquisaAnhembi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import modelo.Cadastro;

public class cadastro extends AppCompatActivity {
    EditText edNome, edEmail, edSenha;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edNome = (EditText) findViewById(R.id.nomeUsuario);
        edEmail = (EditText) findViewById(R.id.emailUsuario);
        edSenha = (EditText) findViewById(R.id.senhaUsuario);

        Button buttonVoltarLogin = findViewById(R.id.buttonLogin);
        buttonVoltarLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //System.out.println("Button Clicked");
                Intent activityMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(activityMain);
            }
        });

        Button buttonCadastrar = findViewById(R.id.buttonCadastrar);
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onOptionsItemSelected();
            }
        });
    }

    private void inicializarfirebase(){
        FirebaseApp.initializeApp(cadastro.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

//    public boolean onCreateOptionsMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    public void onOptionsItemSelected(){
        Cadastro c = new Cadastro();

        c.setUid(UUID.randomUUID().toString());
        c.setNome(edNome.getText().toString());
        c.setEmail(edEmail.getText().toString());
        c.setSenha(edSenha.getText().toString());
        inicializarfirebase();
        databaseReference.child("Users")
                .child(c.getUid())
                .setValue(c);
            limparcampos();

        Toast.makeText(getApplicationContext(), " Dados Cadastrado com Sucesso ", Toast.LENGTH_LONG).show();
    }

    public void limparcampos(){
        edNome.setText("");
        edEmail.setText("");
        edSenha.setText("");
//        Intent activityMain = new Intent(getApplicationContext(), MainActivity.class);
//        startActivity(activityMain);
    }

}
