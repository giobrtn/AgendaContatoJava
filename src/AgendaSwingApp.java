import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgendaSwingApp extends JFrame {
    private Agenda agenda;
    private JTextArea displayArea;
    private JTextField nomeField, telefoneField, emailField;

    public AgendaSwingApp() {
        agenda = new Agenda();
        setTitle("Agenda de Contatos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        panel.add(nomeField);

        panel.add(new JLabel("Telefone:"));
        telefoneField = new JTextField();
        panel.add(telefoneField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        JButton addButton = new JButton("Adicionar contato");
        addButton.addActionListener(new AddContactListener());
        panel.add(addButton);

        JButton listButton = new JButton("Listar Contatos");
        listButton.addActionListener(new ListContactsListener());
        panel.add(listButton);

        add(panel, BorderLayout.SOUTH);
    }

    private class AddContactListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = nomeField.getText();
            String telefone = telefoneField.getText();
            String email = emailField.getText();
            agenda.adicionarContato(new Contato(nome, telefone, email));
            displayArea.append("Contato adicionado: " + nome + "\n");
            nomeField.setText("");
            telefoneField.setText("");
            emailField.setText("");
        }
    }
    private class ListContactsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            displayArea.setText("Contatos:\n");
            for (Contato contato : agenda.listarContatos()) {
                displayArea.append(contato + "\n");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AgendaSwingApp app = new AgendaSwingApp();
            app.setVisible(true);
        });
    }
}
