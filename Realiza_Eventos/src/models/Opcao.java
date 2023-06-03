package models;

import java.util.HashMap;

public class Opcao extends ModeloBase{

    String nome;
    String descricao;

    public Opcao (String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getId() {
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


    public String toString() {
        return String.format("""
                %s
                Nome: %s
                Descrição: %s
                """,
                super.toString(),
                this.getNome(),
                this.getDescricao());
    }
}
