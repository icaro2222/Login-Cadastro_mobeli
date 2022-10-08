package com.example.logincadastro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

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
}
