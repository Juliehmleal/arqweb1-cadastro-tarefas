<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="includes/header.jsp"/>

<div class="container d-flex justify-content-center align-items-center" style="min-height: 70vh;">
    <div class="card shadow-lg border-0 text-center p-4" style="max-width: 500px; width: 100; border-radius: 20px;">

        <div class="mb-3">
            <span style="font-size: 60px;">📰</span>
        </div>

        <h2 class="mb-3 text-danger">Notícia não encontrada</h2>

        <p class="text-muted mb-4">
            A notícia que você está procurando não existe ou foi removida.
        </p>

        <a href="index.jsp" class="btn btn-primary px-4 py-2" style="border-radius: 10px;">
            Voltar para a página inicial
        </a>
    </div>
</div>

<c:import url="includes/footer.jsp"/>