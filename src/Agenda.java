import java.util.ArrayList;

public class Agenda {

    private ArrayList<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public void removerContato(String nome) {
        contatos.removeIf(contato -> contato.getNome().equalsIgnoreCase(nome));
    }

    public ArrayList<Contato> listarContatos() {
        return contatos;
    }

    public Contato buscarContato(String nome) {
        return contatos.stream()
                .filter(contato -> contato.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

}
