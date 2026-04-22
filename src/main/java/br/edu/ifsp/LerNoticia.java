package br.edu.ifsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LerNoticia", value = "/ler_noticia")
public class LerNoticia extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        List<Noticia> lista = (List<Noticia>) getServletContext().getAttribute("listaNoticias");

        Noticia noticia_encontrada = null;

        // Verifica se a lista ta existindo
        if (lista != null) {
            for (Noticia j : lista) {
                if (String.valueOf(j.getId()).equals(id)) {
                    noticia_encontrada = j;
                    break;
                }
            }
        }


        if (noticia_encontrada == null) {
            request.getRequestDispatcher("/noticia_nao_encontrada.jsp")
                    .forward(request, response);
            return;
        }


        request.setAttribute("noticia", noticia_encontrada);
        request.getRequestDispatcher("/noticia.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // não precisa usar aqui
    }
}