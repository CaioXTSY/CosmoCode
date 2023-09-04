// as coisas comentadas devem ser removidas quando a classe SistemaSolar for c
import java.util.ArrayList;
import java.util.List;

public class Estrela extends CorpoCeleste implements Movimentavel, Gravitacional {
    private String tipoDeEstrela;
    private double temperatura;
    private double raio;
    // private SistemaSolar sistemaSolar;
    private List<Planeta> planetas;

    public Estrela(String nome, double massa, int idade, String tipoDeEstrela, double temperatura) { // colocar sistema solar depois
        super(nome, massa, idade);
        this.tipoDeEstrela = tipoDeEstrela;
        this.temperatura = temperatura;
        // this.sistemaSolar = sistemaSolar;
        this.planetas = new ArrayList<>();
    }

    public void adicionarPlaneta(Planeta planeta) {
        this.planetas.add(planeta);
    }

    // public SistemaSolar getSistemaSolar() {
        // return sistemaSolar;
    // }

    // public void setSistemaSolar(SistemaSolar sistemaSolar) {
        // this.sistemaSolar = sistemaSolar;
    // }

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
        return "Estrela do tipo " + tipoDeEstrela + " com temperatura de " + temperatura + " K.";
    }

    @Override
    public void transladar(double deltaX, double deltaY, double deltaZ) {
        raio += deltaX;
    }

    @Override
    public void rotacionar(double angulo, String eixo) {
        if (eixo.equals("x")) {
            raio *= Math.cos(angulo);
        } else if (eixo.equals("y")) {
            raio *= Math.sin(angulo);
        } else if (eixo.equals("z")) {
            raio *= Math.tan(angulo);
        }
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
}
