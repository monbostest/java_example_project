package com.mycompany.poc.mascotas;

import java.util.Objects;

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
        buf.append("Nombre: ").append(nombre).append(", Raza: ").append(raza).append(", Genero: ")
                .append(genero.value());
        return buf.toString();
    }

    public static Mascota transformarEnMascota(String linea) {
        // TODO: transformar la linea en una mascota
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Mascota mascota = (Mascota) o;
        return Objects.equals(nombre, mascota.nombre) && Objects.equals(raza, mascota.raza) && genero == mascota.genero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, raza, genero);
    }
}
