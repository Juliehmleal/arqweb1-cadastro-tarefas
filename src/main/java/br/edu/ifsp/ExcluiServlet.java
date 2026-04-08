package br.edu.ifsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ExcluiServlet", value = "/exclui_noticia")
public class ExcluiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // code
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int id_inteiro = Integer.parseInt(id);
        String url = null;
        List<Noticia> lista = (List<Noticia>) getServletContext().getAttribute("lista");

        Noticia noticia_encontrada = null;

        for (int i=0; i<lista.size(); i++ )
        {
            Noticia aux = lista.get(i);

            if(aux.getId() == id_inteiro)
                noticia_encontrada = aux;
                lista.remove(aux);
        }

        url = "/index.jsp";

        //request.setAttribute("noticia", noticia_encontrada);

        getServletContext().getRequestDispatcher(url).forward(request,response);
    }
}