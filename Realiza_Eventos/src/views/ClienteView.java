package views;

import models.Cliente;
import services.ClienteService;

import java.util.ArrayList;
import java.util.Scanner;

public class ClienteView {

    public void exibir(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Consultar");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    consultar();
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
        ClienteService clienteService = new ClienteService();

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Pesquisar por Id");
            System.out.println("2. Listar todos");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o Id: ");
                    Cliente clienteEncontrado = clienteService.read(scanner.nextLine());
                    if (clienteEncontrado == null) {
                        System.out.println("Cliente não localizado!");
                        break;
                    }
                    System.out.println(" -- CLIENTE --");
                    System.out.println(clienteEncontrado);
                    break;
                case 2:
                    ArrayList<Cliente> clientes = clienteService.read();
                    if (clientes.size() > 0){ System.out.println(" -- CLIENTES --"); }
                    for (Cliente cliente : clientes){
                        System.out.println(cliente);
                        System.out.println("-----");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

}
