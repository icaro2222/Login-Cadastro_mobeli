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
        Button cadastrar = (Button) findViewById(R.id.btn_cadastrar);
        EditText input_email = findViewById(R.id.input_email);
        EditText input_senha = findViewById(R.id.input_senha);

        Usuario usuario = new Usuario("icaro", "tatakae22");


        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(input_email.getText().toString().isEmpty()){
                    input_email.setError("Campo Vazio");
                }else if(input_senha.getText().toString().isEmpty()){
                    input_senha.setError("Campo Vazio");
                }else{
                    appDataBase.select(input_email.getText().toString(), input_senha.getText().toString());
                    boolean retur = appDataBase.insert(input_email.getText().toString(), input_senha.getText().toString());
                    if (retur){
                        Intent intent = new Intent(MainActivity.this, inicio.class);
                        startActivity(intent);
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

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText input_nome = findViewById(R.id.input_nome);
                EditText input_email = findViewById(R.id.input_email);
                EditText input_data_nascimento = findViewById(R.id.input_data_nascimento);
                EditText input_senha = findViewById(R.id.input_senha);
                EditText input_endereco = findViewById(R.id.input_endereco);

                Usuario usuario = new Usuario(input_nome.getText().toString(), input_senha.getText().toString());

                usuario.setEndereco(input_endereco.getText().toString());
                usuario.setEndereco(input_endereco.getText().toString());
                usuario.setEndereco(input_endereco.getText().toString());


                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("Validando...");
                progressDialog.show();

                Intent intent = new Intent(MainActivity.this, Cadastro.class);
                startActivity(intent);
            }
        });
    }
}