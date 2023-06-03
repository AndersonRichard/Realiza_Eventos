package services;

import models.Evento;

import java.util.ArrayList;

public class EventoService extends ServiceBase<Evento> {
    public static ArrayList<Evento> dados;

    public EventoService() {
        dados = super.dados;
    }
}
