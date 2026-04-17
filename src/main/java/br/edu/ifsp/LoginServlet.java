package br.edu.ifsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // Simples: aceita qualquer login
        if (email != null && senha != null) {

            HttpSession session = request.getSession();
            session.setAttribute("usuario", email);

            response.sendRedirect("index.jsp");
        }
    }
}