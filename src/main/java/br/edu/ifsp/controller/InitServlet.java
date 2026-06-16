package br.edu.ifsp.controller;

import br.edu.ifsp.dao.NoticiaDAO;
import br.edu.ifsp.dao.NoticiaJSONDAO;
import br.edu.ifsp.dao.UsuarioDAO;
import br.edu.ifsp.dao.UsuarioJSONDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(value = "/init", loadOnStartup = 1)
public class InitServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        NoticiaDAO noticiaDAO = new NoticiaJSONDAO();
        UsuarioDAO usuarioDAO = new UsuarioJSONDAO();

        // usuário teste para login
        usuarioDAO.inserir("admin", "123");

        getServletContext().setAttribute("noticiaDAO", noticiaDAO);
        getServletContext().setAttribute("usuarioDAO", usuarioDAO);

        System.out.println("DAOs carregados com sucesso!");
    }
}
