package src.taller;

import src.estacion.Estacion;
import src.persona.Persona;
import src.ubicacion.Ubicacion;

import java.util.ArrayList;
import java.util.List;

public class TallerDos {
    private List<Persona> personas = new ArrayList<Persona>();
    private List<Estacion> estaciones = new ArrayList<Estacion>();

    public TallerDos(int numPersonas, int numEstaciones) {
        generarEstacionesYPersonas(numPersonas, numEstaciones);
        asignarEstaciones(personas, estaciones);
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
        for (int indexPersona = 1; indexPersona <= numPersonas; indexPersona++) {
            Ubicacion ubicacion = obtenerUbicacionAleatoria();

            // Se crea la persona y se agrega a la lista.
            Persona persona = new Persona(ubicacion, indexPersona);
            personas.add(persona);
        }

        for (int indexEstacion = 1; indexEstacion <= numEstaciones; indexEstacion++) {
            Ubicacion ubicacion = obtenerUbicacionAleatoria();

            // Se crea la persona y se agrega a la lista.
            Estacion estacion = new Estacion(ubicacion, indexEstacion);
            estaciones.add(estacion);
        }
    }

    public static List<Persona> asignarEstaciones(List<Persona> personas, List<Estacion> estaciones) {
        for (Persona persona : personas) {
            Ubicacion ubiPersona = persona.getUbicacion();

            // Se toma la estacion mas cercana como la primera del arreglo.
            Estacion estacionMasCercana = estaciones.get(0);

            for (Estacion estacion : estaciones) {
                double distEstActual = ubiPersona.obtenerDistancia(estacion.getUbicacion());
                double distEstMasCercana = ubiPersona.obtenerDistancia(estacionMasCercana.getUbicacion());

                if (distEstActual < distEstMasCercana) {
                    estacionMasCercana = estacion;
                }
            }

            persona.setEstacionBase(estacionMasCercana);
        }
        return personas;
    }

    public static long medirTiempo(int numPersonas, int numEstaciones, int k) {
        TallerDos tallerDos = new TallerDos(numPersonas, numEstaciones);
        long tiempoTotal = 0;

        for (int i = 0; i < k; i++) {
            long tiempoInicio = System.currentTimeMillis();
            asignarEstaciones(tallerDos.personas, tallerDos.estaciones);
            long tiempoFin = System.currentTimeMillis();
            tiempoTotal += tiempoFin - tiempoInicio;
        }

        return tiempoTotal / k; // Tiempo promedio
    }
    	
    public static void main(String[] args) {

        long tiempoPromedio = medirTiempo(1000000, 30, 10);
        System.out.println("Tiempo de ejecución promedio: " + tiempoPromedio + " milisegundos");
    }
}
