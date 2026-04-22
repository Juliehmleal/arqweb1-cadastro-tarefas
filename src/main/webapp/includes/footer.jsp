<%--
  Created by IntelliJ IDEA.
  User: julie
  Date: 11/03/2026
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
    </body>
    <style>
        footer {
            background-color: #000; /* fundo preto */
            color: #fff;
        }

        .footer-box {
            background-color: #111; /* leve contraste */
            border-radius: 10px;
            padding: 30px; /* AUMENTEI o tamanho */
            height: 100%;
        }

        .footer-title {
            font-size: 20px;
            font-weight: bold;
            margin-bottom: 10px;
        }

        .footer-text {
            font-size: 15px;
            color: #ccc;
        }
    </style>

    <footer class="mt-5">
        <div class="container py-4">
            <div class="row g-4">

                <!-- Contato -->
                <div class="col-md-6">
                    <div class="footer-box">
                        <div class="footer-title">📧 Contato</div>
                        <p class="footer-text">Email: julie.hervias@aluno.ifsp.edu.br</p>
                        <p class="footer-text">Email: miguel.prates@aluno.ifsp.edu.br</p>
                    </div>
                </div>

                <!-- Direitos -->
                <div class="col-md-6">
                    <div class="footer-box text-center d-flex flex-column justify-content-center">
                        <div class="footer-title">© Direitos</div>
                        <p class="footer-text mb-0">
                            © 2026 Portal de Notícias<br>
                            Todos os direitos reservados
                        </p>
                    </div>
                </div>

            </div>
        </div>
    </footer>
</html>
