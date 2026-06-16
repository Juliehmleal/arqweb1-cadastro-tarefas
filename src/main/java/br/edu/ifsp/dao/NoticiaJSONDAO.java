package br.edu.ifsp.dao;

import br.edu.ifsp.model.Noticia;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class NoticiaJSONDAO implements NoticiaDAO {

    private final File arquivo = new File("noticias.json");
    private final Gson gson = new Gson();

    private List<Noticia> lerArquivo() {
        try {
            if (!arquivo.exists()) {
                return new ArrayList<>();
            }

            Reader reader = new FileReader(arquivo);
            Type tipoLista = new TypeToken<List<Noticia>>(){}.getType();

            List<Noticia> noticias = gson.fromJson(reader, tipoLista);
            reader.close();

            return noticias != null ? noticias : new ArrayList<>();

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void salvarArquivo(List<Noticia> noticias) {
        try {
            Writer writer = new FileWriter(arquivo);
            gson.toJson(noticias, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int gerarProximoId(List<Noticia> noticias) {
        int maiorId = 0;

        for (Noticia noticia : noticias) {
            if (noticia.getId() > maiorId) {
                maiorId = noticia.getId();
            }
        }

        return maiorId + 1;
    }

    @Override
    public Noticia inserir(Noticia noticia) {
        List<Noticia> noticias = lerArquivo();

        noticia.setId(gerarProximoId(noticias));

        noticias.add(noticia);
        salvarArquivo(noticias);

        return noticia;
    }

    @Override
    public List<Noticia> listar() {
        return lerArquivo();
    }

    @Override
    public Noticia buscarPorId(int id) {
        List<Noticia> noticias = lerArquivo();

        for (Noticia noticia : noticias) {
            if (noticia.getId() == id) {
                return noticia;
            }
        }

        return null;
    }

    @Override
    public Noticia atualizar(Noticia noticiaAtualizada) {
        List<Noticia> noticias = lerArquivo();

        for (int i = 0; i < noticias.size(); i++) {
            if (noticias.get(i).getId() == noticiaAtualizada.getId()) {
                noticias.set(i, noticiaAtualizada);
                salvarArquivo(noticias);
                return noticiaAtualizada;
            }
        }

        return null;
    }

    @Override
    public boolean remover(int id) {
        List<Noticia> noticias = lerArquivo();

        boolean removido = noticias.removeIf(n -> n.getId() == id);

        if (removido) {
            salvarArquivo(noticias);
        }

        return removido;
    }
}