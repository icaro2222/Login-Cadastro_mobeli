package com.example.logincadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        final String[] text_email = {""};
        final String[] text_senha = {""};

        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text_email[0] = email.getText().toString();
                text_senha[0] = senha.getText().toString();

                if(text_email[0].isEmpty()){
                    email.setError("Campo Vazio!");
                    Toast.makeText(MainActivity.this, "Preencha todos os Campos!", Toast.LENGTH_SHORT).show();
                }else if(text_senha[0].isEmpty()){
                    senha.setError("Campo Vazio!");
                    Toast.makeText(MainActivity.this, "Preencha todos os Campos!", Toast.LENGTH_SHORT).show();
                }else{
                    boolean retur = appDataBase.select(text_email[0], text_senha[0]);
                    if (retur){
                        Intent intent = new Intent(MainActivity.this, inicio.class);
                        intent.putExtra("email", text_email[0]);
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

//                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
//                progressDialog.setTitle("Validando...");
//                progressDialog.show();

                Intent intent = new Intent(MainActivity.this, Cadastro.class);
                intent.putExtra("text_email", text_email[0]);
                intent.putExtra("text_senha", text_senha[0]);
                startActivity(intent);
            }
        });

    }
}