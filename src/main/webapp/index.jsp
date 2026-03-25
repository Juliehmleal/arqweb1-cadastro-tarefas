<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="includes/header.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Nome</th>
            <th scope="col">Descrição</th>
            <th scope="col">Excluir</th>
            <th scope="col">Editar</th>
        </tr>
        </thead>
        <tbody>

        <c:if test="${lista == null}">
            <tr>
                <td colspan=3> Não há tarefas cadastradas</td>
            </tr>
        </c:if>

            <c:forEach var="t" items="${lista}">
                <tr>
                    <td>${t.getId()}</td>
                    <td>${t.getNome()}</td>
                    <td>${t.getDescricao()}</td>
                    <td>Editar</td>
                    <td>Excluir</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<c:import url="includes/footer.jsp"/>
