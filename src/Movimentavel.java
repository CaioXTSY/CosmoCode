public interface Movimentavel {
    void transladar(double deltaX, double deltaY, double deltaZ);

    void rotacionar(double angulo, String eixo);

}
