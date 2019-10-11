package com.mycompany.poc;

import com.mycompany.poc.ImprimirAsteriscos;

public class Main {
    public static void main(String[] args) {
      Consola consola = new Consola();
      ImprimirAsteriscos asteriscos = new ImprimirAsteriscos(consola);
      Menu menu = new Menu(consola, asteriscos);
      menu.ejecutar();
    }
}
