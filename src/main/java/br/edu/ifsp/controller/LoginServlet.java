package br.edu.ifsp.controller;

import br.edu.ifsp.dao.UsuarioDAO;
import br.edu.ifsp.model.Usuario;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        request.setCharacterEncoding("UTF-8");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:63342");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        UsuarioDAO usuarioDAO = (UsuarioDAO) getServletContext()
                .getAttribute("usuarioDAO");

        Usuario usuario = usuarioDAO.buscarPorLogin(login);

        if (usuario != null && usuario.getSenha().equals(senha)) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);

            response.getWriter().print("{\"mensagem\":\"Login realizado com sucesso\"}");
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().print("{\"mensagem\":\"Login ou senha inválidos\"}");
        }
    }
}