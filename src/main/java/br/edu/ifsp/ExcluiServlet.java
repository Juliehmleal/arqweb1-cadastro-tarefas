package br.edu.ifsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ExcluiServlet", value = "/exclui_tarefa")
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
        List<Tarefa> lista = (List<Tarefa>) getServletContext().getAttribute("lista");

        Tarefa tarefa_encontrada = null;

        for (int i=0; i<lista.size(); i++ )
        {
            Tarefa aux = lista.get(i);

            if(aux.getId() == id_inteiro)
                tarefa_encontrada = aux;
                lista.remove(aux);
        }

        url = "/index.jsp";

        //request.setAttribute("tarefa", tarefa_encontrada);

        getServletContext().getRequestDispatcher(url).forward(request,response);
    }
}