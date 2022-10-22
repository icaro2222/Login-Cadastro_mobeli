package com.example.logincadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.content.Intent;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.TextView;

public class inicio extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        imageView = findViewById(R.id.imageView);
        TextView text_nome = findViewById(R.id.text_nome);
        TextView text_email = findViewById(R.id.text_email);
        TextView text_data_nascimneto = findViewById(R.id.text_data_nascimneto);
        TextView text_senha = findViewById(R.id.text_senha);
        TextView text_endereco = findViewById(R.id.text_endereco);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //Usando extra para pegar valores do Intent
        Bundle extra = getIntent().getExtras();
        if (extra != null){
            //Jogando os valores de Extra para variveis, que seram utilizadas
            String nome = extra.getString("nome");
            String email = extra.getString("email");
            String data_de_nascimento = extra.getString("data_nascimento");
            String senha = extra.getString("senha");
            String endereco = extra.getString("endereco");

            text_nome.setText(nome);
            text_email.setText(email);
            text_data_nascimneto.setText(data_de_nascimento);
            text_senha.setText(senha);
            text_endereco.setText(endereco);
        }

        startActivity(intent);
        startActivityForResult(intent, 1);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap foto = (Bitmap) data.getExtras().get("data");
        imageView.setImageBitmap(foto);
    }
}