package models;

import java.util.ArrayList;
import java.util.HashMap;

public class Evento extends ModeloBase {

    private String nome;
    private String descricao;
    private HashMap <Integer, String> tipo;
    private ArrayList<Endereco> enderecos;
    private ArrayList<Servico> servicos;

    public Evento(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.enderecos = new ArrayList<>();
        this.servicos = new ArrayList<>();
        this.tipo = new HashMap<>();
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

    public HashMap<Integer, String> getTipo() {
        return tipo;
    }

    public void setTipo(HashMap<Integer, String> tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servico> servicos) {
        this.servicos = servicos;
    }

    @Override
    public String toString() {
        return String.format("""
                %s
                Nome: %s
                Descrição: %s
                """,
                super.toString(),
                this.nome,
                this.descricao);
    }
    public Evento clone(){
        Evento clone = new Evento(this.nome, this.descricao);
        clone.id = this.id;
        return clone;
    }
}
