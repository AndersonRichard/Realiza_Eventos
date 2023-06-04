package models;

import java.util.ArrayList;

public class Servico extends ModeloBase {

    private String nome;
    private String descricao;
    private ArrayList<Opcao> opcoes;

    public Servico(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.opcoes = new ArrayList<>();
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

    public ArrayList<Opcao> getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(ArrayList<Opcao> opcoes) {
        this.opcoes = opcoes;
    }

    @Override
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
    public Servico clone(){
        Servico clone = new Servico(this.nome, this.descricao);
        clone.id = this.id;
        return clone;
    }
}
