package br.edu.ifsp;

import java.io.Serializable;
import java.util.Date;

public class Noticia implements Serializable {

    private static int id_atual = 0;

    private int id;
    private String titulo;
    private String autor;
    private String data_publicacao;
    private String resumo;
    private String conteudo_completo;
    private String categoria;

    public Noticia () {this.id = ++id_atual;}

    public Noticia(String titulo, String autor, String categoria, String conteudo_completo, String resumo, String data_publicacao) {
        this();
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.conteudo_completo = conteudo_completo;
        this.resumo = resumo;
        this.data_publicacao = data_publicacao;
    }


    public static int getId_atual() {
        return id_atual;
    }

    public static void setId_atual(int id_atual) {
        Noticia.id_atual = id_atual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getData_publicacao() {
        return data_publicacao;
    }

    public void setData_publicacao(String data_publicacao) {
        this.data_publicacao = data_publicacao;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getConteudo_completo() {
        return conteudo_completo;
    }

    public void setConteudo_completo(String conteudo_completo) {
        this.conteudo_completo = conteudo_completo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
