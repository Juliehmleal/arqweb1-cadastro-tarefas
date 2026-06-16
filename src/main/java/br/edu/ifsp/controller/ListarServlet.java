package br.edu.ifsp.controller;

import br.edu.ifsp.dao.NoticiaDAO;
import com.google.gson.Gson;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/listar")
public class ListarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        response.setHeader("Access-Control-Allow-Origin", "http://localhost:63342");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        NoticiaDAO noticiaDAO = (NoticiaDAO) getServletContext()
                .getAttribute("noticiaDAO");

        String json = new Gson().toJson(noticiaDAO.listar());

        response.getWriter().print(json);
    }
}
