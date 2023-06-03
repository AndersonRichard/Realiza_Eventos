package services;

import models.Servico;

import java.util.ArrayList;

public class ServicoService {
    public static ArrayList<Servico> dados;

    public ServicoService() {
        if (dados == null){
            dados = new ArrayList<>();
        }
    }

    // Cria o registro na base de dados
    public void create(Servico registro){
        dados.add(registro);
    }

    // Retorna todos os registros
    public ArrayList<Servico> read(){
        return dados;
    }

    // Retorna o registro com o id especificado
    public Servico read(String id){
        for (Servico registro : new ArrayList<>(dados)){
            if (registro.getId().equals(id)){
                return registro.clone();
            }
        }
        return null;
    }

    // Atualiza o registro
    public void update(Servico registro){
        if (new ArrayList<>(dados).contains(registro)){
            dados.remove(registro);
            dados.add(registro);
        }
    }

    // Deleta o registro conforme o id informado
    public void delete(String id){
        for (Servico registro : new ArrayList<>(dados)){
            if (registro.getId().equals(id)){
                dados.remove(registro);
            }
        }
    }
}
