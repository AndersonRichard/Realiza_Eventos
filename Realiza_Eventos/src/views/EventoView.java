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
            System.out.println("+------------------------------------+");
            System.out.println("|     Escolha uma opção:             |");
            System.out.println("|                                    |");
            System.out.println("|   1. Cadastrar                     |");
            System.out.println("|   2. Consultar                     |");
            System.out.println("|   3. Deletar                       |");
            System.out.println("|   4. Editar                        |");
            System.out.println("|   5. Gerenciar Serviços            |");
            System.out.println("|   6. Gerenciar Endereços           |");
            System.out.println("|   0. Voltar                        |");
            System.out.println("|                                    |");
            System.out.println("+------------------------------------+");
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
                    gerenciarServicos();
                    break;
                case 6:
                    gerenciarEnderecos();
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
        System.out.println("+------------------------------------+");
        System.out.println("|     Preencha as informações:       |");
        System.out.println("|                                    |");
        System.out.println("|   Nome:                            |");
        System.out.println("+------------------------------------+");
        String nome = scanner.nextLine();
        System.out.println("+------------------------------------+");
        System.out.println("|   Descrição:                       |");
        System.out.println("+------------------------------------+");
        String descricao = scanner.nextLine();

        Evento evento = new Evento(nome, descricao);
        EventoService eventoService = new EventoService();
        eventoService.create(evento);
    }
    public void consultar(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("+------------------------------------+");
            System.out.println("|     Escolha uma opção:             |");
            System.out.println("|                                    |");
            System.out.println("|   1. Pesquisar por ID              |");
            System.out.println("|   2. Listar todos                  |");
            System.out.println("|   0. Voltar                        |");
            System.out.println("|                                    |");
            System.out.println("+------------------------------------+");
            System.out.print("Opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());
            EventoService eventoService = new EventoService();
            switch (opcao) {
                case 1:
                    System.out.println("+------------------------------------+");
                    System.out.println("|   Insira o ID:                     +");
                    System.out.println("+------------------------------------+");
                    String pesquisaEvento = scanner.nextLine();
                    Evento pesquisaId = eventoService.read(pesquisaEvento);
                    if(pesquisaId == null){
                        System.out.println("Solicitação não encontrada");
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
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    public void deletar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("+------------------------------------+");
        System.out.println("|   Insira o ID:                     +");
        System.out.println("+------------------------------------+");
        String deletaEvento = scanner.nextLine();
        EventoService eventoService = new EventoService();
        eventoService.delete(deletaEvento);
        System.out.println("Solicitação deletada com sucesso");
    }
    public void editar(){
        Scanner scanner = new Scanner(System.in);
        EventoService eventoService = new EventoService();
        System.out.println("+------------------------------------+");
        System.out.println("|   Insira o ID:                     +");
        System.out.println("+------------------------------------+");
        Evento eventoEncontrado = eventoService.read(scanner.nextLine());
        if (eventoEncontrado == null) {
            System.out.println("Opção não localizada!");
            return;
        }

        while (true) {
            System.out.println("+------------------------------------+");
            System.out.println("|     Escolha um campo para editar:  |");
            System.out.println("|                                    |");
            System.out.println("|   1. Nome: " + eventoEncontrado.getNome());
            System.out.println("|   2. Descrição: " + eventoEncontrado.getDescricao());
            System.out.println("|   3. Salvar                        |");
            System.out.println("|   0. Voltar                        |");
            System.out.println("|                                    |");
            System.out.println("+------------------------------------+");
            System.out.print("Opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("+------------------------------------+");
                    System.out.println("|     Digite o novo valor para:      |");
                    System.out.println("|                                    |");
                    System.out.println("|   Nome:                            |");
                    System.out.println("+------------------------------------+");
                    eventoEncontrado.setNome(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("+------------------------------------+");
                    System.out.println("|     Digite o novo valor para:      |");
                    System.out.println("|                                    |");
                    System.out.println("|     Descrição                      |");
                    System.out.println("+------------------------------------+");
                    eventoEncontrado.setDescricao(scanner.nextLine());
                    break;
                case 3:
                    eventoService.update(eventoEncontrado);
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    public Evento selecionar(){
        Scanner scanner = new Scanner(System.in);
        EventoService eventoService = new EventoService();

        while (true) {
            System.out.println("+------------------------------------+");
            System.out.println("|     Selecione um EVENTO            |");
            System.out.println("|                                    |");
            System.out.println("|   1. Por Id                        |");
            System.out.println("|   2. Da lista                      |");
            System.out.println("|   0. Voltar                        |");
            System.out.println("|                                    |");
            System.out.println("+------------------------------------+");
            System.out.print("Opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("+------------------------------------+");
                    System.out.println("|   Insira o ID:                     +");
                    System.out.println("+------------------------------------+");
                    Evento eventoEncontrado = eventoService.read(scanner.nextLine());
                    if (eventoEncontrado == null) {
                        System.out.println("Opção não localizada!");
                        break;
                    }
                    return eventoEncontrado;
                case 2:
                    ArrayList<Evento> eventos = eventoService.read();
                    while(true){
                        if (eventos.size() > 0){ System.out.println(" -- EVENTOS --"); }
                        for (int i = 0; i < eventos.size(); i++){
                            System.out.printf("%d. %s\n", i + 1, eventos.get(i).getNome());
                        }
                        System.out.println("0. Voltar");
                        System.out.print("Selecione uma opção: ");
                        opcao = Integer.parseInt(scanner.nextLine());
                        if (opcao == 0) { break; }
                        Evento eventoSelecionado = eventos.get(opcao - 1);
                        if (eventoSelecionado != null){
                            return eventoSelecionado;
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
    public void gerenciarServicos(){
        Scanner scanner = new Scanner(System.in);
        ServicoView servicoView = new ServicoView();
        Evento eventoEncontrado = selecionar();
        if (eventoEncontrado == null) { return; }

        ArrayList<Servico> servicos = eventoEncontrado.getServicos();
        Servico servicoSelecionado;
        while (true) {
            System.out.println("+------------------------------------+");
            System.out.println("|   Serviços do evento " + eventoEncontrado.getNome());
            System.out.println("|                                    |");
            System.out.println("|   1. Listar serviços associados    |");
            System.out.println("|   2. Associar existente            |");
            System.out.println("|   3. Cadastrar novo                |");
            System.out.println("|   4. Desassociar serviço           |");
            System.out.println("|   0. Voltar                        |");
            System.out.println("|                                    |");
            System.out.println("+------------------------------------+");
            System.out.print("Opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    if (servicos.size() > 0) { System.out.println(" -- SERVIÇOS --"); }
                    else { System.out.println("Nenhum serviço associado!"); }
                    for (Servico servico : servicos){
                        System.out.println(servico);
                        System.out.println("-----");
                    }
                    break;
                case 2:
                    servicoSelecionado =  servicoView.selecionar();
                    if (servicoSelecionado == null) { break; }
                    servicos.add(servicoSelecionado);
                    eventoEncontrado.setServicos(servicos);
                    System.out.println("Serviço " + servicoSelecionado.getNome() + " associado!");
                    break;
                case 3:
                    servicoSelecionado = servicoView.cadastrar();
                    servicos.add(servicoSelecionado);
                    eventoEncontrado.setServicos(servicos);
                    System.out.println("Serviço " + servicoSelecionado.getNome() + " associado!");
                    break;
                case 4:
                    if (servicos.size() == 0) {
                        System.out.println("Nenhum serviço associado!");
                        break;
                    }
                    servicoSelecionado =  servicoView.selecionar(servicos);
                    if (servicoSelecionado == null) { break; }
                    servicos.remove(servicoSelecionado);
                    eventoEncontrado.setServicos(servicos);
                    System.out.println("Serviço " + servicoSelecionado.getNome() + " desassociado!");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
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
            System.out.println("+------------------------------------+");
            System.out.println("|   Endereço do evento " + eventoEncontrado.getNome()));
            System.out.println("|                                    |");
            System.out.println("|   1. Listar endereços associados   |");
            System.out.println("|   2. Associar existente            |");
            System.out.println("|   3. Cadastrar novo                |");
            System.out.println("|   4. Desassociar endereço          |");
            System.out.println("|   0. Voltar                        |");
            System.out.println("|                                    |");
            System.out.println("+------------------------------------+");
            System.out.print("Opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    if (enderecos.size() > 0) { System.out.println(" -- ENDEREÇOS --"); }
                    else { System.out.println("Nenhum serviço associado!"); }
                    for (Endereco endereco : enderecos){
                        System.out.println(endereco);
                        System.out.println("-----");
                    }
                    break;
                case 2:
                    enderecoSelecionado =  enderecoView.selecionar();
                    if (enderecoSelecionado == null) { break; }
                    enderecos.add(enderecoSelecionado);
                    eventoEncontrado.setEnderecos(enderecos);
                    System.out.println("Endereço " + enderecoSelecionado.getRua() + " associado!");
                    break;
                case 3:
                    enderecoSelecionado = enderecoView.cadastrar();
                    enderecos.add(enderecoSelecionado);
                    eventoEncontrado.setEnderecos(enderecos);
                    System.out.println("Endereço " + enderecoSelecionado.getRua() + " associado!");
                    break;
                case 4:
                    if (enderecos.size() == 0) {
                        System.out.println("Nenhum endereço associado!");
                        break;
                    }
                    enderecoSelecionado =  enderecoView.selecionar(enderecos);
                    if (enderecoSelecionado == null) { break; }
                    enderecos.remove(enderecoSelecionado);
                    eventoEncontrado.setEnderecos(enderecos);
                    System.out.println("Endereço " + enderecoSelecionado.getRua() + " desassociado!");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

}
