
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
    <title>Unicesumar</title>
        <style>
            .container-form {
                display: flex;
                flex-direction: column;
                align-items: center;
                gap: .5rem;
                border: 1px solid black;
                padding: 1rem;
                border-radius: 8px;
                max-width: 400px;
                margin: 40px auto;

                form {
                    display: flex;
                    flex-direction: column;
                    align-items: center;
                    justify-content: center;
                    width: 100%;
                    gap: 1rem;

                    div {
                        width: 100%;
                        display: flex;
                        align-items: center;
                        justify-content: start;
                        gap: 1rem;

                        label {
                            width: 20%;
                            font-size: 1.5rem;
                        }

                        input{
                            width: 80%;
                            border-radius: 10px;
                            padding: .5rem;
                            font-size: 1rem;
                        }
                    }
                }

                button {
                    background-color: darkmagenta;
                    padding: .5rem;
                    border: none;
                    border-radius: 20px;
                    color: whitesmoke;
                    cursor: pointer;
                    font-size: 1.5rem;
                    width: 100%;
                }
            }

            .lista {
                display: flex;
                flex-direction: row;
                justify-content: space-between;
                align-items: center;
                gap: .5rem;
                padding: .3rem;
                border: 1px solid black;
            }

            .delete-form {
                margin: 0;

                button {
                    cursor: pointer;
                    padding: .5rem;
                    border: none;
                    background-color: lightpink;
                    color: whitesmoke;
                }
            }
        </style>

    </head>

    <body>

    <div class="container-form">
        <h2>Cadastrar Livros</h2>
        <form action="/books" method="post">
            <div>
                <label for="titulo">Título: </label>
                <input type="text" name="titulo" required/>
            </div>
            <div>
                <label  for="autor">Autor: </label>
                <input type="text" name="autor" required/>
            </div>
            <div>
                <label for ="ano">Ano: </label>
                <input type="number" name="ano" required/>
            </div>
            <button type="submit">Cadastrar</button>
        </form>
    </div>

    </body>


</html>
