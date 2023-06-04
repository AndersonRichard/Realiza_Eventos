package services;

import models.Opcao;
import java.util.ArrayList;

public class OpcaoService {

    public static ArrayList<Opcao> dados;

    public OpcaoService() {
        if (dados == null){ dados = load(); }
    }

    // Cria o registro na base de dados
    public void create(Opcao registro){
        dados.add(registro);
        save();
    }

    // Retorna todos os registros
    public ArrayList<Opcao> read(){
        return dados;
    }

    // Retorna o registro com o id especificado
    public Opcao read(String id){
        for (Opcao registro : new ArrayList<>(dados)){
            if (registro.getId().equals(id)){
                return registro.clone();
            }
        }
        return null;
    }

    // Atualiza o registro
    public void update(Opcao registro){
        if (new ArrayList<>(dados).contains(registro)){
            dados.remove(registro);
            dados.add(registro);
            save();
        }
    }

    // Deleta o registro conforme o id informado
    public void delete(String id){
        for (Opcao registro : new ArrayList<>(dados)){
            if (registro.getId().equals(id)){
                dados.remove(registro);
                save();
            }
        }
    }

    // Salva os dados em um arquivo.dat
    public void save(){
        ArmazenamentoService armazenamentoService = new ArmazenamentoService();
        armazenamentoService.save(dados, "opcoes");
    }

    // Carrega os dados de um arquivo.dat
    private ArrayList<Opcao> load(){
        ArmazenamentoService armazenamentoService = new ArmazenamentoService();
        return (ArrayList<Opcao>) armazenamentoService.load("opcoes");
    }
}
