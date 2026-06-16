package br.edu.ifsp.controller;

import br.edu.ifsp.dao.NoticiaDAO;
import br.edu.ifsp.model.Noticia;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/editar")
public class EditarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("usuario") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().print("{\"mensagem\":\"Acesso não autorizado\"}");
            return;
        }

        String idParam = request.getParameter("id");
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String categoria = request.getParameter("categoria");
        String conteudo = request.getParameter("conteudo_completo");
        String resumo = request.getParameter("resumo");
        String data = request.getParameter("data_publicacao");
        String imagem = request.getParameter("imagem");

        List<String> problemas = new ArrayList<>();

        if (idParam == null || idParam.trim().isEmpty()) problemas.add("ID obrigatório");
        if (titulo == null || titulo.trim().isEmpty()) problemas.add("Título obrigatório");
        if (autor == null || autor.trim().isEmpty()) problemas.add("Autor obrigatório");
        if (categoria == null || categoria.trim().isEmpty()) problemas.add("Categoria obrigatória");
        if (conteudo == null || conteudo.trim().isEmpty()) problemas.add("Conteúdo obrigatório");
        if (resumo == null || resumo.trim().isEmpty()) problemas.add("Resumo obrigatório");

        if (!problemas.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().print(new Gson().toJson(new RespostaErro("Campos inválidos", problemas)));
            return;
        }

        int id = Integer.parseInt(idParam);

        if (imagem == null || imagem.trim().isEmpty()) {
            imagem = "imagens/padrao.jpg";
        }

        NoticiaDAO dao = (NoticiaDAO) getServletContext().getAttribute("noticiaDAO");

        Noticia antiga = dao.buscarPorId(id);

        if (antiga == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().print("{\"mensagem\":\"Notícia não encontrada\"}");
            return;
        }

        Noticia atualizada = new Noticia(
                titulo,
                autor,
                categoria,
                conteudo,
                resumo,
                data != null && !data.trim().isEmpty() ? data : antiga.getData_publicacao(),
                imagem,
                antiga.getVisualizacoes()
        );

        atualizada.setId(id);

        dao.atualizar(atualizada);

        response.getWriter().print("{\"mensagem\":\"Notícia atualizada com sucesso\"}");
    }

    static class RespostaErro {
        String mensagem;
        List<String> problemas;

        RespostaErro(String mensagem, List<String> problemas) {
            this.mensagem = mensagem;
            this.problemas = problemas;
        }
    }
}