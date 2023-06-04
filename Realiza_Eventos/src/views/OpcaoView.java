package views;

import models.Opcao;
import services.OpcaoService;
import java.util.ArrayList;
import java.util.Scanner;

public class OpcaoView {

    public void exibir(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("+------------------------+");
            System.out.println("|  Escolha uma opção:   |");
            System.out.println("|                        |");
            System.out.println("|  1. Cadastrar          |");
            System.out.println("|  2. Consultar          |");
            System.out.println("|  3. Deletar            |");
            System.out.println("|  4. Editar             |");
            System.out.println("|  0. Voltar             |");
            System.out.println("|                        |");
            System.out.println("+------------------------+");
            System.out.print("Digite uma opção: ");
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
                    System.out.println();
            }
        }
    }

    public Opcao cadastrar(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("+--------------------------------------+");
        System.out.println("|     Digite o novo valor para:        |");
        System.out.print("|   Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.println("+--------------------------------------+");
        Opcao opcao = new Opcao(nome, descricao);

        OpcaoService opcaoService = new OpcaoService();
        opcaoService.create(opcao);
        return opcao;
    }

    public void consultar(){
        Scanner scanner = new Scanner(System.in);
        OpcaoService opcaoService = new OpcaoService();

        while (true) {
            System.out.println("+------------------------+");
            System.out.println("|  Selecione uma OPÇÃO   |");
            System.out.println("|                        |");
            System.out.println("|  1. Por Id             |");
            System.out.println("|  2. Da lista           |");
            System.out.println("|  0. Voltar             |");
            System.out.println("|                        |");
            System.out.println("+------------------------+");
            System.out.print("Digite uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("Digite o Id: ");
                    Opcao opcaoEncontrada = opcaoService.read(scanner.nextLine());
                    if (opcaoEncontrada == null) {
                        System.out.println("Opção não localizada!");
                        System.out.println();
                        break;
                    }
                    System.out.println(" -- OPÇÃO --");
                    System.out.println(opcaoEncontrada);
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
                    System.out.println();
            }
        }
    }

    public Opcao selecionar(){
        Scanner scanner = new Scanner(System.in);
        OpcaoService opcaoService = new OpcaoService();

        while (true) {
            System.out.println("+------------------------+");
            System.out.println("|  Selecione uma OPÇÃO   |");
            System.out.println("|                        |");
            System.out.println("|  1. Por Id             |");
            System.out.println("|  2. Da lista           |");
            System.out.println("|  0. Voltar             |");
            System.out.println("|                        |");
            System.out.println("+------------------------+");
            System.out.print("Digite uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("Digite o Id: ");
                    Opcao opcaoEncontrada = opcaoService.read(scanner.nextLine());
                    if (opcaoEncontrada == null) {
                        System.out.println("Opção não localizada!");
                        System.out.println();
                        break;
                    }
                    return opcaoEncontrada;
                case 2:
                    ArrayList<Opcao> opcoes = opcaoService.read();
                    while(true){
                        if (opcoes.size() > 0){ System.out.println(" -- OPÇÕES --"); }
                        for (int i = 0; i < opcoes.size(); i++){
                            System.out.printf("%d. %s\n", i + 1, opcoes.get(i).getNome());
                        }
                        System.out.println("0. Voltar");
                        System.out.print("Selecione uma opção: ");
                        System.out.println();
                        opcao = Integer.parseInt(scanner.nextLine());
                        if (opcao == 0) { break; }
                        Opcao opcaoSelecionada = opcoes.get(opcao - 1);
                        if (opcaoSelecionada != null){
                            return opcaoSelecionada;
                        }
                        System.out.println("Opção inválida. Tente novamente.");
                        System.out.println();
                    }
                    break;
                case 0:
                    return null;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    System.out.println();
            }
        }
    }

    public Opcao selecionar(ArrayList<Opcao> opcoesDisponiveis){
        Scanner scanner = new Scanner(System.in);
        OpcaoService opcaoService = new OpcaoService();

        while (true) {
            System.out.println("+------------------------+");
            System.out.println("|  Selecione uma OPÇÃO   |");
            System.out.println("|                        |");
            System.out.println("|  1. Por Id             |");
            System.out.println("|  2. Da lista           |");
            System.out.println("|  0. Voltar             |");
            System.out.println("|                        |");
            System.out.println("+------------------------+");
            System.out.print("Digite uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("Digite o Id: ");
                    Opcao opcaoEncontrada = opcaoService.read(scanner.nextLine());
                    if (opcaoEncontrada == null) {
                        System.out.println("Opção não localizada!");
                        System.out.println();
                        break;
                    }
                    return opcaoEncontrada;
                case 2:
                    while(true){
                        if (opcoesDisponiveis.size() > 0){ System.out.println(" -- OPÇÕES --"); }
                        for (int i = 0; i < opcoesDisponiveis.size(); i++){
                            System.out.printf("%d. %s\n", i + 1, opcoesDisponiveis.get(i).getNome());
                        }
                        System.out.println("0. Voltar");
                        System.out.print("Selecione uma opção: ");
                        System.out.println();
                        opcao = Integer.parseInt(scanner.nextLine());
                        if (opcao == 0) { break; }
                        Opcao opcaoSelecionada = opcoesDisponiveis.get(opcao - 1);
                        if (opcaoSelecionada != null){
                            return opcaoSelecionada;
                        }
                        System.out.println("Opção inválida. Tente novamente.");
                        System.out.println();
                    }
                    break;
                case 0:
                    return null;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    System.out.println();
            }
        }
    }

    public void deletar(){
        Scanner scanner = new Scanner(System.in);
        OpcaoService opcaoService = new OpcaoService();
        System.out.print("Digite o Id: ");
        opcaoService.delete(scanner.nextLine());
    }

    public void editar(){
        Scanner scanner = new Scanner(System.in);
        OpcaoService opcaoService = new OpcaoService();

        System.out.print("Digite o Id: ");
        Opcao opcaoEncontrada = opcaoService.read(scanner.nextLine());
        if (opcaoEncontrada == null) {
            System.out.println("Opção não localizada!");
            System.out.println();
            return;
        }

        while (true) {
            System.out.println("+---------------------------+");
            System.out.println("|   Escolha um campo para   |");
            System.out.println("|          editar:          |");
            System.out.println("|                           |");
            System.out.println("|   1. Nome: " + opcaoEncontrada.getNome() + "   |");
            System.out.println("|   2. Descrição: " + opcaoEncontrada.getDescricao() + "   |");
            System.out.println("|   3. Salvar               |");
            System.out.println("|   0. Voltar               |");
            System.out.println("|                           |");
            System.out.println("+---------------------------+");
            System.out.print("Digite uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("+--------------------------------------+");
                    System.out.println("|     Digite o novo valor para:        |");
                    System.out.print("|   Nome: ");
                    opcaoEncontrada.setNome(scanner.nextLine());
                    System.out.println("+--------------------------------------+");
                    break;
                case 2:
                    System.out.println("+--------------------------------------+");
                    System.out.println("|     Digite o novo valor para:        |");
                    System.out.print("|     Descrição: ");
                    opcaoEncontrada.setDescricao(scanner.nextLine());
                    System.out.println("+--------------------------------------+");
                    break;
                case 3:
                    opcaoService.update(opcaoEncontrada);
                    System.out.println("Seu registro foi atualizado com sucesso!");
                    System.out.println();
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    System.out.println();
            }
        }
    }

}
