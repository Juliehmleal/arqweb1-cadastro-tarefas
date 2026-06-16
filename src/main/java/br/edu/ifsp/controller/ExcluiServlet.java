package br.edu.ifsp.controller;

import br.edu.ifsp.dao.NoticiaDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/excluir")
public class ExcluiServlet extends HttpServlet {

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

        if (idParam == null || idParam.trim().isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().print("{\"mensagem\":\"ID obrigatório\"}");
            return;
        }

        int id = Integer.parseInt(idParam);

        NoticiaDAO dao = (NoticiaDAO) getServletContext()
                .getAttribute("noticiaDAO");

        boolean removido = dao.remover(id);

        if (removido) {
            response.getWriter().print("{\"mensagem\":\"Notícia removida com sucesso\"}");
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().print("{\"mensagem\":\"Notícia não encontrada\"}");
        }
    }
}