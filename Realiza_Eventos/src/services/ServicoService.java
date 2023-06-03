package services;

import models.Servico;

import java.util.ArrayList;

public class ServicoService extends ServiceBase<Servico>{
    public static ArrayList<Servico> dados;

    public ServicoService() {
        dados = super.dados;
    }
}
