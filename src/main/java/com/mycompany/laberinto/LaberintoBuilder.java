package com.mycompany.laberinto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.mycompany.poc.Consola;

public class LaberintoBuilder {

    private Consola consola;

    public LaberintoBuilder(Consola consola) {
        this.consola = consola;
    }

    public Optional<Laberinto> cargarDesdeArchivo() {
        List<String> contenido = Arrays.asList(
                new StringBuilder().append(ElementoLaberinto.MURO.valor).append(ElementoLaberinto.ESPACIO.valor)
                        .append(ElementoLaberinto.MURO.valor).toString(),
                new StringBuilder().append(ElementoLaberinto.MURO.valor).append(ElementoLaberinto.ESPACIO.valor)
                        .append(ElementoLaberinto.PERSONAJE.valor).toString());
        return Laberinto.from(contenido);
    }

}