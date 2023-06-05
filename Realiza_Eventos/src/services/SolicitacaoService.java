package services;

import models.Opcao;
import models.Servico;
import models.Solicitacao;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class SolicitacaoService {
    public static ArrayList<Solicitacao> dados;

    public SolicitacaoService() {
        if (dados == null){ dados = load(); }
    }

    // Cria o registro na base de dados
    public void create(Solicitacao registro){
        dados.add(registro);
        save();
    }

    // Retorna todos os registros
    public ArrayList<Solicitacao> read(){
        return dados;
    }

    // Retorna o registro com o id especificado
    public Solicitacao read(String id){
        for (Solicitacao registro : new ArrayList<>(dados)){
            if (registro.getId().equals(id)){
                return registro.clone();
            }
        }
        return null;
    }

    // Atualiza o registro
    public void update(Solicitacao registro){
        if (new ArrayList<>(dados).contains(registro)){
            dados.remove(registro);
            dados.add(registro);
            save();
        }
    }

    // Deleta o registro conforme o id informado
    public boolean delete(String id){
        for (Solicitacao registro : new ArrayList<>(dados)){
            if (registro.getId().equals(id)){
                ClienteService clienteService = new ClienteService();
                dados.remove(registro);
                clienteService.delete(registro.getCliente().getId());
                save();
                return true;
            }
        }
        return false;
    }

    // Salva os dados em um arquivo.dat
    public void save(){
        ArmazenamentoService armazenamentoService = new ArmazenamentoService();
        armazenamentoService.save(dados, "solicitacoes");
    }

    // Carrega os dados de um arquivo.dat
    private ArrayList<Solicitacao> load(){
        ArmazenamentoService armazenamentoService = new ArmazenamentoService();
        return (ArrayList<Solicitacao>) armazenamentoService.load("solicitacoes");
    }

    public String exportTxt(Solicitacao solicitacao){
        String relatorio = String.format(
                """
                  ========================================================================================
                    SOLICITAÇÃO DE ORÇAMENTO
                Id: %s
                Data: %s
                
                    DADOS DO EVENTO
                Evento: %s
                Descrição: %s
                
                Serviços:
                """
                ,
                solicitacao.getId(),
                solicitacao.getDataHoraDaSolicitacaoStr(),
                solicitacao.getEvento().getNome(),
                solicitacao.getEvento().getDescricao());

        for (Servico servico : solicitacao.getEvento().getServicos()){
            relatorio += String.format("\t%s\n\t* %s\n", servico.getNome(), servico.getDescricao());
            for (Opcao opcao : servico.getOpcoes()){
                relatorio += String.format("\t\t%s\n\t\t* %s\n", opcao.getNome(), opcao.getDescricao());
            }
        }

        relatorio += String.format("""
                Endereço: %s
                Inicio: %s
                Término: %s
                Observações: %s
                
                    INFORMAÇÕES DO CLIENTE
                Nome: %s
                Telefone: %s
                E-mail: %s
                
                  ========================================================================================
                """
                ,
                solicitacao.getEnderecoSelecionado().stringFormatada(),
                solicitacao.getInicioEventoDataHora(),
                solicitacao.getTerminoEventoDataHora(),
                solicitacao.getObservacoes(),
                solicitacao.getCliente().getNome(),
                solicitacao.getCliente().getTelefone(),
                solicitacao.getCliente().getEmail()
        );

        String absPath = new File("").getAbsolutePath() + "\\relatorios\\";
        try{
            Files.createDirectories(Path.of(absPath));
            OutputStreamWriter bufferOut = new OutputStreamWriter(
                    new FileOutputStream(absPath + "Solicitacao_" + solicitacao.getId() + ".txt"),"UTF-8");
            bufferOut.write(relatorio);
            bufferOut.close();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        return absPath + "Solicitacao_" + solicitacao.getId() + ".txt";
    }
}
