package src.persona;

import src.estacion.Estacion;
import src.ubicacion.Ubicacion;

public class Persona {
    private Estacion estacionBase; // TIPO DATO ESTACION DEL ADT ESTACION
    private Ubicacion ubicacion; // TIPO UBICACION DEL ADT UBICACION
    private int id; // UN ID QUE NOS AYUDE A TENER RASTRO UNICO A LAS PERSONAS

    // CONSTRUCTOR
    public Persona(Ubicacion ubicacion, int id) {
        this.ubicacion = ubicacion;
        this.id = id;
    };

    // METODOS AUXILIARES PARA EL PROGRAMA
    public int getId() {
        return this.id;
    };

    public Ubicacion getUbicacion() {
        return this.ubicacion;
    };

    public Estacion getEstacionBase() {
        return this.estacionBase;
    };

    public void setEstacionBase(Estacion estacionBase) {
        this.estacionBase = estacionBase;
    };
}