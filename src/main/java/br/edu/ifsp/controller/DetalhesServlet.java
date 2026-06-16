package br.edu.ifsp.controller;

import br.edu.ifsp.dao.NoticiaDAO;
import br.edu.ifsp.model.Noticia;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/detalhes")
public class DetalhesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        response.setHeader("Access-Control-Allow-Origin", "http://localhost:63342");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        String idParam = request.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().print("{\"mensagem\":\"ID não informado\"}");
            return;
        }

        int id = Integer.parseInt(idParam);

        NoticiaDAO dao = (NoticiaDAO) getServletContext()
                .getAttribute("noticiaDAO");

        Noticia noticia = dao.buscarPorId(id);

        if (noticia == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().print("{\"mensagem\":\"Notícia não encontrada\"}");
            return;
        }

        String json = new Gson().toJson(noticia);

        response.getWriter().print(json);
    }
}