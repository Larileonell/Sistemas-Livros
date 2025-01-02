package com.application.model;

public class Livro {
    private String autor;
    private String titulo;
    private int ano;
    private String isbn;

    public Livro(String autor, String titulo, int ano, String isbn) {
        this.autor = autor;
        this.titulo = titulo;
        this.ano = ano;
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
