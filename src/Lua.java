public class Lua extends CorpoCeleste implements Gravitacional {
    private double raio;
    private Planeta planeta;

    public Lua(String nome, double massa, double idade, double raio, Planeta planeta) {
        super(nome, massa, idade);
        
        if (raio <= 0) {
            throw new IllegalArgumentException("Radius must be positive.");
        }

        if (planeta == null) {
            throw new IllegalArgumentException("Planet cannot be null.");
        }

        this.raio = raio;
        this.planeta = planeta;
    }

    @Override
    public double calcularDensidade() {
        return getMassa() / (4/3 * Math.PI * Math.pow(raio, 3));
    }

    @Override
    public double calcularVolume() {
        return 4/3 * Math.PI * Math.pow(raio, 3); 
    }

    @Override
    public double calcularSuperficie() {
        return 4 * Math.PI * Math.pow(raio, 2);
    }

    @Override
    public double calcularGravidade() {
        return (6.67430e-11 * getMassa()) / Math.pow(raio * 1000, 2);
    }

    @Override
    public String descricao() {
        return "\nThe Moon " + getNome() + ", existent since " + getIdade() + "  years, has a mass of " 
        + getMassa() + " Kgs, its radius is " + getRaio() + " Kms, and it orbits the Planet " + getPlaneta().getNome() + "."
        + "\nExtra Info:" + "\n - Density: " + calcularDensidade() + " g/cm^3"
        + "\n - Volume: " + calcularVolume() + " km^3" + "\n - Surface: " + calcularSuperficie() + " km²"
        + "\n - Gravity: " + calcularGravidade() + " m/s²";
    }

    @Override
    public double calcularForcaGravitacional(CorpoCeleste outroCorpo) {
        return (6.67430e-11 * getMassa() * outroCorpo.getMassa()) / Math.pow(raio * 1000, 2);
    }

    // Getters and Setters
    public Planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(Planeta planeta) {
        if (planeta == null) {
            throw new IllegalArgumentException("Planet cannot be null.");
        }
        this.planeta = planeta;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        if (raio <= 0) {
            throw new IllegalArgumentException("Radius must be positive.");
        }
        this.raio = raio;
    }
}
