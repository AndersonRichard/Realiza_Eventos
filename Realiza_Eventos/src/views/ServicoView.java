package views;

import models.Servico;
import services.ServicoService;
import java.util.Scanner;

public class ServicoView {
    public void exibir() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar");
            System.out.println("2. Consultar");
            System.out.println("3. Deletar");
            System.out.println("4. Editar");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

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
        System.out.println("Preencha as informações:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        Servico servico = new Servico(nome, descricao);
        ServicoService servicoService = new ServicoService();
        servicoService.create(servico);
    }
    public void consultar(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Pesquisar por ID");
            System.out.println("2. Listar todos");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            ServicoService servicoService = new ServicoService();
            switch (opcao) {
                case 1:
                    System.out.println("Insira o ID: ");
                    String pesquisaEvento = scanner.nextLine();
                    scanner.nextLine();
                    Servico pesquisaId = servicoService.read(pesquisaEvento);
                    System.out.println(pesquisaId);
                    break;
                case 2:
                    System.out.println("Lista de todas as solicitações:");
                    System.out.println(servicoService.dados);
                    for (Servico servico : servicoService.read()) {
                        System.out.println(servico);
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    public void deletar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o ID: ");
        String deletaServico = scanner.nextLine();
        ServicoService servicoService = new ServicoService();
        servicoService.delete(deletaServico);
        System.out.println("Solicitação deletada com sucesso");
    }
    public void editar(){
        Scanner scanner = new Scanner(System.in);
        ServicoService servicoService = new ServicoService();
        System.out.println("Digite o Id: ");
        Servico servicoEncontrado = servicoService.read(scanner.nextLine());
        if (servicoEncontrado == null) {
            System.out.println("Opção não localizada!");
            return;
        }

        while (true) {
            System.out.println("Escolha um campo para editar:");
            System.out.println("1. Nome: " + servicoEncontrado.getNome());
            System.out.println("2. Descrição: " + servicoEncontrado.getDescricao());
            System.out.println("3. Salvar");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o novo valor para: ");
                    System.out.print("Nome: ");
                    servicoEncontrado.setNome(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Digite o novo valor para: ");
                    System.out.print("Descrição: ");
                    servicoEncontrado.setDescricao(scanner.nextLine());
                    break;
                case 3:
                    servicoService.update(servicoEncontrado);
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
