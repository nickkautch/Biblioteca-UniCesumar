package br.com.mapa.util;

import br.com.mapa.model.Livro;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class GeradorHTML {
    public static String gerar(HttpServletRequest request, List<Livro> books) {
        StringBuilder htmlLivros = new StringBuilder();
        htmlLivros.append("<h2>Livros cadastrados:</h2>");
        for (Livro livro : books) {
            htmlLivros
                    .append("<div class=\"lista\">")
                    //Lista de livros
                    .append("<p><strong> Titulo: </strong>" + livro.getTitulo() + "</p>")
                    .append("<p><strong> Autor: </strong>" + livro.getAutor() + "</p>")
                    .append("<p><strong> Ano: </strong>" + livro.getAno() + "</p>")
                    .append("<p><strong> ISBN: </strong>" + livro.getIsbn() + "</p>")
                    .append("<p><strong> id: </strong>" + livro.getId() + "</p>")


                    //Botão para realizar a exclusão
                    .append("<form class=\"delete-form\" method='post' action='" + request.getContextPath() + "/books' style='display:inline;'> ")
                    .append("<input type='hidden' name='action' value='delete' />")
                    .append("<input type='hidden' name='id' value='" + livro.getId() + "' /s")
                    .append("<button type='submit'>EXCLUIR</button>")
                    .append("</form>")
                    .append("</div>");
        }
        return htmlLivros.toString();
    }


}