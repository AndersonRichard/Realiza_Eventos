package views;

import java.util.Scanner;

public class SolicitacaoView {
    public void exibir() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Consultar");
            System.out.println("2. Deletar");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:

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
