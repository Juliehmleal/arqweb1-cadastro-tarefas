package br.edu.ifsp.dao;

import br.edu.ifsp.model.Noticia;
import java.util.List;

public interface NoticiaDAO {

    Noticia inserir(Noticia noticia);

    List<Noticia> listar();

    Noticia buscarPorId(int id);

    Noticia atualizar(Noticia noticia);

    boolean remover(int id);
}
