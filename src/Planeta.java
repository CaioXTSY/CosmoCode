import java.util.ArrayList;
import java.util.List;

public class Planeta extends CorpoCeleste implements Gravitacional {
    private Estrela estrelaOrbitada;
    private List<CorpoCeleste> luas;
    private double distanciaAoSol;
    private int numeroDeLuas;
    private double raio;

    public Planeta(String nome, double massa, double distanciaAoSol, int numeroDeLuas, 
                   double raio, double idade, Estrela estrelaOrbitada) {
        super(nome, massa, idade);

        if (raio <= 0 || distanciaAoSol <= 0 || numeroDeLuas < 0) {
            throw new IllegalArgumentException("Radius, distance to the sun must be positive and number of moons cannot be negative.");
        }

        if (estrelaOrbitada == null) {
            throw new IllegalArgumentException("Orbited star cannot be null.");
        }

        this.distanciaAoSol = distanciaAoSol;
        this.numeroDeLuas = numeroDeLuas;
        this.raio = raio;
        this.estrelaOrbitada = estrelaOrbitada;
        this.luas = new ArrayList<>();
    }

    public void adicionarLua(CorpoCeleste lua) {
        if (lua == null) {
            throw new IllegalArgumentException("Moon cannot be null.");
        }
        this.luas.add(lua);
    }

    public void removerLua(CorpoCeleste lua) {
        if (lua == null) {
            throw new IllegalArgumentException("Moon cannot be null.");
        }
        this.luas.remove(lua);
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
    public double calcularForcaGravitacional(CorpoCeleste outroCorpo) {
        return (6.67430e-11 * getMassa() * outroCorpo.getMassa()) / Math.pow(raio * 1000, 2);
    }

    @Override
    public String descricao() {
        return "\nThe Planet " + getNome() + ", orbits the Star " + getEstrelaOrbitada().getNome() + 
               ", it exists since " + getIdade() + " years ago and possesses " + getNumeroDeLuas() +
               " Moon(s), its mass is of " + getMassa() + " Kgs, its radius of " + getRaio() + " Kms and its distance from its Sun is of " + 
               getDistanciaAoSol() + " UA." + "\nExtra Info:" + "\n - Density: " + calcularDensidade() + " g/cm^3" +
               "\n - Volume: " + calcularVolume() + " km^3" + "\n - Surface: " + calcularSuperficie() + " km²" +
        "\n - Gravity: " + calcularGravidade() + " m/s²";
    }

    // Getters and Setters
    public Estrela getEstrelaOrbitada() {
        return estrelaOrbitada;
    }

    public void setEstrelaOrbitada(Estrela estrelaOrbitada) {
        if (estrelaOrbitada == null) {
            throw new IllegalArgumentException("Orbited star cannot be null.");
        }
        this.estrelaOrbitada = estrelaOrbitada;
    }

    public List<CorpoCeleste> getLuas() {
        return luas;
    }

    public double getDistanciaAoSol() {
        return distanciaAoSol;
    }

    public void setDistanciaAoSol(double distanciaAoSol) {
        if (distanciaAoSol <= 0) {
            throw new IllegalArgumentException("Distance to the sun must be positive.");
        }
        this.distanciaAoSol = distanciaAoSol;
    }

    public int getNumeroDeLuas() {
        return numeroDeLuas;
    }

    public void setNumeroDeLuas(int numeroDeLuas) {
        if (numeroDeLuas < 0) {
            throw new IllegalArgumentException("Number of moons cannot be negative.");
        }
        this.numeroDeLuas = numeroDeLuas;
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

    public String getEstrela() {
        return getEstrelaOrbitada().getNome();
    }
}
