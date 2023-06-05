package services;

import models.Evento;
import java.util.ArrayList;

public class EventoService {
    public static ArrayList<Evento> dados;

    public EventoService() {
        if (dados == null){ dados = load(); }
    }

    // Cria o registro na base de dados
    public void create(Evento registro){
        dados.add(registro);
        save();
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
            save();
        }
    }

    // Deleta o registro conforme o id informado
    public boolean delete(String id){
        for (Evento registro : new ArrayList<>(dados)){
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
        armazenamentoService.save(dados, "eventos");
    }

    // Carrega os dados de um arquivo.dat
    private ArrayList<Evento> load(){
        ArmazenamentoService armazenamentoService = new ArmazenamentoService();
        return (ArrayList<Evento>) armazenamentoService.load("eventos");
    }
}
