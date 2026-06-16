package br.edu.ifsp.controller;

import br.edu.ifsp.dao.NoticiaDAO;
import br.edu.ifsp.model.Noticia;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cadastrar")
public class CadastroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:63342");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("usuario") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().print("{\"mensagem\":\"Acesso não autorizado\"}");
            return;
        }

        request.setCharacterEncoding("UTF-8");

        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String categoria = request.getParameter("categoria");
        String conteudo = request.getParameter("conteudo_completo");
        String resumo = request.getParameter("resumo");
        String imagem = request.getParameter("imagem");

        if (imagem == null || imagem.trim().isEmpty()) {
            imagem = "imagens/padrao.jpg";
        }

        List<String> problemas = new ArrayList<>();

        if (titulo == null || titulo.trim().isEmpty()) problemas.add("O título é obrigatório");
        if (autor == null || autor.trim().isEmpty()) problemas.add("O autor é obrigatório");
        if (categoria == null || categoria.trim().isEmpty()) problemas.add("A categoria é obrigatória");
        if (conteudo == null || conteudo.trim().isEmpty()) problemas.add("O conteúdo é obrigatório");
        if (resumo == null || resumo.trim().isEmpty()) problemas.add("O resumo é obrigatório");

        if (!problemas.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().print(new Gson().toJson(
                    new RespostaErro("Campos inválidos", problemas)
            ));
            return;
        }

        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Noticia noticia = new Noticia(
                titulo,
                autor,
                categoria,
                conteudo,
                resumo,
                data,
                imagem,
                0
        );

        NoticiaDAO dao = (NoticiaDAO) getServletContext().getAttribute("noticiaDAO");
        dao.inserir(noticia);

        response.getWriter().print("{\"mensagem\":\"Notícia cadastrada com sucesso\"}");
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