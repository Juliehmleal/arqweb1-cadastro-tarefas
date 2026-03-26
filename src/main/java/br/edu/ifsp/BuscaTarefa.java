package br.edu.ifsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//Sempre que for uma classe servlet começar passando o nome e o value
@WebServlet(name = "BuscaTarefa", value = "/busca_tarefa")

//Sempre vai ester HttpServlet
public class BuscaTarefa extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int id_inteiro = Integer.parseInt(id);

        String url = null;
        List<Tarefa> lista = (List<Tarefa>) getServletContext().getAttribute("lista");

        Tarefa tarefa_encontrada = null;

//        for (int i=0; i<lista.size(); i++ )
//        {
//            Tarefa aux = lista.get(i);
//
//            if(aux.getId() == id_inteiro)
//                tarefa_encontrada = aux;
//
//        }

        for(Tarefa t : lista){
            if(t.getId() == id_inteiro){

                tarefa_encontrada = t;
                break;

            }
        }

        if(tarefa_encontrada != null){
            request.setAttribute("tarefa", tarefa_encontrada);
            url = "/editar.jsp";
            System.out.println(url);
        }else{
            System.out.println("");
        }

        getServletContext().getRequestDispatcher(url).forward(request,response);
    }
}