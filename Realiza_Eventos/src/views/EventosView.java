package views;

import models.Evento;
import services.EventoService;
import java.util.Scanner;

public class EventosView {
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
        System.out.println("Preencha as informações:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        Evento evento = new Evento(nome, descricao);
        EventoService eventoService = new EventoService();
        eventoService.create(evento);
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
            EventoService eventoService = new EventoService();
            switch (opcao) {
                case 1:
                    System.out.println("Insira o ID: ");
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
        System.out.println("Insira o ID: ");
        String deletaEvento = scanner.nextLine();
        EventoService eventoService = new EventoService();
        eventoService.delete(deletaEvento);
        System.out.println("Solicitação deletada com sucesso");
    }
    public void editar(){
        Scanner scanner = new Scanner(System.in);
        EventoService eventoService = new EventoService();
        System.out.println("Digite o Id: ");
        Evento eventoEncontrado = eventoService.read(scanner.nextLine());
        if (eventoEncontrado == null) {
            System.out.println("Opção não localizada!");
            return;
        }

        while (true) {
            System.out.println("Escolha um campo para editar:");
            System.out.println("1. Nome: " + eventoEncontrado.getNome());
            System.out.println("2. Descrição: " + eventoEncontrado.getDescricao());
            System.out.println("3. Salvar");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("Digite o novo valor para: ");
                    System.out.print("Nome: ");
                    eventoEncontrado.setNome(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Digite o novo valor para: ");
                    System.out.print("Descrição: ");
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
}
