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
                    // Container do livro
                    .append("<div class=\"livro\">")
                    .append("<div class=\"livro-info\">")

                    // Mostra os atributos do livro em linha
                    .append("<p><strong>ID:</strong> ").append(livro.getId()).append("</p>")
                    .append("<p><strong>Título:</strong> ").append(livro.getTitulo()).append("</p>")
                    .append("<p><strong>Autor:</strong> ").append(livro.getAutor()).append("</p>")
                    .append("<p><strong>Ano:</strong> ").append(livro.getAno()).append("</p>")
                    .append("<p><strong>ISBN:</strong> ").append(livro.getIsbn()).append("</p>")

                    .append("</div>")

                    // Formulário de exclusão para cada livro
                    .append("<form method='post' action='")
                    .append(request.getContextPath()).append("/books'>")
                    .append("<input type='hidden' name='action' value='delete' />")
                    .append("<input type='hidden' name='id' value='")
                    .append(livro.getId()).append("' />")
                    .append("<button type='submit'>Excluir</button>")
                    .append("</form>")
                    .append("</div>");
        }
        return htmlLivros.toString();
    }


}
