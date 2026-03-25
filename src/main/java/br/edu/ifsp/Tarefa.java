package br.edu.ifsp;

import java.io.Serializable;

public class Tarefa implements Serializable {

    private static int id_atual = 0;

    private int id;
    private String nome;
    private String descricao;

    public Tarefa(){
        this.id = ++id_atual;
    }

    public Tarefa(String nome, String descricao){
        this();
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
