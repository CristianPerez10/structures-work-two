package src.ubicacion;

public class Ubicacion {
    private int x;
    private int y;

    public Ubicacion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    };

    public int getY() {
        return this.y;
    };

    public double obtenerDistancia(Ubicacion punto) {
        double distancia = Math.sqrt(Math.pow(this.x - punto.getX(), 2) + Math.pow(this.y - punto.getY(), 2));
        return distancia;
    };
}
// LAKERS IN FIVE