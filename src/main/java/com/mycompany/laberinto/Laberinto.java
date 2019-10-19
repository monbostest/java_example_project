package com.mycompany.laberinto;

import java.util.List;
import java.util.Optional;

import com.mycompany.poc.Consola;

public class Laberinto {
    private ElementoLaberinto[][] maze;

    private Laberinto(ElementoLaberinto[][] maze) {
        this.maze = maze;
    }

    public void imprimir(Consola consola) {
        for (int i = 0; i < maze.length; i++) {
            ElementoLaberinto[] fila = maze[i];
            for (int j = 0; j < fila.length; j++) {
                consola.imprimirCaracter(fila[j]);
            }
            consola.retornarALaLinea();
        }
    }

    // TODO: crear matriz del laberinto
    public static Optional<Laberinto> from(List<String> contenido) {
        if (contenido.size() == 0) {
            // TODO: Optional.empty();
            return Optional.empty();
        } else {
            // TODO: atraversas la lista, crear una matriz con el contenido, llamar
            // Optional.of(...)
            // TODO: utilizar la funcion ElementosLaberinto.from(valorEnChar,
            // valorPorDefecto)
            int colsAmt = contenido.get(0).length();
            ElementoLaberinto[][] maze = new ElementoLaberinto[contenido.size()][colsAmt];
            for (int i = 0; i < contenido.size(); i++) {
                String linea = contenido.get(i);
                char[] colValues = linea.toCharArray();
                for (int j = 0; j < colValues.length; j++) {
                    char cell = colValues[j];
                    maze[i][j] = ElementoLaberinto.from(cell, ElementoLaberinto.MURO);
                }
            }
            return Optional.of(new Laberinto(maze));
        }
    }
}