package com.mycompany.poc;

import java.util.Scanner;

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

    public Object leer_nombre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}