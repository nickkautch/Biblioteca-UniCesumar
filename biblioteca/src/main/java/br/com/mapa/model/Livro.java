package br.com.mapa.model;

import br.com.mapa.exception.LivroException;

public class Livro {

    // Contador para gerar IDs automáticos e únicos
    static int contador = 1;

    // Atributos do livro
    private int id;
    private String titulo;
    private String autor;
    private int ano;
    private String isbn;

    //Construtor

    public Livro() {
        this.id = contador++;
    }

    public final int getId() {
        return id;
    }

    // Getters e Setters
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

    //Validação dos campos do livro com uma exceção (LivroException) em caso de erro

    public void validacao() throws LivroException {
        // Valida título
        if (titulo == null || titulo.trim().isEmpty()) {
            contador--; // reverte o contador se houver erro
            throw new LivroException("Coloque um título válido");
        }

        // Valida autor
        if (autor == null || autor.trim().isEmpty()) {
            contador--;
            throw new LivroException("Coloque um autor válido");
        }

        // Valida ano
        if (ano < 1000 || ano > 2025) {
            contador--;
            throw new LivroException("Coloque um ano válido");
        }

        // Valida ISBN
        if ((isbn == null) || isbn.trim().isEmpty() ||
                !(isbn.matches("\\d{10}") || isbn.matches("\\d{13}"))) {
            contador--;
            throw new LivroException("Coloque um ISBN válido");
        }
    }

}




