package br.com.mapa.util;

import java.util.Random;

public class GeradorISBN {
    public static String gerar() {
        Random gerador = new Random();
        StringBuilder ISBN = new StringBuilder("123");

        for (int i = 0; i <9; i++) {
            ISBN.append(gerador.nextInt(10));
        }
        return ISBN.toString();
    }
}
