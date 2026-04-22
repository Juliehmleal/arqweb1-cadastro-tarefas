<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="includes/header.jsp"/>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header bg-primary text-white">
                    <h3 class="mb-0">Nova Notícia</h3>
                </div>
                <div class="card-body">

                    <form action="cadastrar_noticia" method="POST" enctype="multipart/form-data">
                        <div class="mb-3">
                            <label class="form-label">Título</label>
                            <input type="text" class="form-control" name="titulo" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Autor</label>
                            <input type="text" class="form-control" name="autor" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Categoria</label>
                            <select class="form-select" name="categoria" required>
                                <option value="">Selecione...</option>
                                <option value="Política">Política</option>
                                <option value="Esporte">Esporte</option>
                                <option value="Cultura">Cultura</option>
                            </select>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Resumo</label>
                            <textarea class="form-control" name="resumo" rows="3" required></textarea>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Conteúdo</label>
                            <textarea class="form-control" name="conteudo_completo" rows="6" required></textarea>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Imagem</label>
                            <input type="file" class="form-control" name="imagem" accept="image/*">
                        </div>

                        <div class="d-grid gap-2">
                            <button type="submit" class="btn btn-primary" style="margin-bottom: 15px;">Salvar</button>
                            <a href="index.jsp" class="btn btn-secondary">Cancelar</a>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

<c:import url="includes/footer.jsp"/>