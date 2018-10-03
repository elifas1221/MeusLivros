package com.example.elifas1.meuslivros.Models;

public class Usuario {
    private Integer id;
    private String nome;
    private String login;
    private String senha;
    private String result;
    private boolean valid;

    public Usuario(String nome, String login, String senha){
        this.nome = nome;
        this.login = login;
        this.senha= senha;
    }

    @Override
    public String toString() { return "nome: " + nome  +", login='" + login +", senha='" + senha;  }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Usuario() {
    }

    public Usuario(Integer id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
