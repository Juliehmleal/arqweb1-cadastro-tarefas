<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="includes/header.jsp"/>

<style>
    body {
        background-color: #f4f6f9;
    }

    .sobre-container {
        max-width: 1100px;
        margin: 40px auto;
        padding: 20px;
    }

    .sobre-card {
        background: #ffffff;
        border-radius: 18px;
        padding: 35px;
        box-shadow: 0 6px 20px rgba(0, 0, 0, 0.08);
    }

    .titulo-principal {
        font-size: 2.2rem;
        font-weight: bold;
        color: #0d6efd;
        margin-bottom: 20px;
        border-left: 6px solid #0d6efd;
        padding-left: 15px;
    }

    .secao-titulo {
        font-size: 1.5rem;
        font-weight: 600;
        color: #212529;
        margin-top: 30px;
        margin-bottom: 15px;
    }

    .texto {
        font-size: 1.05rem;
        color: #555;
        line-height: 1.8;
    }

    .lista-estilizada {
        padding-left: 20px;
    }

    .lista-estilizada li {
        margin-bottom: 10px;
        font-size: 1.02rem;
        color: #444;
    }

    .destaque-box {
        background: linear-gradient(135deg, #0d6efd, #0b5ed7);
        color: white;
        padding: 25px;
        border-radius: 15px;
        margin-bottom: 30px;
    }

    .destaque-box h4 {
        margin-bottom: 10px;
        font-weight: bold;
    }

    .rodape-sobre {
        margin-top: 35px;
        padding-top: 20px;
        border-top: 1px solid #ddd;
        font-size: 1rem;
        color: #666;
    }
</style>

<div class="container sobre-container">
    <div class="sobre-card">

        <div class="destaque-box">
            <h4>Portal de Notícias</h4>
            <p class="mb-0">
                Um sistema web desenvolvido para facilitar o cadastro, gerenciamento e visualização de notícias de forma simples e organizada.
            </p>
        </div>

        <h2 class="titulo-principal">Sobre o Portal</h2>
        <p class="texto">
            Este é um portal de notícias desenvolvido com <strong>Java, JSP e Servlets</strong>,
            com o objetivo de permitir o cadastro, visualização e gerenciamento de notícias.
        </p>

        <h3 class="secao-titulo">Objetivo</h3>
        <p class="texto">
            O sistema tem como principal objetivo facilitar a publicação de notícias de forma prática,
            permitindo que usuários cadastrem conteúdos, visualizem informações atualizadas
            e façam o gerenciamento das notícias já existentes.
        </p>

        <h3 class="secao-titulo">Funcionalidades</h3>
        <ul class="lista-estilizada">
            <li>Cadastro de notícias</li>
            <li>Edição e exclusão de notícias</li>
            <li>Busca por título e conteúdo</li>
            <li>Sistema de login e logout</li>
        </ul>

        <h3 class="secao-titulo">Tecnologias Utilizadas</h3>
        <ul class="lista-estilizada">
            <li>Java</li>
            <li>JSP (Java Server Pages)</li>
            <li>Servlets</li>
            <li>HTML, CSS e Bootstrap</li>
            <li>Apache Tomcat</li>
        </ul>

        <h3 class="secao-titulo">Desenvolvedor</h3>
        <p class="texto">
            Projeto desenvolvido por <strong>Julie Hervias e Miguel Ferreira</strong>,
            estudantes do curso <strong>Tecnologia de Sistemas para Internet</strong>.
        </p>

        <div class="rodape-sobre">
            © 2026 - Portal de Notícias.
        </div>

    </div>
</div>

<c:import url="includes/footer.jsp"/>