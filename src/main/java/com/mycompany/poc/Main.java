package com.mycompany.poc;

import com.mycompany.laberinto.LaberintoBuilder;

public class Main {
    public static void main(String[] args) {
      Consola consola = new Consola();
      ImprimirAsteriscos asteriscos = new ImprimirAsteriscos(consola);
      LaberintoBuilder laberintoBuilder = new LaberintoBuilder(consola);
      Menu menu = new Menu(consola, asteriscos, laberintoBuilder);
      menu.ejecutar();
    }
}
