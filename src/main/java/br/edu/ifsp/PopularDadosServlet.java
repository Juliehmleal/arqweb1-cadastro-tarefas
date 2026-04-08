package br.edu.ifsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

@WebServlet(name = "PopularDadosServlet", value = "/popular_dados", loadOnStartup = 1)
public class PopularDadosServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();

        List<Noticia> listaNoticias = (List<Noticia>) getServletContext().getAttribute("listaNoticias");

        if(listaNoticias == null || listaNoticias.isEmpty()) {
            listaNoticias = new ArrayList<>();

            listaNoticias.add(new Noticia(
                    "Brasil conquista medalha de ouro nas Olimpíadas",
                    "João Silva",
                    "Esporte",
                    "A seleção brasileira fez uma partida histórica hoje, conquistando a medalha de ouro após uma vitória emocionante. O país inteiro comemorou a conquista que entra para a história do esporte nacional. Os atletas dedicaram a vitória às suas famílias e torcedores.",
                    "Seleção brasileira faz partida histórica e conquista ouro inédito.",
                    LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            ));

            listaNoticias.add(new Noticia(
                    "Nova lei de incentivo à cultura é aprovada",
                    "Maria Oliveira",
                    "Cultura",
                    "O congresso aprovou hoje a nova lei de incentivo à cultura que promete revolucionar o setor. Serão investidos R$ 500 milhões em projetos culturais em todo o país.",
                    "Lei de incentivo à cultura é aprovada com investimento de R$ 500 milhões.",
                    LocalDate.now().minusDays(2).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            ));

            listaNoticias.add(new Noticia(
                    "Startup brasileira inova no mercado de tecnologia",
                    "Carlos Santos",
                    "Tecnologia",
                    "Uma startup brasileira desenvolveu uma tecnologia inovadora que está chamando atenção no mundo todo. A solução promete revolucionar o mercado de energia limpa.",
                    "Tecnologia brasileira é destaque mundial em inovação.",
                    LocalDate.now().minusDays(5).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            ));

            getServletContext().setAttribute("listaNoticias", listaNoticias);
            System.out.println("Dados de exemplo carregados com sucesso!");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }
}