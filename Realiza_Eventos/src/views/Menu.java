package views;

import java.util.Scanner;

public class Menu {
    public void menuInicial() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Bem-vindo ao sistema de eventos!");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Visão empresa");
            System.out.println("2. Visão Cliente");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    MenuEmpresa menuEmpresa = new MenuEmpresa();
                    menuEmpresa.exibir();
                    break;
                case 2://cliente
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
