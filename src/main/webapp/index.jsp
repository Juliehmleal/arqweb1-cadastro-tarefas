<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="includes/header.jsp"/>

<div class="container mt-5"> <%-- Container para centralizar e dar margem --%>
    <c:choose>
        <c:when test="${empty applicationScope.listaNoticias}">
            <div style="display: flex; justify-content: center; align-items: center; min-height: 60vh;">
                <div style="text-align: center;">
                    <h2 style="color: #666; font-size: 2rem;">📰 Não tem Notícias</h2>
                    <p style="color: #999; margin-top: 1rem;">Nenhuma notícia disponível no momento.</p>
                </div>
            </div>
        </c:when>


        <c:otherwise>
            <%-- Criamos a linha do grid aqui --%>
            <div class="row">
                <c:forEach var="n" items="${applicationScope.listaNoticias}">
                    <%-- col-md-4 define 3 colunas em telas médias/grandes --%>
                    <%-- mb-4 adiciona margem na parte de baixo para as linhas não grudarem --%>
                    <div class="col-md-4 mb-4 d-flex align-items-stretch">
                        <div class="card w-100"> <%-- w-100 para o card ocupar toda a largura da coluna --%>
                            <img src="https://via.placeholder.com/300x200" class="card-img-top" alt="imagem ${n.categoria}">
                            <div class="card-body d-flex flex-column">
                                <h5 class="card-title">${n.titulo}</h5>
                                <h6 class="card-subtitle mb-2 text-muted">${n.categoria}</h6>
                                <p class="card-text">${n.resumo}</p> <%-- Usei resumo aqui para não ficar gigante --%>

                                    <%-- mt-auto faz o botão ficar sempre no rodapé do card, mesmo com textos de tamanhos diferentes --%>
                                <a href="#" class="btn btn-primary mt-auto">Ler mais</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:otherwise>
    </c:choose>
</div>

<c:import url="includes/footer.jsp"/>