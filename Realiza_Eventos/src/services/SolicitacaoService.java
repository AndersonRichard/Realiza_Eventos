package services;

import models.Solicitacao;

import java.util.ArrayList;

public class SolicitacaoService extends ServiceBase<Solicitacao> {
    public static ArrayList<Solicitacao> dados;

    public SolicitacaoService() {
        dados = super.dados;
    }
}
