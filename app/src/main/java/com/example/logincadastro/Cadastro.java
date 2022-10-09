package com.example.logincadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Cadastro extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button btn_cadastrar = (Button) findViewById(R.id.btn_cadastrar);

        AppDataBase appDataBase = new AppDataBase(this);


        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText input_nome = findViewById(R.id.input_nome);
                EditText input_email = findViewById(R.id.input_email);
                EditText input_data_nascimento = findViewById(R.id.input_data_nascimento);
                EditText input_senha = findViewById(R.id.input_senha);
                EditText input_endereco = findViewById(R.id.input_endereco);

                Usuario usuario = new Usuario();

                String nome = input_nome.getText().toString();
                String email = input_email.getText().toString();
                String data_nascimento = input_data_nascimento.getText().toString();
                String senha = input_senha.getText().toString();
                String endereco = input_endereco.getText().toString();


                if (!nome.isEmpty() &&
                    !email.isEmpty() &&
                    !data_nascimento.isEmpty() &&
                    !senha.isEmpty() &&
                    !endereco.isEmpty()){

                    if (senha.)
                    usuario.setNome(nome);
                    usuario.setEmail(email);
                    usuario.setData_nascimento(data_nascimento);
                    usuario.setSenha(senha);
                    usuario.setEndereco(endereco);

                    if(appDataBase.insert(usuario)){
                        Intent intent = new Intent(Cadastro.this, inicio.class);
                        startActivity(intent);
                    }
                }else{
                    input_nome.setError("Verifique os Campos!");
                }
            }
        });
    }
}