package com.mycompany.poc.laberinto;

public enum ElementoLaberinto {
    MURO('@', "|"), ESPACIO('_', " "), PERSONAJE('x', "\uD83D\uDE00");

    char valor;
    String unicode;

    ElementoLaberinto(char valor, String unicode) {
        this.valor = valor;
        this.unicode = unicode;
    }

    public static ElementoLaberinto buscar(char valor, ElementoLaberinto porDefecto) {
        for (ElementoLaberinto elemento : values()) {
            if (elemento.valor == valor) {
                return elemento;
            }
        }
        return porDefecto;
    }

    public String getUnicode() {
        return this.unicode;
    }
}