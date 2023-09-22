import java.util.ArrayList;
import java.util.List;

public class Estrela extends CorpoCeleste implements Gravitacional {
    private String tipoDeEstrela;
    private double temperatura;
    private double raio;
    private SistemaSolar sistemaSolar;
    private List<Planeta> planetas;

    public Estrela(String nome, double massa, double raio, int idade, String tipoDeEstrela, double temperatura, SistemaSolar sistemaSolar) {
        super(nome, massa, idade);
        this.raio = raio;
        this.tipoDeEstrela = tipoDeEstrela;
        this.temperatura = temperatura;
        this.sistemaSolar = sistemaSolar;
        this.planetas = new ArrayList<>();
    }

    public void adicionarPlaneta(Planeta planeta) {
        this.planetas.add(planeta);
    }

    public SistemaSolar getSistemaSolar() {
        return sistemaSolar;
    }

    public void setSistemaSolar(SistemaSolar sistemaSolar) {
        this.sistemaSolar = sistemaSolar;
    }

    public List<Planeta> getPlanetas() {
        return planetas;
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
        return "\nThe Star " + getNome() + ", of the type " + getTipoDeEstrela() + ", has existed for " + getIdade() 
        + " billions of years, it has a mass of " + getMassa() + " Kgs, its radius is of " + getRaio() + 
        " Kms, and its temperature is " + getTemperatura() + " K, she belongs to the Solar System " + getSistemaSolar().getNome() + "."
        + "\nExtra Info:" + "\n - Density: " + calcularDensidade() + " g/cm^3"
        + "\n - Volume: " + calcularVolume() + " km^3" + "\n - Surface: " + calcularSuperficie() + " km²"
        + "\n - Gravity: " + calcularGravidade() + " m/s²";
    }

    @Override
    public double calcularForcaGravitacional(CorpoCeleste outroCorpo) {
        return (6.67430e-11 * getMassa() * outroCorpo.getMassa()) / Math.pow(raio * 1000, 2);
    }

    public String getTipoDeEstrela() {
        return tipoDeEstrela;
    }

    public void setTipoDeEstrela(String tipoDeEstrela) {
        this.tipoDeEstrela = tipoDeEstrela;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public void removerPlaneta(Planeta planeta) {
        this.planetas.remove(planeta);
    }
}
