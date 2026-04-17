
package br.edu.ifsp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//Sempre que for uma classe servlet começar passando o nome e o value
@WebServlet(name = "EditaServlet", value = "/editar_noticia")

//Sempre vai ester HttpServlet
public class EditarServlet extends HttpServlet {

    public static List<Noticia> lista = null;


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

        request.getRequestDispatcher("/editar.jsp").forward(request, response);
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String id = request.getParameter("id");
        int id_inteiro = Integer.parseInt(id);

        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = hoje.format(formatador);

        String titulo_noticia = request.getParameter("titulo");
        String autor_noticia = request.getParameter("autor");
        String categoria_noticia = request.getParameter("categoria");
        String conteudo_completo = request.getParameter("conteudo_completo");
        String resumo = request.getParameter("resumo");
        String url = null;


        List<Noticia> lista = (List<Noticia>) getServletContext().getAttribute("listaNoticias");

        for(Noticia t : lista){
            if(t.getId() == id_inteiro){
                lista.remove(t);
                break;
            }
        }

        List<String> listaMensagens = new ArrayList<>();

        if(titulo_noticia.isEmpty())
            listaMensagens.add("O campo noticia deve ser preenchido");

        if(autor_noticia.isEmpty())
            listaMensagens.add("O campo descricao deve ser preenchido");

        if(!listaMensagens.isEmpty()){
            url = "/cadastro.jsp";
            request.setAttribute("lista_mensagens", listaMensagens);
        }else{
            Noticia t = new Noticia(titulo_noticia,autor_noticia, categoria_noticia, conteudo_completo, resumo, dataFormatada);

            lista.add(t);
            getServletContext().setAttribute("listaNoticias", lista);

            request.setAttribute("noticia",t);
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
