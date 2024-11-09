import java.util.Scanner;

public class AgendaConsoleApp {
    private static Agenda agenda = new Agenda();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\nAgenda de contatos");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Remover contato");
            System.out.println("3. Listar contatos");
            System.out.println("4. Buscar contato");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> adicionarContato();
                case 2 -> removerContato();
                case 3 -> listarContatos();
                case 4 -> buscarContato();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
    private static void adicionarContato() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        agenda.adicionarContato(new Contato(nome, telefone, email));
        System.out.println("Contato adicionado com sucesso!");
    }
    private static void removerContato() {
        System.out.print("Nome do contato a remover: ");
        String nome = scanner.nextLine();
        agenda.removerContato(nome);
        System.out.println("Contato removido, se existente.");
    }

    private static void listarContatos() {
        System.out.println("Lista de Contatos:");
        for (Contato contato : agenda.listarContatos()) {
            System.out.println(contato);
        }
    }

    private static void buscarContato() {
        System.out.print("Nome do contato a buscar: ");
        String nome = scanner.nextLine();
        Contato contato = agenda.buscarContato(nome);
        if (contato != null) {
            System.out.println("Contato encontrado: " + contato);
        } else {
            System.out.println("Contato não encontrado.");
        }
    }
}
