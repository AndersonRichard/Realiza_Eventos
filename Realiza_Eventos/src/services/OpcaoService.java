package services;

import models.Opcao;

import java.util.ArrayList;

public class OpcaoService extends ServiceBase<Opcao> {

    public static ArrayList<Opcao> dados;

    public OpcaoService(){
        dados = super.dados;
    }

}
