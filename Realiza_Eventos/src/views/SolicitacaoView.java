package views;

import models.Solicitacao;
import services.SolicitacaoService;
import java.util.ArrayList;
import java.util.Scanner;

public class SolicitacaoView {
    public void exibir() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|     Menu Solicitação                             |");
            System.out.println("|                                                  |");
            System.out.println("|   1. Consultar                                   |");
            System.out.println("|   2. Deletar                                     |");
            System.out.println("|   3. Gerar Relatório                             |");
            System.out.println("|   0. Voltar                                      |");
            System.out.println("|                                                  |");
            System.out.println("+--------------------------------------------------+");
            System.out.print("Digite uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());


            switch (opcao) {
                case 1:
                    System.out.println();
                    consultar();
                    break;
                case 2:
                    deletar();
                    break;
                case 3:
                    System.out.println();
                    Solicitacao solicitacaoSelecionada = selecionar();
                    if (solicitacaoSelecionada != null){
                        SolicitacaoService solicitacaoService = new SolicitacaoService();
                        System.out.println(solicitacaoService.exportTxt(solicitacaoSelecionada));
                        System.out.println("Relatório gerado com sucesso!");
                        System.out.println();
                        break;
                    }
                    System.out.println("Nenhuma solicitação foi selecionada.");
                    System.out.println();
                    break;
                case 0:
                    System.out.println();
                   return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    System.out.println();
            }
        }
    }
    public void consultar(){
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("+--------------------------------------------------+");
                System.out.println("|     Menu Consulta - Solicitação                  |");
                System.out.println("|                                                  |");
                System.out.println("|   1. Pesquisar por ID                            |");
                System.out.println("|   2. Listar todos                                |");
                System.out.println("|   0. Voltar                                      |");
                System.out.println("|                                                  |");
                System.out.println("+--------------------------------------------------+");
                System.out.print("Digite uma opção: ");
                int opcao = Integer.parseInt(scanner.nextLine());
                SolicitacaoService solicitacaoService = new SolicitacaoService();
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o ID:");
                        String pesquisaSolicitacao = scanner.nextLine();
                        Solicitacao pesquisaId = solicitacaoService.read(pesquisaSolicitacao);
                        if(pesquisaId == null){
                            System.out.println("Solicitação não encontrada");
                            System.out.println();
                            break;
                        }
                        System.out.println(pesquisaId);
                        break;
                    case 2:
                        System.out.println();
                        System.out.println("Lista de todas as solicitações:");
                        for (Solicitacao solicitacao : solicitacaoService.read()) {
                            System.out.println(solicitacao);
                            System.out.println("-----------------");
                        }

                        System.out.println();
                        break;
                    case 0:
                        System.out.println();
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        System.out.println();
                }
            }
    }

    public Solicitacao selecionar(){
        Scanner scanner = new Scanner(System.in);
        SolicitacaoService solicitacaoService = new SolicitacaoService();

        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|     Gerar Relatório                              |");
            System.out.println("|                                                  |");
            System.out.println("|  1. Selecionar por Id                            |");
            System.out.println("|  2. Selecionar na lista                          |");
            System.out.println("|  0. Voltar                                       |");
            System.out.println("|                                                  |");
            System.out.println("+--------------------------------------------------+");
            System.out.print("Digite uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Digite o Id: ");
                    Solicitacao solicitacaoEncontrada = solicitacaoService.read(scanner.nextLine());
                    if (solicitacaoEncontrada == null) {
                        System.out.println("Solicitação não localizada!");
                        System.out.println();
                        break;
                    }
                    return solicitacaoEncontrada;
                case 2:
                    ArrayList<Solicitacao> solicitacoes = solicitacaoService.read();
                    while(true){
                        System.out.println();
                        if (solicitacoes.size() > 0){ System.out.println(" -- SOLICITAÇÕES --");
                            System.out.println(); }
                        for (int i = 0; i < solicitacoes.size(); i++){
                            System.out.printf("%d. %s\n", i + 1, "Solicitação_" + solicitacoes.get(i).getId());
                        }
                        System.out.println("0. Voltar");
                        System.out.println();
                        System.out.print("Selecione uma opção: ");
                        opcao = Integer.parseInt(scanner.nextLine());
                        if (opcao == 0) { break; }
                        Solicitacao solicitacaoSelecionada = solicitacoes.get(opcao - 1);
                        if (solicitacaoSelecionada != null){
                            return solicitacaoSelecionada;
                        }
                        System.out.println("Opção inválida. Tente novamente.");
                        System.out.println();
                    }
                    break;
                case 0:
                    return null;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    System.out.println();
            }
        }
    }

    public void deletar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID:");
        String deletaSolicitacao = scanner.nextLine();
        SolicitacaoService solicitacaoService = new SolicitacaoService();
        if (solicitacaoService.delete(deletaSolicitacao)){
            System.out.println("Solicitação deletada com sucesso");
        }
        System.out.println();
    }

    }

