package br.edu.ifsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LerNoticia", value = "/ler_noticia")
public class LerNoticia extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        List<Noticia> lista = (List<Noticia>) getServletContext().getAttribute("listaNoticias");

        for (Noticia j : lista) {
            if (String.valueOf(j.getId()).equals(id)) {
                request.setAttribute("noticia", j);
                break;
            }
        }


        request.getRequestDispatcher("/noticia.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // code
    }
}