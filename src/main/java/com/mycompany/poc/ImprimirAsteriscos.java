package com.mycompany.poc;

public class ImprimirAsteriscos {

    private Consola consola;

    public ImprimirAsteriscos(Consola consola) {
        this.consola = consola;
    }

  public void ejecutar(char simbolo) {
      int first = GenerarAsteriscos();
      imprimirAsteriscos(first, simbolo);
  }

  public int GenerarAsteriscos() {
      consola.imprimirMensaje("digite los numeros que desee tener");
      String[] arregloLetras = consola.leerCadena().split(",");
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

  public void imprimirAsteriscos(int x, char simbolo){
      consola.imprimirMensaje("la cantidad en " + simbolo + " del numero mayor son..  ");
      String n = "";
      for (int i = 0; i < x; i++){
          n += " ";
          consola.imprimirMensaje(n + simbolo);
      }
  }

}
