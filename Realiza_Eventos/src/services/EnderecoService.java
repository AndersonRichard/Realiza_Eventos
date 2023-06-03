package services;

import models.Endereco;
import models.Endereco;

import java.util.ArrayList;

public class EnderecoService {

    public static ArrayList<Endereco> dados;

    public EnderecoService() {
        if (dados == null){
            dados = new ArrayList<>();
        }
    }

    // Cria o registro na base de dados
    public void create(Endereco registro){
        dados.add(registro);
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
        }
    }

    // Deleta o registro conforme o id informado
    public void delete(String id){
        for (Endereco registro : new ArrayList<>(dados)){
            if (registro.getId().equals(id)){
                dados.remove(registro);
            }
        }
    }
}
