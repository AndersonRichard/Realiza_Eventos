package views;

import models.Opcao;
import models.Servico;
import services.OpcaoService;
import services.ServicoService;

import java.util.ArrayList;
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
            System.out.println("5. Gerenciar Opções");
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
                case 5:
                    gerenciarOpcoes();
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
            int opcao = Integer.parseInt(scanner.nextLine());
            ServicoService servicoService = new ServicoService();
            switch (opcao) {
                case 1:
                    System.out.println("Insira o ID: ");
                    String pesquisaEvento = scanner.nextLine();
                    Servico pesquisaId = servicoService.read(pesquisaEvento);
                    if(pesquisaId == null){
                        System.out.println("Solicitação não encontrada");
                        break;
                    }
                    System.out.println(pesquisaId);
                    break;
                case 2:
                    System.out.println("Lista de todas as solicitações:");
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

    public Servico selecionar(){
        Scanner scanner = new Scanner(System.in);
        ServicoService servicoService = new ServicoService();

        while (true) {
            System.out.println("Selecione um SERVIÇO");
            System.out.println("1. Por Id");
            System.out.println("2. Da lista");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("Digite o Id: ");
                    Servico servicoEncontrado = servicoService.read(scanner.nextLine());
                    if (servicoEncontrado == null) {
                        System.out.println("Opção não localizada!");
                        break;
                    }
                    return servicoEncontrado;
                case 2:
                    ArrayList<Servico> servicos = servicoService.read();
                    while(true){
                        if (servicos.size() > 0){ System.out.println(" -- SERVIÇOS --"); }
                        for (int i = 0; i < servicos.size(); i++){
                            System.out.printf("%d. %s\n", i + 1, servicos.get(i).getNome());
                        }
                        System.out.println("0. Voltar");
                        System.out.print("Selecione uma opção: ");
                        opcao = Integer.parseInt(scanner.nextLine());
                        if (opcao == 0) { break; }
                        Servico servicoSelecionado = servicos.get(opcao - 1);
                        if (servicoSelecionado != null){
                            return servicoSelecionado;
                        }
                        System.out.println("Opção inválida. Tente novamente.");
                    }
                    break;
                case 0:
                    return null;
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
            int opcao = Integer.parseInt(scanner.nextLine());

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

    public void gerenciarOpcoes(){
        Scanner scanner = new Scanner(System.in);
        OpcaoView opcaoView = new OpcaoView();
        Servico servicoEncontrado = selecionar();
        if (servicoEncontrado == null) { return; }

        ArrayList<Opcao> opcoes = servicoEncontrado.getOpcoes();
        Opcao opcaoSelecionada;
        while (true) {
            System.out.println("Opções do serviço " + servicoEncontrado.getNome());
            System.out.println("1. Listar opções associadas");
            System.out.println("2. Associar existente");
            System.out.println("3. Cadastrar nova");
            System.out.println("4. Desassociar opção");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    if (opcoes.size() > 0) { System.out.println(" -- OPÇÕES --"); }
                    else { System.out.println("Nenhuma opção associada!"); }
                    for (Opcao opcao_ : opcoes){
                        System.out.println(opcao_);
                        System.out.println("-----");
                    }
                    break;
                case 2:
                    opcaoSelecionada =  opcaoView.selecionar();
                    if (opcaoSelecionada == null) { break; }
                    opcoes.add(opcaoSelecionada);
                    servicoEncontrado.setOpcoes(opcoes);
                    System.out.println("Opção " + opcaoSelecionada.getNome() + " associada!");
                    break;
                case 3:
                    opcaoSelecionada = opcaoView.cadastrar();
                    opcoes.add(opcaoSelecionada);
                    servicoEncontrado.setOpcoes(opcoes);
                    System.out.println("Opção " + opcaoSelecionada.getNome() + " associada!");
                    break;
                case 4:
                    if (opcoes.size() == 0) {
                        System.out.println("Nenhuma opção associada!");
                        break;
                    }
                    opcaoSelecionada =  opcaoView.selecionar(opcoes);
                    if (opcaoSelecionada == null) { break; }
                    opcoes.remove(opcaoSelecionada);
                    servicoEncontrado.setOpcoes(opcoes);
                    System.out.println("Opção " + opcaoSelecionada.getNome() + " desassociada!");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

}
