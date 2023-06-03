package services;

import models.Cliente;

import java.util.ArrayList;

public class ClienteService extends ServiceBase<Cliente> {
    public static ArrayList<Cliente> dados;

    public ClienteService() {
        dados = super.dados;
    }
}
