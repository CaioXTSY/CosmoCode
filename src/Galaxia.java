import java.util.ArrayList;
import java.util.List;

public class Galaxia {
    private String nome;
    private List<SistemaSolar> sistemasSolares;

    public Galaxia(String nome) {
        this.nome = nome;
        this.sistemasSolares = new ArrayList<>();
    }

    public void adicionarSistemaSolar(SistemaSolar sistemaSolar) {
        this.sistemasSolares.add(sistemaSolar);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<SistemaSolar> getSistemasSolares() {
        return sistemasSolares;
    }

    public String descricao() {
        StringBuilder descricao = new StringBuilder("Galáxia " + nome + " contém os seguintes sistemas solares:\n");
        for (SistemaSolar sistemaSolar : sistemasSolares) {
            descricao.append("- ").append(sistemaSolar.getNome()).append("\n");
        }
        return descricao.toString();
    }

    public void removerSistemaSolar(SistemaSolar sistemaSolar) {
        this.sistemasSolares.remove(sistemaSolar);
    }
}
