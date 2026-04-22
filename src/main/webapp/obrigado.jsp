<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="includes/header.jsp"/>

<style>
    .sucesso-area {
        min-height: 70vh;
        display: flex;
        align-items: center;
        justify-content: center;
        background-color: #f8f9fa;
    }

    .sucesso-box {
        background-color: white;
        padding: 40px;
        border-radius: 20px;
        box-shadow: 0 8px 20px rgba(0, 0, 0, 0.12);
        text-align: center;
        max-width: 500px;
        width: 100%;
    }

    .sucesso-icone {
        font-size: 60px;
        margin-bottom: 15px;
    }

    .sucesso-titulo {
        font-size: 28px;
        font-weight: bold;
        color: #198754;
        margin-bottom: 10px;
    }

    .sucesso-texto {
        font-size: 18px;
        color: #555;
        margin-bottom: 25px;
    }
</style>

<div class="sucesso-area">
    <div class="sucesso-box">
        <div class="sucesso-icone">✅</div>
        <h2 class="sucesso-titulo">Notícia cadastrada!</h2>
        <p class="sucesso-texto">
            A notícia foi cadastrada com sucesso no sistema.
        </p>

        <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary me-2">
            Voltar para Home
        </a>

        <a href="${pageContext.request.contextPath}/cadastro.jsp" class="btn btn-outline-success">
            Cadastrar outra
        </a>
    </div>
</div>

<c:import url="includes/footer.jsp"/>