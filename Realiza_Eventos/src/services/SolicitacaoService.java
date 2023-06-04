package services;

import models.Solicitacao;
import java.util.ArrayList;

public class SolicitacaoService {
    public static ArrayList<Solicitacao> dados;

    public SolicitacaoService() {
        if (dados == null){
            dados = new ArrayList<>();
        }
    }

    // Cria o registro na base de dados
    public void create(Solicitacao registro){
        dados.add(registro);
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
        }
    }

    // Deleta o registro conforme o id informado
    public void delete(String id){
        for (Solicitacao registro : new ArrayList<>(dados)){
            if (registro.getId().equals(id)){
                dados.remove(registro);
            }
        }
    }
}
