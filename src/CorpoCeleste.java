package src;

public abstract class CorpoCeleste {
    private String nome;
    private double massa;

    public CorpoCeleste(String nome, double massa) {
        this.nome = nome;
        this.massa = massa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getMassa() {
        return massa;
    }

    public void setMassa(double massa) {
        this.massa = massa;
    }

    public abstract String descricao();

    public abstract double calcularVolume();

    public abstract double calcularSuperficie();

    public abstract double calcularDensidade();

    public abstract double calcularGravidade();

}
