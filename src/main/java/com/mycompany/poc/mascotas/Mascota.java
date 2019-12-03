package com.mycompany.poc.mascotas;


import static java.lang.System.in;


public class Mascota {
    
    private String nombre;
    private String raza;
    private Genero genero;

    public Mascota(String nombre, String raza, Genero genero) {
        this.nombre = nombre;
        this.raza = raza;
        this.genero = genero;
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf
        .append("Nombre: ").append(nombre)
        .append("Raza: ").append(raza)
        .append("Genero: ").append(genero.value());
        return buf.toString();
    }

	public static Mascota transformarEnMascota(String linea) {
        // TODO: transformar la linea en una mascota
            try {
            imprimirMensaje(linea);
        } catch (Exception e) {
            return transformarEnMascota(linea);
        }
            return null;
	}
        
        private static void imprimirMensaje(String linea) {
        System.out.println(linea);
        
    }
    
}