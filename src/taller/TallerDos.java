package src.taller;

import src.estacion.Estacion;
import src.persona.Persona;
import src.ubicacion.Ubicacion;

import java.util.List;

public class TallerDos {
    private List<Persona> personas;
    private List<Estacion> estaciones;

    public TallerDos(int numPersonas, int numEstaciones) {
        generarEstacionesYPersonas(numPersonas, numEstaciones);
    }

    private Ubicacion obtenerUbicacionAleatoria() {
        int minSquareArea = 1;
        int maxSquareArea = 10;

        // Se crea la ubicacion en un rango 10km * 10km
        int ubiX = (int) ((Math.random() * (maxSquareArea - minSquareArea)) + minSquareArea);
        int ubiY = (int) ((Math.random() * (maxSquareArea - minSquareArea)) + minSquareArea);
        Ubicacion ubicacion = new Ubicacion(ubiX, ubiY);

        return ubicacion;
    }

    private void generarEstacionesYPersonas(int numPersonas, int numEstaciones) {
        for (int indexPersona = 0; indexPersona <= numPersonas; indexPersona++) {
            Ubicacion ubicacion = obtenerUbicacionAleatoria();

            // Se crea la persona y se agrega a la lista.
            Persona persona = new Persona(ubicacion, indexPersona);
            personas.add(persona);
        }

        for (int indexEstacion = 0; indexEstacion <= numEstaciones; indexEstacion++) {
            Ubicacion ubicacion = obtenerUbicacionAleatoria();

            // Se crea la persona y se agrega a la lista.
            Estacion persona = new Estacion(ubicacion, indexEstacion);
            estaciones.add(persona);
        }
    }

    public static void asignarEstaciones(List<Persona> personas, List<Estacion> estaciones) {

    }
}
