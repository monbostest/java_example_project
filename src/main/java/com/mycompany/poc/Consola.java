package com.mycompany.poc;

import java.util.Scanner;

import com.mycompany.laberinto.ElementoLaberinto;

public class Consola {

    private Scanner in;

    public Consola() {
        this.in = new Scanner(System.in);
    }

    public int leerEntero(String mensaje) {
        try {
            imprimirMensaje(mensaje);
            String opcion = in.nextLine();
            return Integer.parseInt(opcion);
        } catch (Exception e) {
            return leerEntero(mensaje);
        }
    }

    public int leerTecla(String mensaje) {
        try {
            imprimirMensaje(mensaje);
            String opcion = in.nextLine();
            System.out.println((int) opcion.charAt(0));
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    public void imprimirMensaje(String msg) {
        System.out.println(msg);
    }

    public String leerCadena() {
        return in.nextLine();
    }

    public void imprimirCaracter(ElementoLaberinto elemento) {
        System.out.print(elemento.getUnicode());
    }

    public void limpiarPantalla() {
        System.out.print("\033[2J");
    }

    public void retornarALaLinea() {
        System.out.println();
    }
}
