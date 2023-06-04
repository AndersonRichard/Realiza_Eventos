package services;

import models.Solicitacao;
import java.util.ArrayList;

public class SolicitacaoService {
    public static ArrayList<Solicitacao> dados;

    public SolicitacaoService() {
        if (dados == null){ dados = load(); }
    }

    // Cria o registro na base de dados
    public void create(Solicitacao registro){
        dados.add(registro);
        save();
    }

    // Retorna todos os registros
    public ArrayList<Solicitacao> read(){
        return dados;
    }

    // Retorna o registro com o id especificado
    public Solicitacao read(String id){
        for (Solicitacao registro : new ArrayList<>(dados)){
            if (registro.getId().equals(id)){
                return registro.clone();
            }
        }
        return null;
    }

    // Atualiza o registro
    public void update(Solicitacao registro){
        if (new ArrayList<>(dados).contains(registro)){
            dados.remove(registro);
            dados.add(registro);
            save();
        }
    }

    // Deleta o registro conforme o id informado
    public void delete(String id){
        for (Solicitacao registro : new ArrayList<>(dados)){
            if (registro.getId().equals(id)){
                dados.remove(registro);
                save();
            }
        }
    }

    // Salva os dados em um arquivo.dat
    public void save(){
        ArmazenamentoService armazenamentoService = new ArmazenamentoService();
        armazenamentoService.save(dados, "solicitacoes");
    }

    // Carrega os dados de um arquivo.dat
    private ArrayList<Solicitacao> load(){
        ArmazenamentoService armazenamentoService = new ArmazenamentoService();
        return (ArrayList<Solicitacao>) armazenamentoService.load("solicitacoes");
    }
}
