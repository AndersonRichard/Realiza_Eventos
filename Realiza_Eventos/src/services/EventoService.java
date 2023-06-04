package services;

import models.Evento;
import java.util.ArrayList;

public class EventoService {
    public static ArrayList<Evento> dados;

    public EventoService() {
        if (dados == null){
            dados = new ArrayList<>();
        }
    }

    // Cria o registro na base de dados
    public void create(Evento registro){
        dados.add(registro);
    }

    // Retorna todos os registros
    public ArrayList<Evento> read(){
        return dados;
    }

    // Retorna o registro com o id especificado
    public Evento read(String id){
        for (Evento registro : new ArrayList<>(dados)){
            if (registro.getId().equals(id)){
                return registro.clone();
            }
        }
        return null;
    }

    // Atualiza o registro
    public void update(Evento registro){
        if (new ArrayList<>(dados).contains(registro)){
            dados.remove(registro);
            dados.add(registro);
        }
    }

    // Deleta o registro conforme o id informado
    public void delete(String id){
        for (Evento registro : new ArrayList<>(dados)){
            if (registro.getId().equals(id)){
                dados.remove(registro);
            }
        }
    }
}
