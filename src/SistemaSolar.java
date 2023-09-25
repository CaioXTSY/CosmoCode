import java.util.ArrayList;
import java.util.List;

public class SistemaSolar {
    private String nome;
    private List<Estrela> estrelas;
    private Galaxia galaxia;

    public SistemaSolar(String nome, Galaxia galaxia) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Name of the solar system cannot be null or empty.");
        }
        
        if (galaxia == null) {
            throw new IllegalArgumentException("Galaxy cannot be null.");
        }

        this.nome = nome;
        this.estrelas = new ArrayList<>();
        this.galaxia = galaxia;
        galaxia.adicionarSistemaSolar(this);
    }

    public void adicionarEstrela(Estrela estrela) {
        if (estrela == null) {
            throw new IllegalArgumentException("Star cannot be null.");
        }
        this.estrelas.add(estrela);
    }

    public void removerEstrela(Estrela estrela) {
        if (estrela == null) {
            throw new IllegalArgumentException("Star cannot be null.");
        }
        
        for (Planeta planeta : estrela.getPlanetas()) {
            for (CorpoCeleste corpo : planeta.getLuas()) {
                Lua lua = (Lua) corpo;
                planeta.removerLua(lua);
            }
            estrela.removerPlaneta(planeta);
        }
        
        this.estrelas.remove(estrela);
    }

    public String descricao() {
        StringBuilder descricao = new StringBuilder("\nThe Solar System " + nome + " has the following Stars:\n");
        if (estrelas.isEmpty()) {
            descricao.append("\nThere are no Stars in this Solar System!");
        } else {
            for (Estrela estrela : estrelas) {
                descricao.append("- ").append(estrela.getNome()).append("\n");
            }
        }    
        return descricao.toString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Name of the solar system cannot be null or empty.");
        }
        this.nome = nome;
    }

    public List<Estrela> getEstrelas() {
        return estrelas;
    }

    public Galaxia getGalaxia() {
        return galaxia;
    }

    public void setGalaxia(Galaxia galaxia) {
        if (galaxia == null) {
            throw new IllegalArgumentException("Galaxy cannot be null.");
        }
        this.galaxia = galaxia;
    }
}
