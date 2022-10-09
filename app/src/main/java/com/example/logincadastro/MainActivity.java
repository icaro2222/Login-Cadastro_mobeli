package com.example.logincadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDataBase appDataBase = new AppDataBase(this);


        Button btn_novo_cadastro = (Button) findViewById(R.id.btn_novo_cadastro);
        Button btn_entrar = (Button) findViewById(R.id.btn_entrar);
        EditText email = findViewById(R.id.input_email);
        EditText senha = findViewById(R.id.input_senha);

        Usuario usuario = new Usuario();


        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(email.getText().toString().isEmpty()){
                    email.setError("Campo Vazio");
                }else if(senha.getText().toString().isEmpty()){
                    senha.setError("Campo Vazio");
                }else{
                    boolean retur = appDataBase.select(email.getText().toString(), senha.getText().toString());
                    if (retur){
                        Intent intent = new Intent(MainActivity.this, inicio.class);
                        startActivity(intent);
                    }else{
                        senha.setError("Email ou Senha Inválida!");
                    }
                }

            }
        });

        btn_novo_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("Validando...");
                progressDialog.show();

                Intent intent = new Intent(MainActivity.this, Cadastro.class);
                startActivity(intent);
            }
        });

    }
}