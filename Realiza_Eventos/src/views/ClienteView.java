package views;

import models.Cliente;
import services.ClienteService;
import java.util.ArrayList;
import java.util.Scanner;

public class ClienteView {

    public void exibir(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|     Menu Cliente                                 |");
            System.out.println("|                                                  |");
            System.out.println("|  1. Consultar                                    |");
            System.out.println("|  0. Voltar                                       |");
            System.out.println("|                                                  |");
            System.out.println("+--------------------------------------------------+");
            System.out.print("Digite uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    consultar();
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
        ClienteService clienteService = new ClienteService();

        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|     Menu Consulta - Cliente                      |");
            System.out.println("|                                                  |");
            System.out.println("|   1. Pesquisar por ID                            |");
            System.out.println("|   2. Listar todos                                |");
            System.out.println("|   0. Voltar                                      |");
            System.out.println("|                                                  |");
            System.out.println("+--------------------------------------------------+");
            System.out.print("Digite uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Digite o Id: ");
                    Cliente clienteEncontrado = clienteService.read(scanner.nextLine());
                    if (clienteEncontrado == null) {
                        System.out.println("Cliente não localizado!");
                        System.out.println();
                        break;
                    }
                    System.out.println(" -- CLIENTE --");
                    System.out.println();
                    System.out.println(clienteEncontrado);
                    break;
                case 2:
                    ArrayList<Cliente> clientes = clienteService.read();
                    if (clientes.size() > 0){ System.out.println(" -- CLIENTES --");
                        System.out.println(); }
                    for (Cliente cliente : clientes){
                        System.out.println(cliente);
                        System.out.println("-----");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    System.out.println();
            }
        }
    }

}
