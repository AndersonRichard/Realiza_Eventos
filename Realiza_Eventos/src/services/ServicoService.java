package services;

import models.Servico;
import java.util.ArrayList;

public class ServicoService {
    public static ArrayList<Servico> dados;

    public ServicoService() {
        if (dados == null){ dados = load(); }
    }

    // Cria o registro na base de dados
    public void create(Servico registro){
        dados.add(registro);
        save();
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
            save();
        }
    }

    // Deleta o registro conforme o id informado
    public boolean delete(String id){
        for (Servico registro : new ArrayList<>(dados)){
            if (registro.getId().equals(id)){
                dados.remove(registro);
                save();
                return true;
            }
        }
        return false;
    }

    // Salva os dados em um arquivo.dat
    public void save(){
        ArmazenamentoService armazenamentoService = new ArmazenamentoService();
        armazenamentoService.save(dados, "servicos");
    }

    // Carrega os dados de um arquivo.dat
    private ArrayList<Servico> load(){
        ArmazenamentoService armazenamentoService = new ArmazenamentoService();
        return (ArrayList<Servico>) armazenamentoService.load("servicos");
    }
}
