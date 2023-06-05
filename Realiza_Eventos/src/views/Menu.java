    package views;

    import java.util.Scanner;

    public class Menu {
        public void menuInicial() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("+--------------------------------------------------+");
                System.out.println("|   Bem-vindo ao sistema de eventos!               |");
                System.out.println("|   Escolha uma opção:                             |");
                System.out.println("|   1. Visão empresa                               |");
                System.out.println("|   2. Visão Cliente                               |");
                System.out.println("|   0. Sair                                        |");
                System.out.println("+--------------------------------------------------+");
                System.out.print("Digite uma opção: ");
                int opcao = Integer.parseInt(scanner.nextLine());


                switch (opcao) {
                    case 1:
                        System.out.println();
                        MenuEmpresa menuEmpresa = new MenuEmpresa();
                        menuEmpresa.exibir();
                        break;
                    case 2:
                        System.out.println();
                        MenuCliente menuCliente = new MenuCliente();
                        menuCliente.exibir();
                        break;
                    case 0:
                        System.out.println("Encerrando o programa.");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        System.out.println();

                }
            }
        }
    }
