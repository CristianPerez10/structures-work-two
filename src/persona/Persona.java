package src.persona;

import src.estacion.Estacion;
import src.ubicacion.Ubicacion;

public class Persona {

    private Estacion estacionBase = null;
    private Ubicacion ubicacion;
    private int id;

    public Persona(Ubicacion ubicacion, int id) {
        this.ubicacion = ubicacion;
        this.id = id;
    };
}