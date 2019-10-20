package com.mycompany.laberinto;

import java.util.List;
import java.util.Optional;

import com.mycompany.poc.Consola;

public class Laberinto {
    private ElementoLaberinto[][] maze;

    private Laberinto(ElementoLaberinto[][] maze) {
        this.maze = maze;
    }

    public void imprimirUsando(Consola consola) {
        for (int i = 0; i < maze.length; i++) {
            ElementoLaberinto[] fila = maze[i];
            for (int j = 0; j < fila.length; j++) {
                consola.imprimirCaracter(fila[j]);
            }
            consola.retornarALaLinea();
        }
    }

    // TODO: crear matriz del laberinto
    public static Laberinto desde(List<String> contenido) {
        // si no hay contenido, retornal null
        if (contenido.size() == 0) {
            return null;
        } else {
            // TODO: atraversar la lista, crear una matriz con el contenido, llamar constructor
            // TODO: utilizar la funcion ElementosLaberinto.desde(valorEnChar,
            // valorPorDefecto)
            int colsAmt = contenido.get(0).length();
            ElementoLaberinto[][] maze = new ElementoLaberinto[contenido.size()][colsAmt];
            for (int i = 0; i < contenido.size(); i++) {
                String linea = contenido.get(i);
                char[] colValues = linea.toCharArray();
                for (int j = 0; j < colValues.length; j++) {
                    char celula = colValues[j];
                    maze[i][j] = ElementoLaberinto.buscar(celula, ElementoLaberinto.MURO);
                }
            }
            return new Laberinto(maze);
        }
    }
}