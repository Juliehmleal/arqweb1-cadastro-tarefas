package br.edu.ifsp.dao;

import br.edu.ifsp.model.Usuario;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UsuarioJSONDAO implements UsuarioDAO {

    private final File arquivo = new File("usuarios.json");
    private final Gson gson = new Gson();

    private List<Usuario> lerArquivo() {
        try {
            if (!arquivo.exists()) {
                return new ArrayList<>();
            }

            Reader reader = new FileReader(arquivo);
            Type tipoLista = new TypeToken<List<Usuario>>(){}.getType();

            List<Usuario> usuarios = gson.fromJson(reader, tipoLista);
            reader.close();

            return usuarios != null ? usuarios : new ArrayList<>();

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void salvarArquivo(List<Usuario> usuarios) {
        try {
            Writer writer = new FileWriter(arquivo);
            gson.toJson(usuarios, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario inserir(String login, String senha) {
        List<Usuario> usuarios = lerArquivo();

        Usuario existente = buscarPorLogin(login);
        if (existente != null) {
            return existente;
        }

        Usuario usuario = new Usuario(login, senha);
        usuarios.add(usuario);

        salvarArquivo(usuarios);

        return usuario;
    }

    @Override
    public Usuario buscarPorLogin(String login) {
        List<Usuario> usuarios = lerArquivo();

        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                return usuario;
            }
        }

        return null;
    }

    @Override
    public List<Usuario> listar() {
        return lerArquivo();
    }
}