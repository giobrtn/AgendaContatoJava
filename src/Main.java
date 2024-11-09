import java.util.Scanner;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha a interface para a Agenda de Contatos:");
        System.out.println("1. Console");
        System.out.println("2. Gráfica (Swing)");
        System.out.print("Digite o número da opção desejada: ");

        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1 -> {
                System.out.println("Iniciando a interface de console...");
                AgendaConsoleApp.main(args);
            }
            case 2 -> {
                System.out.println("Iniciando a interface gráfica (Swing)...");
                SwingUtilities.invokeLater(() -> {
                    AgendaSwingApp app = new AgendaSwingApp();
                    app.setVisible(true);
                });
            }
            default -> System.out.println("Opção inválida. Por favor, reinicie o programa e escolha uma opção válida.");
        }
    }
}