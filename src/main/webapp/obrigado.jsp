<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="includes/header.jsp"/>


<div class="container">
  <p class="h3"> Nome: ${tarefa.nome} </p>
  <p class="h3"> Decricao: ${tarefa.descricao} </p>
</div>

<c:import url="includes/footer.jsp"/>