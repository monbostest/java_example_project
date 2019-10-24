package com.mycompany.poc.consola;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.mycompany.poc.laberinto.ElementoLaberinto;

public class ConsolaAvanzada {

    private Scanner in;
    public Terminal terminal;

    public ConsolaAvanzada() throws IOException {
        this.terminal = new DefaultTerminalFactory(System.out, System.in, Charset.forName("UTF8")).createTerminal();
        this.in = new Scanner(System.in);
    }

    public int leerEntero(int x, int y, String mensaje) {
        try {
            imprimirMensaje(x, y, mensaje);
            String opcion = in.nextLine();
            return Integer.parseInt(opcion);
        } catch (Exception e) {
            return leerEntero(x, y, mensaje);
        }
    }

    public int leerTecla(int x, int y, String mensaje) {
        try {
            imprimirMensaje(x, y, mensaje);
            String opcion = in.nextLine();
            System.out.println((int) opcion.charAt(0));
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    public void imprimirMensaje(int x, int y, String msg, SGR style) {
        try {
            final TextGraphics textGraphics = terminal.newTextGraphics();
            textGraphics.putString(x, y, msg, style);
        } catch (IOException e) {
            /* ignores */
        }
    }

    public void imprimirMensaje(int x, int y, String msg) {
        imprimirMensaje(x, y, msg, SGR.BOLD);
    }

    public String leerCadena() {
        return in.nextLine();
    }

    public void imprimirElemento(ElementoLaberinto elemento, int x, int y) {
        try {
            this.terminal.setCursorPosition(new TerminalPosition(x, y));
            this.terminal.putCharacter(elemento.getUnicode().charAt(0));
        } catch (IOException e) {
            /* ignores */
        }
    }

    public void limpiarPantalla() {
        try {
            terminal.clearScreen();
        } catch (IOException e) {
            /* ignores */
        }
    }

}
