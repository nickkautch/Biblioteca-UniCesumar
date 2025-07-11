<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Cadastro de Livros</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 700px;
            margin: 50px auto;
            padding: 2rem;
            background: white;
            border-radius: 12px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #5a0080;
        }

        form {
            display: flex;
            flex-direction: column;
            gap: 1rem;
        }

        label {
            font-weight: bold;
            color: #333;
        }

        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 0.7rem;
            border: 1px solid #ccc;
            border-radius: 6px;
        }

        button {
            background-color: #7b1fa2;
            color: white;
            padding: 0.8rem;
            border: none;
            border-radius: 8px;
            font-size: 1rem;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #6a1b9a;
        }

        .livro {
            display: flex;
            justify-content: space-between;
            align-items: center;
            border: 1px solid #ddd;
            border-left: 5px solid #7b1fa2;
            padding: 1rem;
            margin: 1rem 0;
            border-radius: 8px;
            background-color: #fafafa;
            flex-wrap: wrap;
            gap: 1rem;
        }

        .livro-info {
            display: flex;
            gap: 2rem;
            flex-wrap: wrap;
            flex: 1;
        }

        .livro p {
            margin: 0;
        }

        .livro form {
            margin-top: 0.5rem;
        }

        .error {
            color: red;
            font-weight: bold;
            margin-bottom: 1rem;
        }

    </style>
</head>
<body>
<div class="container">
    <h2>Cadastrar Livro</h2>

    <!-- Mostra mensagens de erro -->
    <%
        String mensagemErro = (String) request.getAttribute("mensagemErro");
        if (mensagemErro != null) {
    %>
    <div class="error"><%= mensagemErro %></div>
    <% } %>

    <!-- Formulário -->
    <form action="books" method="post">
        <label for="titulo">Título:</label>
        <label>
            <input type="text" name="titulo" required />
        </label>

        <label for="autor">Autor:</label>
        <label>
            <input type="text" name="autor" required />
        </label>

        <label for="ano">Ano:</label>
        <label>
            <input type="number" name="ano" required />
        </label>

        <label for="isbn">ISBN:</label>
        <label>
            <input type="text" name="isbn" required />
        </label>

        <button type="submit">Cadastrar</button>
    </form>

    <hr />

    <!-- lista de livros -->
    <div>
        <%= request.getAttribute("htmlLivros") %>
    </div>
</div>
</body>
</html>