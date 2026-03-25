<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="includes/header.jsp"/>


    <div class="container">
        <form action="cadastrar_tarefa" method="POST">
            <div class="row">
                <div class="col-12">
                    <p class="h1">Cadastro de Tarefas</p>
                </div>
            </div>

            <div class="row">
                <div class="col-12 col-md-2 text-md-end">
                    <label for="nome_tarefa" class="form-label">Nome da Tarefa:</label>
                </div>
                <div class="col-12 col-md-10">
                    <input type="text" class="form-control" id="nome_tarefa" name="nome_tarefa">
                </div>
            </div>

             <div class="row py-2">
                <div class="col-12 col-md-2 text-md-end">
                    <label for="descricao_tarefa" class="form-label">Descrição da Tarefa:</label>
                </div>
                <div class="col-12 col-md-10">
                    <textarea class="form-control" id="descricao_tarefa" name="descricao_tarefa" rows="3"></textarea>
                </div>
            </div>
            <div class="row py-2">
                <div class="col-12 col-md-12 text-md-end">
                    <button type="submit" class="btn btn-primary">Enviar</button>
                </div>
            </div>
        </form>
    </div>

<c:import url="includes/footer.jsp"/>