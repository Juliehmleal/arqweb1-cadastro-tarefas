package br.edu.ifsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/buscar")
public class BuscarTexto extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String termo = request.getParameter("q");

        List<Noticia> lista =
                (List<Noticia>) getServletContext().getAttribute("listaNoticias");

        List<Noticia> resultados = new ArrayList<>();

        if (lista != null && termo != null) {
            termo = termo.toLowerCase();

            for (Noticia n : lista) {
                String titulo = n.getTitulo() != null ? n.getTitulo().toLowerCase() : "";
                String resumo = n.getResumo() != null ? n.getResumo().toLowerCase() : "";
                String conteudo = n.getConteudo_completo() != null ? n.getConteudo_completo().toLowerCase() : "";

                if (titulo.contains(termo) || resumo.contains(termo) || conteudo.contains(termo)) {
                    resultados.add(n);
                }
            }
        }

        request.setAttribute("resultados", resultados);
        request.setAttribute("termo", termo);

        request.getRequestDispatcher("resultado.jsp")
                .forward(request, response);
    }
}
