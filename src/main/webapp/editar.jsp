<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="includes/header.jsp"/>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header bg-primary text-white">
                    <h3 class="mb-0">Editar</h3>
                </div>
                <div class="card-body">
                    <form action="editar_noticia" method="POST">
                        <input value="${noticia.id}" type="hidden" name="id">
                        <div class="mb-3">
                            <label class="form-label">Título</label>
                            <input type="text" class="form-control" name="titulo" value="${noticia.getTitulo()}" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Autor</label>
                            <input type="text" class="form-control" name="autor" value="${noticia.autor}" required>
                        </div>

                        <select name="categoria" class="form-select mb-2">
                            <option value="">Selecione o genêro</option>
                            <option value="Política" ${noticia.categoria == 'Política' ? 'selected' : ''}>Política</option>
                            <option value="Esporte" ${noticia.categoria == 'Esporte' ? 'selected' : ''}>Esporte</option>
                            <option value="Cultura" ${noticia.categoria == 'Cultura' ? 'selected' : ''}>Cultura</option>
                        </select>

                        <div class="mb-3">
                            <label class="form-label">Resumo</label>
                            <textarea class="form-control" name="resumo" rows="3" required>${noticia.resumo}</textarea>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Conteúdo</label>
                            <textarea class="form-control" name="conteudo_completo" rows="6" required>${noticia.conteudo_completo}</textarea>
                        </div>

                        <button type="submit" class="btn btn-primary">Salvar</button>
                        <a href="index.jsp" class="btn btn-secondary">Cancelar</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<c:import url="includes/footer.jsp"/>