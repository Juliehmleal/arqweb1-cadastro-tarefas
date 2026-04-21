<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="includes/header.jsp"/>

<div class="container mt-5">
    <c:choose>
        <c:when test="${listaNoticias.size() == 0}">
            <div style="display: flex; justify-content: center; align-items: center; min-height: 60vh;">
                <div style="text-align: center;">
                    <h2 style="color: #666; font-size: 2rem;">Não tem Notícias</h2>
                    <p style="color: #999; margin-top: 1rem;">Nenhuma notícia disponível no momento.</p>
                </div>
            </div>
        </c:when>


        <c:otherwise>
            <div class="row">
                <c:forEach var="n" items="${listaNoticias}">
                    <div class="col-md-4 mb-4 d-flex align-items-stretch">
                        <div class="card w-100">
                           <img src="${pageContext.request.contextPath}/${n.imagem}"
                                class="card-img-top"
                                alt="imagem ${n.categoria}">
                            <div class="card-body d-flex flex-column">
                                <h5 class="card-title">${n.titulo}</h5>
                                <h6 class="card-subtitle mb-2 text-muted">${n.categoria}</h6>
                                <p class="card-text">${n.resumo}</p>
                                <a href=<c:url value='/ler_noticia?id=${n.id}'/> class="btn btn-primary m-2">Ler Notícia</a>
                                <a href= <c:url value='/editar_noticia?id=${n.id}'/> class="btn btn-secondary m-2">Editar </a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:otherwise>
    </c:choose>
</div>

<c:import url="includes/footer.jsp"/>