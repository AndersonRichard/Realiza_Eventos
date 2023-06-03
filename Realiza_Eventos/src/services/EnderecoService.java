package services;

import models.Endereco;

import java.util.ArrayList;

public class EnderecoService extends ServiceBase<Endereco> {

    public static ArrayList<Endereco> dados;

    public EnderecoService() {
        dados = super.dados;
    }
}
