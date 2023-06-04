package views;

import models.Endereco;
import models.Servico;
import services.EnderecoService;
import services.ServicoService;

import java.util.ArrayList;
import java.util.Scanner;

public class EnderecoView {

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

    public Endereco cadastrar(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Preencha os campos:");
        System.out.print("Rua: ");
        String rua = scanner.nextLine();
        System.out.print("Número: ");
        int numero = Integer.parseInt(scanner.nextLine());
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("Complemento: ");
        String complemento = scanner.nextLine();
        System.out.print("CEP: ");
        String cep = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        System.out.print("Pais: ");
        String pais = scanner.nextLine();

        Endereco endereco = new Endereco(rua, numero, bairro, complemento, cep, cidade, estado, pais);

        EnderecoService enderecoService = new EnderecoService();
        enderecoService.create(endereco);
        return endereco;
    }

    public void consultar(){
        Scanner scanner = new Scanner(System.in);
        EnderecoService enderecoService = new EnderecoService();

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
                    Endereco enderecoEncontrado = enderecoService.read(scanner.nextLine());
                    if (enderecoEncontrado == null) {
                        System.out.println("Cliente não localizado!");
                        break;
                    }
                    System.out.println(" -- ENDEREÇO --");
                    System.out.println(enderecoEncontrado);
                    break;
                case 2:
                    ArrayList<Endereco> clientes = enderecoService.read();
                    if (clientes.size() > 0){ System.out.println(" -- ENDEREÇOS --"); }
                    for (Endereco cliente : clientes){
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

    public void deletar(){
        Scanner scanner = new Scanner(System.in);
        EnderecoService enderecoService = new EnderecoService();
        System.out.println("Digite o Id: ");
        enderecoService.delete(scanner.nextLine());
    }

    public void editar(){
        Scanner scanner = new Scanner(System.in);
        EnderecoService enderecoService = new EnderecoService();

        System.out.println("Digite o Id: ");
        Endereco enderecoEncontrado = enderecoService.read(scanner.nextLine());
        if (enderecoEncontrado == null) {
            System.out.println("Opção não localizada!");
            return;
        }

        while (true) {
            System.out.println("Escolha um campo para editar:");
            System.out.println("1. Rua: " + enderecoEncontrado.getRua());
            System.out.println("2. Número: " + enderecoEncontrado.getNumero());
            System.out.println("3. Bairro: " + enderecoEncontrado.getBairro());
            System.out.println("4. Complemento: " + enderecoEncontrado.getComplemento());
            System.out.println("5. CEP: " + enderecoEncontrado.getCep());
            System.out.println("6. Cidade: " + enderecoEncontrado.getCidade());
            System.out.println("7. Estado: " + enderecoEncontrado.getEstado());
            System.out.println("8. Pais: " + enderecoEncontrado.getEstado());
            System.out.println("9. Salvar");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("Digite o novo valor para: ");
                    System.out.print("Rua: ");
                    enderecoEncontrado.setRua(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Digite o novo valor para: ");
                    System.out.print("Número: ");
                    enderecoEncontrado.setNumero(Integer.parseInt(scanner.nextLine()));
                    break;
                case 3:
                    System.out.println("Digite o novo valor para: ");
                    System.out.print("Bairro: ");
                    enderecoEncontrado.setBairro(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Digite o novo valor para: ");
                    System.out.print("Complemento: ");
                    enderecoEncontrado.setComplemento(scanner.nextLine());
                    break;
                case 5:
                    System.out.println("Digite o novo valor para: ");
                    System.out.print("CEP: ");
                    enderecoEncontrado.setCep(scanner.nextLine());
                    break;
                case 6:
                    System.out.println("Digite o novo valor para: ");
                    System.out.print("Cidade: ");
                    enderecoEncontrado.setCidade(scanner.nextLine());
                    break;
                case 7:
                    System.out.println("Digite o novo valor para: ");
                    System.out.print("Estado: ");
                    enderecoEncontrado.setEstado(scanner.nextLine());
                    break;
                case 8:
                    System.out.println("Digite o novo valor para: ");
                    System.out.print("Pais: ");
                    enderecoEncontrado.setCidade(scanner.nextLine());
                    break;
                case 9:
                    enderecoService.update(enderecoEncontrado);
                    System.out.println("Seu registro foi atualizado com sucesso!");
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    public Endereco selecionar(){
        Scanner scanner = new Scanner(System.in);
        EnderecoService enderecoService = new EnderecoService();

        while (true) {
            System.out.println("Selecione um ENDEREÇO");
            System.out.println("1. Por Id");
            System.out.println("2. Da lista");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("Digite o Id: ");
                    Endereco enderecoEncontrado = enderecoService.read(scanner.nextLine());
                    if (enderecoEncontrado == null) {
                        System.out.println("Opção não localizada!");
                        break;
                    }
                    return enderecoEncontrado;
                case 2:
                    ArrayList<Endereco> enderecos = enderecoService.read();
                    while(true){
                        if (enderecos.size() > 0){ System.out.println(" -- ENDEREÇOS --"); }
                        for (int i = 0; i < enderecos.size(); i++){
                            System.out.printf("%d. %s\n", i + 1, enderecos.get(i).getRua());
                        }
                        System.out.println("0. Voltar");
                        System.out.print("Selecione uma opção: ");
                        opcao = Integer.parseInt(scanner.nextLine());
                        if (opcao == 0) { break; }
                        Endereco enderecoSelecionado = enderecos.get(opcao - 1);
                        if (enderecoSelecionado != null){
                            return enderecoSelecionado;
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
    public Endereco selecionar(ArrayList<Endereco> enderecosDisponiveis){
        Scanner scanner = new Scanner(System.in);
        EnderecoService enderecoService = new EnderecoService();

        while (true) {
            System.out.println("Selecione um ENDEREÇO");
            System.out.println("1. Por Id");
            System.out.println("2. Da lista");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("Digite o Id: ");
                    Endereco enderecoEncontrado = enderecoService.read(scanner.nextLine());
                    if (enderecoEncontrado == null) {
                        System.out.println("Opção não localizada!");
                        break;
                    }
                    return enderecoEncontrado;
                case 2:
                    while(true){
                        if (enderecosDisponiveis.size() > 0){ System.out.println(" -- ENDEREÇOS --"); }
                        for (int i = 0; i < enderecosDisponiveis.size(); i++){
                            System.out.printf("%d. %s\n", i + 1, enderecosDisponiveis.get(i).getRua());
                        }
                        System.out.println("0. Voltar");
                        System.out.print("Selecione uma opção: ");
                        opcao = Integer.parseInt(scanner.nextLine());
                        if (opcao == 0) { break; }
                        Endereco enderecoSelecionado = enderecosDisponiveis.get(opcao - 1);
                        if (enderecoSelecionado != null){
                            return enderecoSelecionado;
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

}
