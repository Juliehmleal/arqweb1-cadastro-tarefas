package br.edu.ifsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CadastroServlet", value = "/cadastrar_noticia")
@MultipartConfig
public class CadastroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String usuario = (String) session.getAttribute("usuario");

        if (usuario == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        request.getRequestDispatcher("/cadastro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String usuario = (String) session.getAttribute("usuario");

        if (usuario == null) {
            response.sendRedirect("login.jsp");
            return;
        }

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

        String url;
        List<String> listaMensagens = new ArrayList<>();

        if (titulo_noticia == null || titulo_noticia.trim().isEmpty()) {
            listaMensagens.add("O campo título deve ser preenchido");
        }

        if (autor_noticia == null || autor_noticia.trim().isEmpty()) {
            listaMensagens.add("O campo autor deve ser preenchido");
        }

        if (categoria_noticia == null || categoria_noticia.trim().isEmpty()) {
            listaMensagens.add("O campo categoria deve ser preenchido");
        }

        if (conteudo_completo == null || conteudo_completo.trim().isEmpty()) {
            listaMensagens.add("O campo conteúdo deve ser preenchido");
        }

        if (resumo == null || resumo.trim().isEmpty()) {
            listaMensagens.add("O campo resumo deve ser preenchido");
        }

        Part arquivoImagem = request.getPart("imagem");

        if (arquivoImagem != null && arquivoImagem.getSize() > 0) {
            String tipoArquivo = arquivoImagem.getContentType();

            if (tipoArquivo != null && tipoArquivo.startsWith("image/")) {
                String nomeArquivo = arquivoImagem.getSubmittedFileName();

                String caminhoPasta = getServletContext().getRealPath("/imagens");
                File pasta = new File(caminhoPasta);

                if (!pasta.exists()) {
                    pasta.mkdir();
                }

                String nomeFinal = System.currentTimeMillis() + "_" + nomeArquivo;
                arquivoImagem.write(caminhoPasta + File.separator + nomeFinal);

                imagem = "imagens/" + nomeFinal;
            } else {
                listaMensagens.add("O arquivo enviado deve ser uma imagem");
            }
        }

        if (!listaMensagens.isEmpty()) {
            url = "/cadastro.jsp";
            request.setAttribute("lista_mensagens", listaMensagens);
        } else {
            Noticia noticia = new Noticia(
                    titulo_noticia,
                    autor_noticia,
                    categoria_noticia,
                    conteudo_completo,
                    resumo,
                    dataFormatada,
                    imagem
            );

            List<Noticia> listaNoticias =
                    (List<Noticia>) getServletContext().getAttribute("listaNoticias");

            if (listaNoticias == null) {
                listaNoticias = new ArrayList<>();
                getServletContext().setAttribute("listaNoticias", listaNoticias);
            }

            listaNoticias.add(noticia);
            getServletContext().setAttribute("listaNoticias", listaNoticias);

            request.setAttribute("noticia", noticia);
            url = "/obrigado.jsp";
        }

        request.getRequestDispatcher(url).forward(request, response);
    }
}