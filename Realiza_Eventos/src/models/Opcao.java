package models;

import java.util.HashMap;

public class Opcao extends ModeloBase{

    private String nome;
    private String descricao;

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
                Id: %s
                Nome: %s
                Descrição: %s
                """,
                this.id,
                this.nome,
                this.descricao);
    }
    public Opcao clone(){
        Opcao clone = new Opcao(this.nome, this.descricao);
        clone.id = this.id;
        return clone;
    }
}
