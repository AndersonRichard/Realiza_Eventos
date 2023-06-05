package views;

import models.Endereco;
import models.Evento;
import models.Servico;
import services.EventoService;
import java.util.ArrayList;
import java.util.Scanner;

public class EventoView {
    public void exibir() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|     Menu Evento                                  |");
            System.out.println("|                                                  |");
            System.out.println("|   1. Cadastrar                                   |");
            System.out.println("|   2. Consultar                                   |");
            System.out.println("|   3. Deletar                                     |");
            System.out.println("|   4. Editar                                      |");
            System.out.println("|   5. Gerenciar Serviços                          |");
            System.out.println("|   6. Gerenciar Endereços                         |");
            System.out.println("|   0. Voltar                                      |");
            System.out.println("|                                                  |");
            System.out.println("+--------------------------------------------------+");
            System.out.print("Digite uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    System.out.println();
                    consultar();
                    break;
                case 3:
                    deletar();
                    break;
                case 4:
                    editar();
                    break;
                case 5:
                    gerenciarServicos();
                    break;
                case 6:
                    gerenciarEnderecos();
                    break;
                case 0:
                    System.out.println();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    public void cadastrar(){
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("+--------------------------------------------------+");
        System.out.println("|     Preencha as informações:                     |");
        System.out.println("+--------------------------------------------------+");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição:");
        String descricao = scanner.nextLine();
        System.out.println();
        Evento evento = new Evento(nome, descricao);
        EventoService eventoService = new EventoService();
        eventoService.create(evento);
    }
    public void consultar(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|     Menu Consulta                                |");
            System.out.println("|                                                  |");
            System.out.println("|   1. Pesquisar por ID                            |");
            System.out.println("|   2. Listar todos                                |");
            System.out.println("|   0. Voltar                                      |");
            System.out.println("|                                                  |");
            System.out.println("+--------------------------------------------------+");
            System.out.print("Digite uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());
            EventoService eventoService = new EventoService();
            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID:");
                    String pesquisaEvento = scanner.nextLine();
                    Evento pesquisaId = eventoService.read(pesquisaEvento);
                    if(pesquisaId == null){
                        System.out.println("Solicitação não encontrada");
                        System.out.println();
                        break;
                    }
                    System.out.println(pesquisaId);
                    break;
                case 2:
                    System.out.println("Lista de todas as solicitações:");
                    for (Evento evento : eventoService.read()) {
                        System.out.println(evento);
                    }
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
    public void deletar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o Id: ");
        String deletaEvento = scanner.nextLine();
        EventoService eventoService = new EventoService();
        eventoService.delete(deletaEvento);
        System.out.println("Solicitação deletada com sucesso");
        System.out.println();
    }
    public void editar(){
        Scanner scanner = new Scanner(System.in);
        EventoService eventoService = new EventoService();
        System.out.print("Digite o Id: ");
        Evento eventoEncontrado = eventoService.read(scanner.nextLine());
        if (eventoEncontrado == null) {
            System.out.println("Opção não localizada!");
            System.out.println();
            return;
        }

        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|     Menu Edição                                  |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("1. Nome: " + eventoEncontrado.getNome());
            System.out.println("2. Descrição: " + eventoEncontrado.getDescricao());
            System.out.println("3. Salvar ");
            System.out.println("0. Voltar ");
            System.out.println();
            System.out.print("Digite uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println();
                    System.out.println("Digite o novo valor para:");
                    System.out.print("Nome:");
                    eventoEncontrado.setNome(scanner.nextLine());
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Digite o novo valor para:");
                    System.out.print("Descrição: ");
                    eventoEncontrado.setDescricao(scanner.nextLine());
                    break;
                case 3:
                    eventoService.update(eventoEncontrado);
                case 0:
                    System.out.println();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    System.out.println();
            }
        }
    }
    public Evento selecionar(){
        Scanner scanner = new Scanner(System.in);
        EventoService eventoService = new EventoService();

        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|     Selecione um EVENTO                          |");
            System.out.println("|                                                  |");
            System.out.println("|   1. Por Id                                      |");
            System.out.println("|   2. Da lista                                    |");
            System.out.println("|   0. Voltar                                      |");
            System.out.println("|                                                  |");
            System.out.println("+--------------------------------------------------+");
            System.out.print("Digite uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Digite o Id: ");
                    Evento eventoEncontrado = eventoService.read(scanner.nextLine());
                    if (eventoEncontrado == null) {
                        System.out.println("Opção não localizada!");
                        System.out.println();
                        break;
                    }
                    return eventoEncontrado;
                case 2:
                    System.out.println();
                    ArrayList<Evento> eventos = eventoService.read();
                    while(true){
                        if (eventos.size() > 0){ System.out.println(" -- EVENTOS --");
                            System.out.println(); }
                        for (int i = 0; i < eventos.size(); i++){
                            System.out.printf("%d. %s\n", i + 1, eventos.get(i).getNome());
                        }
                        System.out.println("0. Voltar");
                        System.out.println();
                        System.out.print("Selecione uma opção: ");
                        opcao = Integer.parseInt(scanner.nextLine());
                        System.out.println();
                        if (opcao == 0) { break; }
                        Evento eventoSelecionado = eventos.get(opcao - 1);
                        if (eventoSelecionado != null){
                            return eventoSelecionado;
                        }
                        System.out.println("Opção inválida. Tente novamente.");
                        System.out.println();
                    }
                    break;
                case 0:
                    return null;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    public Evento selecionar(ArrayList<Evento> eventosDisponiveis){
        Scanner scanner = new Scanner(System.in);
        EventoService eventoService = new EventoService();

        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|     Selecione um EVENTO                          |");
            System.out.println("|                                                  |");
            System.out.println("|   1. Por Id                                      |");
            System.out.println("|   2. Da lista                                    |");
            System.out.println("|   0. Voltar                                      |");
            System.out.println("|                                                  |");
            System.out.println("+--------------------------------------------------+");
            System.out.print("Digite uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Digite o Id: ");
                    Evento eventoEncontrado = eventoService.read(scanner.nextLine());
                    if (eventoEncontrado == null) {
                        System.out.println("Opção não localizada!");
                        System.out.println();
                        break;
                    }
                    return eventoEncontrado;
                case 2:
                    System.out.println();
                    while(true){
                        if (eventosDisponiveis.size() > 0){ System.out.println(" -- EVENTOS --");
                            System.out.println(); }
                        for (int i = 0; i < eventosDisponiveis.size(); i++){
                            System.out.printf("%d. %s\n", i + 1, eventosDisponiveis.get(i).getNome());
                        }
                        System.out.println("0. Voltar");
                        System.out.println();
                        System.out.print("Selecione uma opção: ");
                        opcao = Integer.parseInt(scanner.nextLine());
                        System.out.println();
                        if (opcao == 0) { break; }
                        Evento eventoSelecionado = eventosDisponiveis.get(opcao - 1);
                        if (eventoSelecionado != null){
                            return eventoSelecionado;
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
    public void gerenciarServicos(){
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        ServicoView servicoView = new ServicoView();
        Evento eventoEncontrado = selecionar();
        if (eventoEncontrado == null) { return; }

        ArrayList<Servico> servicos = eventoEncontrado.getServicos();
        Servico servicoSelecionado;
        while (true) {
            System.out.println();
            System.out.println("      Serviços do evento " + eventoEncontrado.getNome());
            System.out.println("+--------------------------------------------------+");
            System.out.println("|  1. Listar serviços associados                   +");
            System.out.println("|  2. Associar existente                           +");
            System.out.println("|  3. Cadastrar novo                               +");
            System.out.println("|  4. Desassociar serviço                          +");
            System.out.println("|  0. Voltar                                       +");
            System.out.println("+--------------------------------------------------+");
            System.out.print("Digite uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println();
                    if (servicos.size() > 0) { System.out.println(" -- SERVIÇOS --");
                        System.out.println(); }
                    else { System.out.println("Nenhum serviço associado!");
                        System.out.println();}
                    for (Servico servico : servicos){
                        System.out.println(servico);
                    }
                    break;
                case 2:
                    servicoSelecionado =  servicoView.selecionar();
                    if (servicoSelecionado == null) { break; }
                    servicos.add(servicoSelecionado);
                    eventoEncontrado.setServicos(servicos);
                    System.out.println("Serviço " + servicoSelecionado.getNome() + " associado!");
                    System.out.println();
                    break;
                case 3:
                    servicoSelecionado = servicoView.cadastrar();
                    servicos.add(servicoSelecionado);
                    eventoEncontrado.setServicos(servicos);
                    System.out.println("Serviço " + servicoSelecionado.getNome() + " associado!");
                    System.out.println();
                    break;
                case 4:
                    if (servicos.size() == 0) {
                        System.out.println("Nenhum serviço associado!");
                        System.out.println();
                        break;
                    }
                    servicoSelecionado =  servicoView.selecionar(servicos);
                    if (servicoSelecionado == null) { break; }
                    servicos.remove(servicoSelecionado);
                    eventoEncontrado.setServicos(servicos);
                    System.out.println("Serviço " + servicoSelecionado.getNome() + " desassociado!");
                    System.out.println();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    System.out.println();
            }
        }
    }
    public void gerenciarEnderecos(){
        Scanner scanner = new Scanner(System.in);
        EnderecoView enderecoView = new EnderecoView();
        Evento eventoEncontrado = selecionar();
        if (eventoEncontrado == null) { return; }

        ArrayList<Endereco> enderecos = eventoEncontrado.getEnderecos();
        Endereco enderecoSelecionado;
        while (true) {
            System.out.println();
            System.out.println("   Endereço do evento " + eventoEncontrado.getNome());
            System.out.println("+--------------------------------------------------+");
            System.out.println("|  1. Listar serviços associados                   +");
            System.out.println("|  2. Associar existente                           +");
            System.out.println("|  3. Cadastrar novo                               +");
            System.out.println("|  4. Desassociar serviço                          +");
            System.out.println("|  0. Voltar                                       +");
            System.out.println("+--------------------------------------------------+");
            System.out.print("Digite uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    if (enderecos.size() > 0) { System.out.println(" -- ENDEREÇOS --"); }
                    else { System.out.println("Nenhum serviço associado!"); }
                    for (Endereco endereco : enderecos){
                        System.out.println(endereco);
                    }
                    break;
                case 2:
                    enderecoSelecionado =  enderecoView.selecionar();
                    if (enderecoSelecionado == null) { break; }
                    enderecos.add(enderecoSelecionado);
                    eventoEncontrado.setEnderecos(enderecos);
                    System.out.println("Endereço " + enderecoSelecionado.getRua() + " associado!");
                    System.out.println();
                    break;
                case 3:
                    enderecoSelecionado = enderecoView.cadastrar();
                    enderecos.add(enderecoSelecionado);
                    eventoEncontrado.setEnderecos(enderecos);
                    System.out.println("Endereço " + enderecoSelecionado.getRua() + " associado!");
                    System.out.println();
                    break;
                case 4:
                    if (enderecos.size() == 0) {
                        System.out.println("Nenhum endereço associado!");
                        System.out.println();
                        break;
                    }
                    enderecoSelecionado =  enderecoView.selecionar(enderecos);
                    if (enderecoSelecionado == null) { break; }
                    enderecos.remove(enderecoSelecionado);
                    eventoEncontrado.setEnderecos(enderecos);
                    System.out.println("Endereço " + enderecoSelecionado.getRua() + " desassociado!");
                    System.out.println();
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
