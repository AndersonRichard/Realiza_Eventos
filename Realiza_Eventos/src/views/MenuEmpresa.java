package views;

import java.util.Scanner;

public class MenuEmpresa {
    public void exibir() {
        System.out.println("***REALIZA EVENTOS***");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Solicitação");
            System.out.println("2. Evento");
            System.out.println("3. Serviço");
            System.out.println("4. Opção");
            System.out.println("5. Endereco");
            System.out.println("6. Cliente");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    SolicitacaoView solicitacaoView = new SolicitacaoView();
                    solicitacaoView.exibir();
                    break;
                case 2:

                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        }
    }
