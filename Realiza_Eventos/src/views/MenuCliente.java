package views;

import models.*;
import services.ClienteService;
import services.EventoService;
import services.SolicitacaoService;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class MenuCliente {
    public void exibir() {
        System.out.println("+--------------------------------------------------+");
        System.out.println("|            ***REALIZA EVENTOS***                 |");
        System.out.println("+--------------------------------------------------+");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|                                                  |");
            System.out.println("|  1. Solicitar orçamento                          |");
            System.out.println("|  0. Voltar                                       |");
            System.out.println("|                                                  |");
            System.out.println("+--------------------------------------------------+");
            System.out.print("Digite uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println();
                    ArrayList<Evento> eventos = obterEventosDisponiveis();
                    if (eventos.size() < 1) {
                        System.out.println("Desculpe, não temos nenhum Evento disponível!");
                        System.out.println();
                        break;
                    }
                    solicitarOrcamento(eventos);
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

    public ArrayList<Evento> obterEventosDisponiveis(){
        ArrayList<Evento> eventosDisponiveis = new ArrayList<>();
        EventoService eventoService = new EventoService();
        ArrayList<Evento> eventos = eventoService.read();

        for (Evento evento : eventos){
            ArrayList<Servico> servicosDisponiveis = new ArrayList<>();
            for (Servico servico : evento.getServicos()){
                if (servico.getOpcoes().size() > 0){
                    servicosDisponiveis.add(servico);
                }
            }
            if (servicosDisponiveis.size() > 0 && evento.getEnderecos().size() > 0){
                Evento eventoDisponivel = evento.clone();
                eventoDisponivel.setServicos(servicosDisponiveis);
                eventosDisponiveis.add(eventoDisponivel);
            }
        }

        return eventosDisponiveis;
    }

    public void solicitarOrcamento(ArrayList<Evento> eventos){
        SolicitacaoService solicitacaoService = new SolicitacaoService();
        Scanner scanner = new Scanner(System.in);
        EventoView eventosView = new EventoView();

        Evento eventoSelecionado = null;
        Endereco enderecoSelecionado = null;
        String dataHoraDeInicio = null;
        String dataHoraDeTermino = null;
        Cliente cliente = null;
        String observacoes = "";

        while(true){
            System.out.println("+--------------------------------------------------+");
            System.out.println("| Preencha o formulário de Solicitação             |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("1. Evento: " + (eventoSelecionado != null ? eventoSelecionado.getNome() : ""));
            System.out.println("2. Endereço: " + (enderecoSelecionado != null ? enderecoSelecionado.getRua() : ""));
            System.out.println("3. Horário: " + (dataHoraDeInicio != null ? dataHoraDeInicio + " - " : "") + (dataHoraDeTermino != null ? dataHoraDeTermino.toString() : ""));
            System.out.println("4. Contato: " + (cliente != null ? cliente.getNome() + " | " + cliente.getTelefone() : ""));
            System.out.println("5. Observações: " + observacoes);
            System.out.println("6. Enviar solicitação");
            System.out.println("7. Cancelar");
            System.out.print("Digite uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao){
                case 1:
                    System.out.println();
                    eventoSelecionado = selecionarEvento(scanner, eventosView, eventos);
                    break;
                case 2:
                    if (eventoSelecionado == null){
                        System.out.println("Primeiro deve selecionar um Evento!");
                        System.out.println();
                        break;
                    }
                    enderecoSelecionado = selecionarEndereco(eventoSelecionado);
                    break;
                case 3:
                    System.out.println("Preencha os horários: ");
                    System.out.print("Inicio: ");
                    dataHoraDeInicio = new String(scanner.nextLine());
                    System.out.print("Termino: ");
                    dataHoraDeTermino = new String(scanner.nextLine());
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Preencha as informações para contato");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.println();
                    ClienteService clienteService = new ClienteService();
                    if (cliente == null) {
                        cliente = new Cliente(nome, telefone, email);
                        clienteService.create(cliente);
                    } else {
                        clienteService.update(cliente);
                    }
                    break;
                case 5:
                    System.out.print("Observações: ");
                    observacoes = scanner.nextLine();
                    System.out.println();
                    break;
                case 6:
                    if (eventoSelecionado == null
                        || enderecoSelecionado == null
                        || dataHoraDeInicio == null
                        || dataHoraDeTermino == null
                        || cliente == null)
                    {
                        System.out.println("Os campos obrigatórios precisam ser preenchidos!");
                        System.out.println();
                        break;
                    }
                    Solicitacao solicitacao = new Solicitacao();
                    solicitacao.setDataHoraDaSolicitacao(new Date());
                    solicitacao.setEnderecoSelecionado(enderecoSelecionado);
                    solicitacao.setEvento(eventoSelecionado);
                    solicitacao.setInicioEventoDataHora((dataHoraDeInicio));
                    solicitacao.setTerminoEventoDataHora((dataHoraDeTermino));
                    solicitacao.setCliente(cliente);
                    solicitacao.setObservacoes(observacoes);
                    solicitacaoService.create(solicitacao);
                    System.out.println("Solicitação enviada com sucesso!");
                    System.out.println("Em breve entraremos em contato");
                    System.out.println();
                    return;
                case 7:
                    System.out.println();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    System.out.println();
            }
        }
    }

    private Evento selecionarEvento(Scanner scanner, EventoView eventosView, ArrayList<Evento> eventos) {
        while (true){
            // Selecionar um evento
            Evento eventoSelecionado = eventosView.selecionar(eventos).clone();
            if (eventoSelecionado == null){
                return null;
            }

            // Selecionar os serviços do evento
            ArrayList<Servico> servicosSelecionados = null;
            do {
                servicosSelecionados = selecionarServicos(scanner, eventoSelecionado);
                if (servicosSelecionados != null){
                    eventoSelecionado.setServicos(servicosSelecionados);
                    return eventoSelecionado;
                } else {
                    System.out.println("Ao menos um serviço deve ser selecionado!");
                    System.out.println("1. Selecionar Serviço(s)");
                    System.out.println("2. Selecionar outro Evento");
                    System.out.println("3. Voltar");
                    System.out.print("Digite uma opção: ");
                    int opcao = Integer.parseInt(scanner.nextLine());

                    if (opcao == 2){ break; }
                    else if (opcao == 3){ return null; }
                    else if (opcao != 1){ System.out.println("Opção inválida. Tente novamente.");
                        System.out.println(); }
                }
            } while (true);
        }
    }

    private Endereco selecionarEndereco(Evento eventoSelecionado) {
        // Selecionar um endereço
        EnderecoView enderecoView = new EnderecoView();
        return enderecoView.selecionar(eventoSelecionado.getEnderecos());
    }

    private ArrayList<Servico> selecionarServicos(Scanner scanner, Evento eventoSelecionado) {
        // Selecionar os serviços
        ArrayList<Servico> servicosSelecionados = new ArrayList<>();
        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|  Selecione o(s) serviço(s) desejado(s):          |");
            ArrayList<Servico> servicosDoEvento = eventoSelecionado.getServicos();
            for (int i = 0; i < servicosDoEvento.size(); i++){
                Servico servico = servicosDoEvento.get(i);
                System.out.printf("|  %d. [%s] %s\n", i + 1, servicosSelecionados.contains(servico) ? "X" : " ", servico.getNome() + "                                   |");
            }
            System.out.println("|  C. Confirmar                                    |");
            System.out.println("|  0. Voltar                                       |");
            System.out.println("+--------------------------------------------------|");
            System.out.print("Digite uma opção: ");
            String opcao = scanner.nextLine().toUpperCase();
            switch (opcao){
                case "C":
                    System.out.println();
                    if (servicosSelecionados.size() > 0){
                        return servicosSelecionados;
                    }
                    System.out.println("Nenhum serviço foi selecionado!");
                    System.out.println();
                    break;
                case "0":
                    System.out.println();
                    return null;
                default:
                    try {
                        Servico servico = servicosDoEvento.get(Integer.parseInt(opcao) - 1).clone();
                        // Se o serviço estiver selecionado, remove a seleção e retorna para seleção de Serviços.
                        if (servicosSelecionados.contains(servico)){
                            servicosSelecionados.remove(servico);
                            break;
                        }

                        ArrayList<Opcao> opcoesSelecionadas = selecionarOpcoes(scanner, servico);
                        if (opcoesSelecionadas == null ){
                            System.out.println("Ao menos uma opção deve ser selecionada!");
                            System.out.println();
                            break;
                        }
                        servico.setOpcoes(opcoesSelecionadas);
                        servicosSelecionados.add(servico);
                    } catch (NumberFormatException numberFormatException) {
                        System.out.println("Opção inválida. Tente novamente.");
                        System.out.println();
                    }
            }
        }
    }

    private ArrayList<Opcao> selecionarOpcoes(Scanner scanner, Servico servicoSelecionado) {
        // Selecionar as opções
        ArrayList<Opcao> opcoesSelecionadas = new ArrayList<>();
        while (true) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|  Selecione a(s) opcão(ões) desejada(s):          |");
            ArrayList<Opcao> opcoesDoServico = servicoSelecionado.getOpcoes();
            for (int i = 0; i < opcoesDoServico.size(); i++){
                Opcao opcao = opcoesDoServico.get(i);
                System.out.printf("|  %d. [%s] %s\n", i + 1, opcoesSelecionadas.contains(opcao) ? "X" : " ", opcao.getNome()+ "                            |");
            }
            System.out.println("|  C. Confirmar                                    |");
            System.out.println("|  0. Voltar                                       |");
            System.out.println("+--------------------------------------------------+");
            System.out.print("Digite uma opção: ");
            String opcao = scanner.nextLine().toUpperCase();
            switch (opcao){
                case "C":
                    System.out.println();
                    if (opcoesSelecionadas.size() < 1){
                        System.out.println("Nenhuma opção foi selecionada!");
                        System.out.println();
                        break;
                    }
                    return opcoesSelecionadas;
                case "0":
                    System.out.println();
                    return null;
                default:
                    try {
                        Opcao opcao_ = opcoesDoServico.get(Integer.parseInt(opcao) - 1);
                        // Se a opção estiver selecionada, remove a seleção e retorna para seleção de Opções.
                        if (opcoesSelecionadas.contains(opcao_)){
                            opcoesSelecionadas.remove(opcao_);
                            break;
                        }
                        if (opcao_ != null){ opcoesSelecionadas.add(opcao_); }
                        else { System.out.println("Opção inválida. Tente novamente.");
                            System.out.println(); }
                    } catch (NumberFormatException numberFormatException) {
                        System.out.println("Opção inválida. Tente novamente.");
                        System.out.println();
                    }
            }
        }
    }

}
