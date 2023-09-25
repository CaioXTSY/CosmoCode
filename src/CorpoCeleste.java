public abstract class CorpoCeleste {
    private String nome;
    private double massa;
    private double idade;

    public CorpoCeleste(String nome, double massa, double idade) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("The name of the celestial body cannot be null or empty.");
        }
        
        if (massa <= 0) {
            throw new IllegalArgumentException("Mass must be positive.");
        }
        
        if (idade < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }

        this.nome = nome;
        this.massa = massa;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("The name of the celestial body cannot be null or empty.");
        }
        this.nome = nome;
    }

    public double getMassa() {
        return massa;
    }

    public void setMassa(double massa) {
        if (massa <= 0) {
            throw new IllegalArgumentException("Mass must be positive.");
        }
        this.massa = massa;
    }

    public double getIdade() {
        return idade;
    }

    public void setIdade(double idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        this.idade = idade;
    }

    public abstract String descricao();

    public abstract double calcularVolume();

    public abstract double calcularSuperficie();

    public abstract double calcularDensidade();

    public abstract double calcularGravidade();
}
