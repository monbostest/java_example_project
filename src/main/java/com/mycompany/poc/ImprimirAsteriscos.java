package com.mycompany.poc;

import java.util.Scanner;

/**
 *
 */
public class ImprimirAsteriscos {

  public void ejecutar() {
      int first = GenerarAsteriscos();
      imprimirAsteriscos(first);
  }

  public int GenerarAsteriscos() {
      Scanner teclado = new Scanner(System.in);
      System.out.println("digite los numeros que desee tener");
      String numeros = teclado.nextLine();

      String[] arregloLetras = numeros.split(",");
      return numeroMayor(arregloLetras);
  }

  public int numeroMayor(String[] data) {
      int[] arregloNumeros = new int[data.length];
      for (int i = 0; i < arregloNumeros.length; i++) {
          arregloNumeros[i] = Integer.parseInt(data[i]);
      }

      int firts = arregloNumeros[0];
      for (int j = 1; j < arregloNumeros.length; j++){
          if (arregloNumeros[j] > firts){
              firts = arregloNumeros[j];
          }
      }
      return firts;
  }

  public void imprimirAsteriscos(int x){
      System.out.println("la cantidad en * del numero mayor son..  ");
      String n = "";
      for (int i = 0; i < x; i++){
          n += " ";
          System.out.println(n + "*");
      }
  }

}
