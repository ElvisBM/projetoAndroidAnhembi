package com.pesquisaAnhembi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.security.AccessController;

public class MainActivity extends AppCompatActivity {
    EditText bUsuario, bSenha;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonEntra = findViewById(R.id.buttonEntrar);
        buttonEntra.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                bUsuario = (EditText) findViewById(R.id.usuario);
                bSenha = (EditText) findViewById(R.id.senha);
                String nome = bUsuario.getText().toString();
                validaLogin( nome );
//                if( usuario.getText().toString().equals("admin") && senha.getText().toString().equals("1") ){
//                    //System.out.println("Button Clicked");
//                    Intent activityInstrucoes = new Intent(getApplicationContext(), instrucoes.class);
//                    startActivity(activityInstrucoes);
//                }else{
//                    Toast.makeText(getApplicationContext(), " Dados de acesso errado ", Toast.LENGTH_LONG).show();
//                }
            }
        });

        Button buttonCadastro = findViewById(R.id.buttonCadastro);
        buttonCadastro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //System.out.println("Button Clicked");
                Intent activityCadastro = new Intent(getApplicationContext(), cadastro.class);
                startActivity(activityCadastro);
            }
        });
    }

    public void validaLogin(final String nome ){
        //Toast.makeText(getApplicationContext(), nome, Toast.LENGTH_LONG).show();
        FirebaseDatabase.getInstance().getReference().child("Users").orderByChild("nome").equalTo(nome)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            Intent activityInstrucoes = new Intent(getApplicationContext(), instrucoes.class);
                            startActivity(activityInstrucoes);
                        } else {
                            Toast.makeText(getApplicationContext(), " Dados de acesso errado ", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }


}
