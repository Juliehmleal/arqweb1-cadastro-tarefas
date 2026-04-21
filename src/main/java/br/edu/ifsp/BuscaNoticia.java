package br.edu.ifsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//Sempre que for uma classe servlet começar passando o nome e o value
@WebServlet(name = "BuscaNoticia", value = "/busca_noticia")

//Sempre vai ester HttpServlet
public class BuscaNoticia extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int id_inteiro = Integer.parseInt(id);

        String url = null;
        List<Noticia> lista = (List<Noticia>) getServletContext().getAttribute("listaNoticias");

        Noticia noticia_encontrada = null;

//        for (int i=0; i<lista.size(); i++ )
//        {
//            Noticia aux = lista.get(i);
//
//            if(aux.getId() == id_inteiro)
//                noticia_encontrada = aux;
//
//        }

        for(Noticia t : lista){
            if(t.getId() == id_inteiro){

                noticia_encontrada = t;
                break;

            }
        }

        if(noticia_encontrada != null){
            request.setAttribute("noticia", noticia_encontrada);
            url = "/noticia.jsp";
            System.out.println(url);
        }else{
            url = "/erro.jsp";
        }

        getServletContext().getRequestDispatcher(url).forward(request,response);
    }
}