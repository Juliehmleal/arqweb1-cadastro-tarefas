<%--
  Created by IntelliJ IDEA.
  User: julie
  Date: 11/03/2026
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
</head>
<body>
    <div class="container">
      <%String usuario = (String) session.getAttribute("usuario");%>
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp"><img src="${pageContext.request.contextPath}/imagens/portal.png"
                                                                                                     alt="Portal de Notícias"
                                                                                                     height="60"></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav me-auto">
                        <% if (usuario == null) { %>

                                <!-- NÃO LOGADO -->
                                <li class="nav-item">
                                    <a class="nav-link" href="index.jsp">Home</a>
                                </li>


                            <% } else { %>

                        <!-- LOGADO -->


                                <li class="nav-item">
                                    <a class="nav-link" href="index.jsp">Home</a>
                                </li>

                                <li class="nav-item">
                                    <a class="nav-link" href="cadastrar_noticia">Cadastrar Noticia</a>
                                </li>

                            <% } %>
                    </ul>

                    <div class="d-flex align-items-center gap-2">
                        <form class="d-flex m-0" action="${pageContext.request.contextPath}/buscar" method="get">
                            <input class="form-control" type="search" name="q" placeholder="Buscar notícias...">

                        </form>


                        <% if (usuario == null) { %>

                            <a href="login.jsp" class="btn btn-outline-primary">Login</a>

                        <% } else { %>

                            <span class="btn btn-outline-success">
                                <%= usuario %>
                            </span>

                                <a class="nav-link text-danger" href="logout">Sair</a>

                        <% } %>
                    </div>
                </div>
            </div>
        </nav>
        <c:if test="${not empty lista_mensagens}">
            <div class="alert alert-danger" role="alert">
                <ul class="list-group">
                    <c:forEach var="msg" items="${lista_mensagens}">
                        <li class="list-group-item">${msg}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
    </div>

