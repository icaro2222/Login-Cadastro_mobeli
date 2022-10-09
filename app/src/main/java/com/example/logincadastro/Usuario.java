package com.example.logincadastro;

import java.util.Date;

public class Usuario {


    private int id;
    private String nome;
    private String email;
    private String data_nascimento;
    private String senha;
    private String endereco;
    private boolean ativo;
    private Date data;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Usuario() {
    }

    public static boolean insert(){


        return true;
    }
    public static boolean login(String nome, String senha){

        return true;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
