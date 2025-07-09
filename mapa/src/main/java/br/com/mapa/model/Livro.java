package br.com.mapa.model;

import br.com.mapa.util.GeradorISBN;
import br.com.mapa.exception.LivroException;


public class Livro {

    static int contador = 1;

    private int id;
    private String titulo;
    private String autor;
    private int ano;
    private String isbn = GeradorISBN.gerar();

    public Livro() {
        this.id = contador++;
        this.isbn = GeradorISBN.gerar();
    }

    public Livro(int id, String titulo, String autor, int ano, String isbn) {
        this.id = contador++;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.isbn = GeradorISBN.gerar();
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Livro.contador = contador;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void validacao() throws LivroException {
        if (titulo == null || titulo.trim().isEmpty()) {
            contador--;
            throw new LivroException("Deve colocar o título");
        }
        if (autor == null || autor.trim().isEmpty()) {
            contador--;
            throw new LivroException("Deve colocar o autor");
        }
        if (ano < 1000) {
            contador--;
            throw new LivroException("Coloque um ano válido");
        }
        if (ano > 2025) {
            contador--;
            throw new LivroException("Coloque um ano válido");
        }
    }
}
