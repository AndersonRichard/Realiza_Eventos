package views;

import java.util.Scanner;

public class MenuEmpresa {
    public void exibir() {
        System.out.println("+--------------------------------------+");
        System.out.println("|       ***REALIZA EVENTOS***          |");
        System.out.println("+--------------------------------------+");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("+--------------------------------------+");
            System.out.println("|   Bem vindo ao Menu Administração    |");
            System.out.println("|                                      |");
            System.out.println("|   1. Solicitação                     |");
            System.out.println("|   2. Evento                          |");
            System.out.println("|   3. Serviço                         |");
            System.out.println("|   4. Opção                           |");
            System.out.println("|   5. Endereço                        |");
            System.out.println("|   6. Cliente                         |");
            System.out.println("|   0. Voltar                          |");
            System.out.println("|                                      |");
            System.out.println("+--------------------------------------+");
            System.out.print("Digite uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());
            System.out.println();

            switch (opcao) {
                case 1:
                    SolicitacaoView solicitacaoView = new SolicitacaoView();
                    solicitacaoView.exibir();
                    break;
                case 2:
                    EventoView eventoView = new EventoView();
                    eventoView.exibir();
                    break;
                case 3:
                    ServicoView servicoView = new ServicoView();
                    servicoView.exibir();
                    break;
                case 4:
                    OpcaoView opcaoView = new OpcaoView();
                    opcaoView.exibir();
                    break;
                case 5:
                    EnderecoView enderecoView = new EnderecoView();
                    enderecoView.exibir();
                    break;
                case 6:
                    ClienteView clienteView = new ClienteView();
                    clienteView.exibir();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        }
    }

