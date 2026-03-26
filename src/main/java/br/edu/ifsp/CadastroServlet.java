package br.edu.ifsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

@WebServlet(name = "CadastroServlet", value = "/cadastrar_tarefa")
public class CadastroServlet extends HttpServlet {

    public static List<Tarefa> lista = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // code
        throw new RuntimeException();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();

        String nomeTarefa = request.getParameter("nome_tarefa");
        String descricaoTarefa = request.getParameter("descricao_tarefa");
        String url = null;

        List<String> listaMensagens = new ArrayList<>();


        if(nomeTarefa.isEmpty())
            listaMensagens.add("O campo tarefa deve ser preenchido");

        if(descricaoTarefa.isEmpty())
            listaMensagens.add("O campo descricao deve ser preenchido");

        if(!listaMensagens.isEmpty()){
            url = "/cadastro.jsp";
            request.setAttribute("lista_mensagens", listaMensagens);
        }else{
            Tarefa t = new Tarefa(nomeTarefa,descricaoTarefa);

            Object o = getServletContext().getAttribute("lista");
            if(o instanceof  ArrayList)
            {
                List<Tarefa> lista = (List<Tarefa>) getServletContext().getAttribute("lista");
                lista.add(t);
                getServletContext().setAttribute("lista", lista);
            }

            request.setAttribute("tarefa",t);
            url = "/obrigado.jsp";
        }

        getServletContext().getRequestDispatcher(url).forward(request,response);

    }

    @Override
    public void init() throws ServletException {
        super.init();
        // Adicionando lista vazia no contexto de aplicação
        lista = new ArrayList<>();
        getServletContext().setAttribute("lista", lista);
    }
}