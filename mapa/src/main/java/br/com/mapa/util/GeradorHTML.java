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
                    //Lista de livros
                    .append("<div class=\"lista\">")
                    .append("<p><strong> Titulo: </strong>").append(livro.getTitulo()).append("</p>")
                    .append("<p><strong> Autor: </strong>").append(livro.getAutor()).append("</p>")
                    .append("<p><strong> Ano: </strong>").append(livro.getAno()).append("</p>")
                    .append("<p><strong> ISBN: </strong>").append(livro.getIsbn()).append("</p>")
                    .append("<p><strong> id: </strong>").append(livro.getId()).append("</p>")
                    //Botão para realizar a exclusão
                    .append("<form class=\"delete-form\" method='post' action='")
                    .append(request.getContextPath()).append("/books' style='display:inline;'> ")
                    .append("<input type='hidden' name='action' value='delete' />")
                    .append("<input type='hidden' name='id' value='")
                    .append(livro.getId()).append("' /s").append("<button type='submit'>EXCLUIR</button>")
                    .append("</form>").append("</div>");
        }
        return htmlLivros.toString();
    }


}