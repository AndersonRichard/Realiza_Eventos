package views;

import models.Solicitacao;
import services.SolicitacaoService;
import java.util.Scanner;

public class SolicitacaoView {
    public void exibir() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("+--------------------------------------+");
            System.out.println("|     Menu Solicitação                 |");
            System.out.println("|     Escolha uma opção:               |");
            System.out.println("|                                      |");
            System.out.println("|   1. Consultar                       |");
            System.out.println("|   2. Deletar                         |");
            System.out.println("|   0. Voltar                          |");
            System.out.println("|                                      |");
            System.out.println("+--------------------------------------+");
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
                System.out.println("+--------------------------------------+");
                System.out.println("|     Menu Solicitação                 |");
                System.out.println("|     Escolha uma opção:               |");
                System.out.println("|                                      |");
                System.out.println("|   1. Pesquisar por ID                |");
                System.out.println("|   2. Listar todos                    |");
                System.out.println("|   0. Voltar                          |");
                System.out.println("|                                      |");
                System.out.println("+--------------------------------------+");
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
                        System.out.println();
                        for (Solicitacao solicitacao : solicitacaoService.read()) {
                            System.out.println(solicitacao);
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
    public void deletar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID:");
        String deletaSolicitacao = scanner.nextLine();
        SolicitacaoService solicitacaoService = new SolicitacaoService();
        solicitacaoService.delete(deletaSolicitacao);
        System.out.println("Solicitação deletada com sucesso");
        System.out.println();
    }

    }

