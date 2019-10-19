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

    public void imprimirMensaje(String msg) {
        System.out.println(msg);
    }

	public String leerCadena() {
		return in.nextLine();
	}

	public void imprimirCaracter(ElementoLaberinto elemento) {
        System.out.print(elemento.getUnicode());
	}

	public void retornarALaLinea() {
        System.out.println();
	}
}