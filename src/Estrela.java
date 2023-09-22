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
        return "\nA estrela " + getNome() + ", do tipo " + getTipoDeEstrela() + ", existente a " + getIdade() 
        + " bilhões de anos, tem uma massa de " + getMassa() + " kg, um raio de " + getRaio() + 
        " km, com uma temperatura de " + getTemperatura() + " K, ela pertence ao sistema solar " + getSistemaSolar().getNome() 
        + "\nInformações extras:" + "\n• Densidade: " + calcularDensidade() + " g/cm³"
        + "\n• Volume: " + calcularVolume() + " km³" + "\n• Superfície: " + calcularSuperficie() + " km²"
        + "\n• Gravidade: " + calcularGravidade() + " m/s²";
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
