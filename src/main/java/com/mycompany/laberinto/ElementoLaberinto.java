package com.mycompany.laberinto;

public enum ElementoLaberinto {
    MURO('@', "#"), 
    ESPACIO('_', "_"), 
    PERSONAJE('x', "\uD83D\uDE00");

    char valor;
    String unicode;

    ElementoLaberinto(char valor, String unicode) {
        this.valor = valor;
        this.unicode = unicode;
    }
	public static ElementoLaberinto from(char valor, ElementoLaberinto porDefecto) {
        for(ElementoLaberinto elemento: values()) {
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