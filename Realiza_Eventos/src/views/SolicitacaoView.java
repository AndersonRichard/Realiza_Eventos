package views;

import models.Solicitacao;
import services.SolicitacaoService;
import java.util.Scanner;

public class SolicitacaoView {
    public void exibir() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Consultar");
            System.out.println("2. Deletar");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    consultar();
                    break;
                case 2:
                    deletar();
                    break;
                case 0:
                   return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    public void consultar(){
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Escolha uma opção:");
                System.out.println("1. Pesquisar por ID");
                System.out.println("2. Listar todos");
                System.out.println("0. Voltar");
                System.out.print("Opção: ");
                int opcao = scanner.nextInt();
                SolicitacaoService solicitacaoService = new SolicitacaoService();
                switch (opcao) {
                    case 1:
                        System.out.println("Insira o ID: ");
                        scanner.nextLine();
                        String pesquisaSolicitacao = scanner.nextLine();
                        Solicitacao pesquisaId = solicitacaoService.read(pesquisaSolicitacao);
                        if(pesquisaId == null){
                            System.out.println("Solicitação não encontrada");
                            break;
                        }
                        System.out.println(pesquisaId);
                        break;
                    case 2:
                        System.out.println("Lista de todas as solicitações:");
                        for (Solicitacao solicitacao : solicitacaoService.read()) {
                            System.out.println(solicitacao);
                        }
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
    }
    public void deletar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o ID: ");
        String deletaSolicitacao = scanner.nextLine();
        SolicitacaoService solicitacaoService = new SolicitacaoService();
        solicitacaoService.delete(deletaSolicitacao);
        System.out.println("Solicitação deletada com sucesso");
    }

    }

