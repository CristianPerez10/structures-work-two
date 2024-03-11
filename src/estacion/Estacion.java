package src.estacion;

import src.ubicacion.Ubicacion;

public class Estacion {
    private Ubicacion ubicacion;
    private int id;

    public Estacion(Ubicacion ubicacion, int id) {
        this.ubicacion = ubicacion;
        this.id = id;
    };

    public Ubicacion getUbicacion() {
        return this.ubicacion;
    };

    public int getId() {
        return this.id;
    };
}
