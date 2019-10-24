package com.mycompany.poc.laberinto;

import java.util.List;

import com.mycompany.poc.consola.Consola;
import com.mycompany.poc.consola.ConsolaAvanzada;

public class Laberinto {
    private ElementoLaberinto[][] maze;
    private ConsolaAvanzada consolaAvanzada;
    private Consola consola;

    private Laberinto(ElementoLaberinto[][] maze, ConsolaAvanzada consolaAvanzada, Consola consola) {
        this.maze = maze;
        this.consolaAvanzada = consolaAvanzada;
        this.consola = consola;
    }

    // TODO: add instructions
    public void imprimir() {
        // 15 x 187
        for (int i = 0; i < maze.length; i++) {
            ElementoLaberinto[] fila = maze[i];
            for (int j = 0; j < fila.length; j++) {
                consolaAvanzada.imprimirElemento(fila[j], j, i);
            }
        }
    }

    // ------------------------------------------------------------------------
    // Funcionas estáticas no dependen de una instancia en particular
    // ------------------------------------------------------------------------
    // TODO: add instructions
    public static Laberinto desde(List<String> contenido, ConsolaAvanzada consolaAvanzada, Consola consola) {
        // si no hay contenido, retornal null
        if (contenido.size() == 0) {
            return null;
        } else {
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
            return new Laberinto(maze, consolaAvanzada, consola);
        }
    }
}
