package com.example.elifas1.meuslivros.Models;

public class Livro {
    private String ano;
    private String autor;
    private Boolean favorito;
    private Integer id;
    private String titulo;
    private Integer usuarioId;

    public Livro() {
    }

    public Livro(String ano, String autor, Boolean favorito, Integer id, String titulo, Integer usuarioId) {
        this.ano = ano;
        this.autor = autor;
        this.favorito = favorito;
        this.id = id;
        this.titulo = titulo;
        this.usuarioId = usuarioId;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}
