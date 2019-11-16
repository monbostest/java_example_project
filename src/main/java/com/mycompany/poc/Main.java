package com.mycompany.poc;

import com.mycompany.poc.ImprimirAsteriscos;
import com.mycompany.poc.mascotas.*;

public class Main {
    public static void main(String[] args) {
      Consola consola = new Consola();
      ImprimirAsteriscos asteriscos = new ImprimirAsteriscos(consola);
      LeerMascotas mascotas = new LeerMascotas(consola, "mascotas.csv");
      Menu menu = new Menu(consola, asteriscos, mascotas);
      menu.ejecutar();
    }
}
