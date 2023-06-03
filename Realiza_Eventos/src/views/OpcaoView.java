package views;

import models.Opcao;
import services.OpcaoService;
import java.util.ArrayList;
import java.util.Scanner;

public class OpcaoView {

    public void exibir(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar");
            System.out.println("2. Consultar");
            System.out.println("3. Deletar");
            System.out.println("4. Editar");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    consultar();
                    break;
                case 3:
                    deletar();
                    break;
                case 4:
                    editar();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public void cadastrar(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Preencha os campos:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        Opcao opcao = new Opcao(nome, descricao);

        OpcaoService opcaoService = new OpcaoService();
        opcaoService.create(opcao);
    }

    public void consultar(){
        Scanner scanner = new Scanner(System.in);
        OpcaoService opcaoService = new OpcaoService();

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Pesquisar por Id");
            System.out.println("2. Listar todos");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("Digite o Id: ");
                    Opcao opcaoEncontrado = opcaoService.read(scanner.nextLine());
                    if (opcaoEncontrado == null) {
                        System.out.println("Opção não localizada!");
                        break;
                    }
                    System.out.println(" -- OPÇÃO --");
                    System.out.println(opcaoEncontrado);
                    break;
                case 2:
                    ArrayList<Opcao> opcoes = opcaoService.read();
                    if (opcoes.size() > 0){ System.out.println(" -- OPÇÕES --"); }
                    for (Opcao opcao_ : opcoes){
                        System.out.println(opcao_);
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

    public void deletar(){
        Scanner scanner = new Scanner(System.in);
        OpcaoService opcaoService = new OpcaoService();
        System.out.println("Digite o Id: ");
        opcaoService.delete(scanner.nextLine());
    }

    public void editar(){
        Scanner scanner = new Scanner(System.in);
        OpcaoService opcaoService = new OpcaoService();

        System.out.println("Digite o Id: ");
        Opcao opcaoEncontrada = opcaoService.read(scanner.nextLine());
        if (opcaoEncontrada == null) {
            System.out.println("Opção não localizada!");
            return;
        }

        while (true) {
            System.out.println("Escolha um campo para editar:");
            System.out.println("1. Nome: " + opcaoEncontrada.getNome());
            System.out.println("2. Descrição: " + opcaoEncontrada.getDescricao());
            System.out.println("3. Salvar");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("Digite o novo valor para: ");
                    System.out.print("Nome: ");
                    opcaoEncontrada.setNome(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Digite o novo valor para: ");
                    System.out.print("Descrição: ");
                    opcaoEncontrada.setDescricao(scanner.nextLine());
                    break;
                case 3:
                    opcaoService.update(opcaoEncontrada);
                    System.out.println("Seu registro foi atualizado com sucesso!");
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

}
