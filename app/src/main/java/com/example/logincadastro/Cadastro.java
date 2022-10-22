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

        EditText input_nome = findViewById(R.id.input_nome);
        EditText input_email = findViewById(R.id.input_email);
        EditText input_data_nascimento = findViewById(R.id.input_data_nascimento);
        EditText input_senha = findViewById(R.id.input_senha);
        EditText input_endereco = findViewById(R.id.input_endereco);

        //Colocar valores de Email e Senha que vieram da tela de Login

        //Variavel para receber o que veio da tela de Login
        String text_email, text_senha;
        //Usando extra para pegar valores do Intent
        Bundle extra = getIntent().getExtras();
        //Verificando se veio algum valor da tela anterior
        if (extra != null){
            //Jogando os valores de Extra para variveis, que seram utilizadas
            text_email = extra.getString("text_email");
            text_senha = extra.getString("text_senha");
            input_email.setText(text_email);
            input_senha.setText(text_senha);
        }


        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Usuario usuario = new Usuario();

                String nome = input_nome.getText().toString();
                String email = input_email.getText().toString();
                String data_nascimento = input_data_nascimento.getText().toString();
                String senha = input_senha.getText().toString();
                String endereco = input_endereco.getText().toString();


                if (nome.isEmpty()){
                    input_nome.setError("Campo Obrigatório!");
                }else if (email.isEmpty()) {
                    input_email.setError("Campo Obrigatório!");
                }else if (data_nascimento.isEmpty()) {
                    input_data_nascimento.setError("Campo Obrigatório!");
                }else if (senha.isEmpty()) {
                    input_senha.setError("Campo Obrigatório!");
                }else if (endereco.isEmpty()) {
                    input_endereco.setError("Campo Obrigatório!");
                }else{

                    if (senha.length() < 8){
                        input_senha.setError("Pelo Menos 8 Digitos");
                    }else{
                        usuario.setNome(nome);
                        usuario.setEmail(email);
                        usuario.setData_nascimento(data_nascimento);
                        usuario.setSenha(senha);
                        usuario.setEndereco(endereco);

                        if(appDataBase.insert(usuario)){
                            Intent intent = new Intent(Cadastro.this, inicio.class);
                            intent.putExtra("nome", nome);
                            intent.putExtra("email", email);
                            intent.putExtra("data_nascimento", data_nascimento);
                            intent.putExtra("senha", senha);
                            intent.putExtra("endereco", endereco);
                            startActivity(intent);
                        }
                    }
                }
            }
        });
    }
}