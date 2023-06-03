package views;

import java.util.Scanner;

public class MenuCliente {
    public static void iniciarVisaoCliente() {
        System.out.println("***REALIZA EVENTOS***");
        Scanner scanner = new Scanner(System.in);
        boolean voltarMenu = false;

        while (!voltarMenu) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Solicitar orçamento");
            System.out.println("2. Contato Realiza Eventos");
            System.out.println("3. Voltar ao menu anterior");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Solicitar orçamento");
                    break;
                case 2:
                    System.out.println("Contato Realiza Eventos");
                    break;
                case 3:
                    voltarMenu = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

    }

}
