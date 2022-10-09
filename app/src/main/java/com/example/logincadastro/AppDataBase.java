package com.example.logincadastro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AppDataBase extends SQLiteOpenHelper {

    public static final  String DB_NAME = "usuarios.sqlite";
    public static final int DB_VERSION = 1;

    SQLiteDatabase database;

    public AppDataBase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        database = getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String tabela_usuarios;
        tabela_usuarios = "CREATE TABLE usuario (\n" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                " nome TEXT,\n" +
                " email TEXT,\n" +
                " data_nascimento TEXT,\n" +
                " senha TEXT,\n" +
                " endereco TEXT\n" +
                ");";

        try{
            database.execSQL(tabela_usuarios);
        }catch (SQLException e){
            Log.e("DB_LOG", "onCreate: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
    }

    public boolean insert(Usuario usuario){

        ContentValues values = new ContentValues();

        values.put("nome", usuario.getNome());
        values.put("email", usuario.getEmail());
        values.put("data_nascimento", usuario.getData_nascimento());
        values.put("senha", usuario.getSenha());
        values.put("endereco", usuario.getEndereco());

        try{
            database.insert("usuario", null, values);
            return true;
        }catch (SQLException e){
            Log.e("DB_LOG", "onCreate: " + e.getLocalizedMessage());
            return false;
        }
    }

    public List<Usuario> select(String nome, String senha){

        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario = null;

        Cursor cursor = null;

        String sql = "SELECT * FROM usuario WHERE nome ==" + nome +
                     " AND senha == " + senha + ");";

        cursor = database.rawQuery(sql, null);

        if (cursor.moveToFirst()){
            do {
                usuarios = (List<Usuario>) new Usuario();
                usuario.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                usuario.setEmail(cursor.getString(cursor.getColumnIndex("email")));
                usuario.setData_nascimento(cursor.getString(cursor.getColumnIndex("data_nascimento")));
                usuario.setSenha(cursor.getString(cursor.getColumnIndex("senha")));
                usuario.setEndereco(cursor.getString(cursor.getColumnIndex("endereco")));

                usuarios.add(usuario);

            }while (cursor.moveToNext());
        }

        return usuarios;
    }
}
