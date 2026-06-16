package br.edu.ifsp.model;

import java.io.Serializable;

public class Noticia implements Serializable {

    private static int id_atual = 0;

    private int id;
    private String titulo;
    private String autor;
    private String data_publicacao;
    private String resumo;
    private String conteudo_completo;
    private String categoria;
    private String imagem;
    private int visualizacoes;

    public Noticia() {
        this.id = ++id_atual;
    }

    public Noticia(String titulo, String autor, String categoria, String conteudo_completo,
                   String resumo, String data_publicacao, String imagem, int visualizacoes) {
        this();
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.conteudo_completo = conteudo_completo;
        this.resumo = resumo;
        this.data_publicacao = data_publicacao;
        this.imagem = imagem;
        this.visualizacoes = visualizacoes;
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

    public String getAutor() {
        return autor;
    }

    public String getData_publicacao() {
        return data_publicacao;
    }

    public String getResumo() {
        return resumo;
    }

    public String getConteudo_completo() {
        return conteudo_completo;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getVisualizacoes() {
        return visualizacoes;
    }

    public void setVisualizacoes(int visualizacoes) {
        this.visualizacoes = visualizacoes;
    }
}