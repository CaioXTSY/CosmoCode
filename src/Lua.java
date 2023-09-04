package src;

public class Lua extends CorpoCeleste implements Movimentavel, Gravitacional {
    private double raio;
    private Planeta planeta;

    public Lua(String nome, double massa, int idade, double raio, Planeta planeta) {
        super(nome, massa, idade);
        this.raio = raio;
        this.planeta = planeta;
    }

    public Planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(Planeta planeta) {
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
        return "Lua orbitando o planeta " + planeta.getNome();
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

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
}
