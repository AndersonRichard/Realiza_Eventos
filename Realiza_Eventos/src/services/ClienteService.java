package services;

import models.Cliente;
import java.util.ArrayList;

public class ClienteService {
    public static ArrayList<Cliente> dados;

    public ClienteService() {
        if (dados == null){
            dados = new ArrayList<>();
        }
    }

    // Cria o registro na base de dados
    public void create(Cliente registro){
        dados.add(registro);
    }

    // Retorna todos os registros
    public ArrayList<Cliente> read(){
        return dados;
    }

    // Retorna o registro com o id especificado
    public Cliente read(String id){
        for (Cliente registro : new ArrayList<>(dados)){
            if (registro.getId().equals(id)){
                return registro.clone();
            }
        }
        return null;
    }

    // Atualiza o registro
    public void update(Cliente registro){
        if (new ArrayList<>(dados).contains(registro)){
            dados.remove(registro);
            dados.add(registro);
        }
    }

    // Deleta o registro conforme o id informado
    public void delete(String id){
        for (Cliente registro : new ArrayList<>(dados)){
            if (registro.getId().equals(id)){
                dados.remove(registro);
            }
        }
    }
}
