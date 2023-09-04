/*
 * Infos : 
 * - 4/3 * Math.PI * Math.pow(raio, 3) Formula para calcular volume
 * - 4 * Math.PI * Math.pow(raio, 2) Formula para calcular superficie
 * - Math.pow(raio * 1000, 2) Formula para calcular forca gravitacional
 * - (6.67430e-11 * getMassa()) / Math.pow(raio * 1000, 2) Formula para calcular gravidade
 * - 6.67430e-11 Constante gravitacional
 * - Override : Sobrescreve um metodo da classe pai
 * - Super : Chama o construtor da classe pai
 * - Math.cos/sin/tan(angulo) Formula para calcular rotacao
*/
import java.util.ArrayList;
import java.util.List;

public class Planeta extends CorpoCeleste implements Movimentavel, Gravitacional {
    private Estrela estrelaOrbitada;
    private List<CorpoCeleste> luas;
    private double distanciaAoSol;
    private int numeroDeLuas;
    private double raio;

    public Planeta(String nome, double massa, double distanciaAoSol, int numeroDeLuas, double raio, int idade, Estrela estrelaOrbitada) {
        super(nome, massa, idade);
        this.distanciaAoSol = distanciaAoSol;
        this.numeroDeLuas = numeroDeLuas;
        this.raio = raio;
        this.estrelaOrbitada = estrelaOrbitada;
        this.luas = new ArrayList<>();
    }

    public void adicionarLua(CorpoCeleste lua) {
        this.luas.add(lua);
    }

    public Estrela getEstrelaOrbitada() {
        return estrelaOrbitada;
    }

    public void setEstrelaOrbitada(Estrela estrelaOrbitada) {
        this.estrelaOrbitada = estrelaOrbitada;
    }

    public List<CorpoCeleste> getLuas() {
        return luas;
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
        return "\nO planeta " + getNome() + ", existente a " + getIdade() + " bilhões de anos e possuindo " + getNumeroDeLuas()
        + " lua(s), tem uma massa de " + getMassa() + " kg, um raio de " + getRaio() + " km e sua distância com o Sol é de " 
        + getDistanciaAoSol() + " UA." + "\nInformações extras:" + "\nDensidade: " + calcularDensidade() + " g/cm³"
        + "\nVolume: " + calcularVolume() + " km³" + "\nSuperfície: " + calcularSuperficie() + " km²"
        + "\nGravidade: " + calcularGravidade() + " m/s²";
    }

    public double getDistanciaAoSol() {
        return distanciaAoSol;
    }

    public void setDistanciaAoSol(double distanciaAoSol) {
        this.distanciaAoSol = distanciaAoSol;
    }

    public int getNumeroDeLuas() {
        return numeroDeLuas;
    }

    public void setNumeroDeLuas(int numeroDeLuas) {
        this.numeroDeLuas = numeroDeLuas;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public void transladar(double deltaX, double deltaY, double deltaZ) {
        distanciaAoSol += deltaX;
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
}
