package services;

import models.ModeloBase;

import java.util.ArrayList;

public class ServiceBase<E extends ModeloBase> {

    public ArrayList<E> dados;

    public ServiceBase(){
        dados = new ArrayList<>();
    }

    // Cria o registro na base de dados
    public void create(E registro){
        dados.add(registro);
    }

    // Retorna todos os registros
    public ArrayList<E> read(){
        return dados;
    }

    // Retorna o registro com o id especificado
    public E read(String id){
        for (E registro : new ArrayList<>(dados)){
            if (registro.getId().equals(id)){
                return (E)registro.clone();
            }
        }
        return null;
    }

    // Atualiza o registro
    public void update(E registro){
        if (new ArrayList<>(dados).contains(registro)){
            dados.remove(registro);
            dados.add(registro);
        }
    }

    // Deleta o registro conforme o id informado
    public void delete(String id){
        for (E registro : new ArrayList<>(dados)){
            if (registro.getId().equals(id)){
                dados.remove(registro);
            }
        }
    }

}
