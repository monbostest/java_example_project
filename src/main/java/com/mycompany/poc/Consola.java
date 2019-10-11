package com.mycompany.poc;

import java.util.Scanner;

public class Consola {

    private Scanner in;

    public Consola() {
        this.in = new Scanner(System.in);
    }

    public int leerEntero() {
        try {
            String opcion = in.nextLine();
            return Integer.parseInt(opcion);
        } catch (Exception e) {
            return leerEntero();
        }
    }

    public void imprimirMensaje(String msg) {
        System.out.println(msg);
    }

	public String leerCadena() {
		return in.nextLine();
	}
}