package br.com.mapa.controller;

import br.com.mapa.exception.LivroException;
import br.com.mapa.model.Livro;
import br.com.mapa.util.GeradorHTML;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "livroServlet", value = "/books")

public class LivroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<Livro> books;

    public LivroServlet() {
        super();
    }

    @Override
    public void init() {
        books = new ArrayList<Livro>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String htmlLivros = GeradorHTML.gerar(request, books);
        request.setAttribute("htmlLivros", htmlLivros);
        request.getRequestDispatcher("/view/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if("delete".equals(action)) {
            String id = request.getParameter("id");
            if(id != null && !id.isEmpty()) {
                int idParse = Integer.parseInt(id);
                books.removeIf(livro -> livro.getId() == idParse);
            }
            response.sendRedirect(request.getContextPath() + "/books");
            return;
        }

        try {
            Livro livro = new Livro();
            livro.setTitulo(request.getParameter("titulo").toUpperCase());
            livro.setAutor(request.getParameter("autor").toUpperCase());
            livro.setAno(Integer.parseInt(request.getParameter("ano")));
            livro.validacao();
            books.add(livro);
            response.sendRedirect(request.getContextPath() + "/books");
        } catch (NumberFormatException e) {
            request.setAttribute("mensagemErro", "Ano tem que ser um número");
            request.setAttribute("htmlLivros", GeradorHTML.gerar(request, books));
            request.getRequestDispatcher("/view/index.jsp").forward(request, response);
        } catch (LivroException e) {
            request.setAttribute("mensagemErro", e.getMessage());
            request.setAttribute("htmlLivros", GeradorHTML.gerar(request, books));
            request.getRequestDispatcher("/view/index.jsp").forward(request, response);
        }
    }
}
