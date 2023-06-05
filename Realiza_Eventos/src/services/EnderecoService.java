package services;

import models.Endereco;
import java.util.ArrayList;

public class EnderecoService {

    public static ArrayList<Endereco> dados;

    public EnderecoService() {
        if (dados == null){ dados = load(); }
    }

    // Cria o registro na base de dados
    public void create(Endereco registro){
        dados.add(registro);
        save();
    }

    // Retorna todos os registros
    public ArrayList<Endereco> read(){
        return dados;
    }

    // Retorna o registro com o id especificado
    public Endereco read(String id){
        for (Endereco registro : new ArrayList<>(dados)){
            if (registro.getId().equals(id)){
                return registro.clone();
            }
        }
        return null;
    }

    // Atualiza o registro
    public void update(Endereco registro){
        if (new ArrayList<>(dados).contains(registro)){
            dados.remove(registro);
            dados.add(registro);
            save();
        }
    }

    // Deleta o registro conforme o id informado
    public boolean delete(String id){
        for (Endereco registro : new ArrayList<>(dados)){
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
        armazenamentoService.save(dados, "enderecos");
    }

    // Carrega os dados de um arquivo.dat
    private ArrayList<Endereco> load(){
        ArmazenamentoService armazenamentoService = new ArmazenamentoService();
        return (ArrayList<Endereco>) armazenamentoService.load("enderecos");
    }
}
