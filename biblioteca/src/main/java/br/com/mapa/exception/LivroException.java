package br.com.mapa.exception;

//Exceção para tratar erros relacionados ao cadastro de livros

public class LivroException extends Exception{
    public LivroException(String msg){
        super(msg);
    }
}