package br.edu.ifsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

@WebServlet(name = "CadastroServlet", value = "/cadastrar_noticia", loadOnStartup = 0)
public class CadastroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/cadastro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = hoje.format(formatador);

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String titulo_noticia = request.getParameter("titulo");
        String autor_noticia = request.getParameter("autor");
        String categoria_noticia = request.getParameter("categoria");
        String conteudo_completo = request.getParameter("conteudo_completo");
        String resumo = request.getParameter("resumo");
        String imagem = "imagens/padrao.jpg";

        String url = null;
        List<String> listaMensagens = new ArrayList<>();

        // Validações de campos
        if(titulo_noticia == null || titulo_noticia.trim().isEmpty())
            listaMensagens.add("O campo título deve ser preenchido");

        if(autor_noticia == null || autor_noticia.trim().isEmpty())
            listaMensagens.add("O campo autor deve ser preenchido");

        if(categoria_noticia == null || categoria_noticia.trim().isEmpty())
            listaMensagens.add("O campo categoria deve ser preenchido");

        if(conteudo_completo == null || conteudo_completo.trim().isEmpty())
            listaMensagens.add("O campo conteúdo deve ser preenchido");

        if(resumo == null || resumo.trim().isEmpty())
            listaMensagens.add("O campo resumo deve ser preenchido");

        // Se houver erros, volta para o formulário
        if(!listaMensagens.isEmpty()){
            url = "/cadastro.jsp";
            request.setAttribute("lista_mensagens", listaMensagens);
        } else {
            // Criar nova notícia
            Noticia noticia = new Noticia(
                    titulo_noticia,
                    autor_noticia,
                    categoria_noticia,
                    conteudo_completo,
                    resumo,
                    dataFormatada,
                    imagem
            );

            // Obter a lista do contexto da aplicação
            List<Noticia> listaNoticias = (List<Noticia>) getServletContext().getAttribute("listaNoticias");

            // Se a lista não existir, criar uma nova
            if(listaNoticias == null) {
                listaNoticias = new ArrayList<>();
                getServletContext().setAttribute("listaNoticias", listaNoticias);
            }

            // Adicionar a notícia
            listaNoticias.add(noticia);

            // Salvar no contexto
            getServletContext().setAttribute("listaNoticias", listaNoticias);

            // Enviar notícia para a página de obrigado
            request.setAttribute("noticia", noticia);
            url = "/obrigado.jsp";
        }

        // Redirecionar
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

}