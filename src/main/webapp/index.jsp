<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="includes/header.jsp"/>

<c:choose>
    <c:when test="${listaNoticias == null || empty listaNoticias}">
        <div style="display: flex; justify-content: center; align-items: center; min-height: 60vh;">
            <div style="text-align: center;">
                <h2 style="color: #666; font-size: 2rem;">📰 Não tem Notícias</h2>
                <p style="color: #999; margin-top: 1rem;">Nenhuma notícia disponível no momento.</p>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <div class="card" style="width: 18rem;">
            <img src="..." class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">Card title</h5>
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                <a href="#" class="btn btn-primary">Go somewhere</a>
            </div>
        </div>

        <c:forEach var="n" items="${listaNoticias}">
            <div class="card" style="width: 18rem;">
                <img src="..." class="card-img-top" alt="imagem ${n.Categoria}">
                <div class="card-body">
                    <h5 class="card-title">${n.titulo}</h5>
                    <p class="card-text">${n.categoria}</p>
                    <p class="card-text">${n.conteudoCompleto}</p>
                    <a href="#" class="btn btn-primary">Go somewhere</a>
                </div>
            </div>
        </c:forEach>
    </c:otherwise>
</c:choose>

<c:import url="includes/footer.jsp"/>