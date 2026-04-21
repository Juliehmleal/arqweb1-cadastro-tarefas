<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Resultados da busca por: ${termo}</h2>

<c:choose>
    <c:when test="${empty resultados}">
        <p>Nenhuma notícia encontrada.</p>
    </c:when>
    <c:otherwise>
        <c:forEach var="n" items="${resultados}">
            <div style="margin-bottom:20px; border-bottom:1px solid #ccc; padding:10px;">

                <h3>
                    <a href="busca_noticia?id=${n.id}">
                        ${n.titulo}
                    </a>
                </h3>

                <p>${n.resumo}</p>
                <small>${n.autor} - ${n.data_publicacao}</small>

            </div>
        </c:forEach>
    </c:otherwise>
</c:choose>