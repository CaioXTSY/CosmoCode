public abstract class CorpoCeleste {
    private String nome;
    private double massa;
    private int idade;

    public CorpoCeleste(String nome, double massa, int idade) {
        this.nome = nome;
        this.massa = massa;
        this.idade = idade;
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

    public int getIdade(){
        return idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public abstract String descricao();

    public abstract double calcularVolume();

    public abstract double calcularSuperficie();

    public abstract double calcularDensidade();

    public abstract double calcularGravidade();

}
