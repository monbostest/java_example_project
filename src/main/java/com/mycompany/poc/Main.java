package com.mycompany.poc;

import java.io.IOException;

import com.mycompany.poc.asteriscos.ImprimirAsteriscos;
import com.mycompany.poc.consola.Consola;
import com.mycompany.poc.consola.ConsolaAvanzada;
import com.mycompany.poc.laberinto.LaberintoBuilder;

public class Main {
  public static void main(String[] args) throws IOException {
    Consola consolaSimple = new Consola();
    ConsolaAvanzada consolaAvanzada = new ConsolaAvanzada();
    ImprimirAsteriscos asteriscos = new ImprimirAsteriscos(consolaSimple);
    LaberintoBuilder laberintoBuilder = new LaberintoBuilder(consolaSimple, consolaAvanzada);
    Menu menu = new Menu(consolaSimple, asteriscos, laberintoBuilder);
    menu.ejecutar();
  }
}
