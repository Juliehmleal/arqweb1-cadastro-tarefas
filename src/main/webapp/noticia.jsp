<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="includes/header.jsp"/>

<div class="container mt-5">
<%String usuario = (String) session.getAttribute("usuario");%>
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header bg-primary text-white">
                    <h3 class="mb-0 text-center">${noticia.titulo}</h3>
                </div>
                <div class="card-body">

                    <p><strong>Autor:</strong> ${noticia.autor}</p>
                    <p><strong>Categoria:</strong> ${noticia.categoria}</p>

                    <hr>

                    <h5>Resumo</h5>
                    <p>${noticia.resumo}</p>

                    <hr>

                    <h5>Conteúdo</h5>
                    <p>${noticia.conteudo_completo}</p>

                    <div class="d-flex justify-content-center align-items-center">
                        <a href="index.jsp" class="btn btn-secondary m-2 col-5">Voltar</a>
                       <% if (usuario != null) { %>
                           <a class="m-2 col-5 btn btn-danger"
                              href="<c:url value='/exclui_noticia?id=${noticia.id}'/>">
                               Excluir
                           </a>
                       <% } %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<c:import url="includes/footer.jsp"/>