<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Resultados da Busca</title>

    <!-- BOOTSTRAP -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<!-- HEADER -->
<jsp:include page="/includes/header.jsp" />

<div class="container mt-4">

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

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>

<c:import url="includes/footer.jsp"/>