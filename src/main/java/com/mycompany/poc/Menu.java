package com.mycompany.poc;

import com.mycompany.poc.asteriscos.ImprimirAsteriscos;
import com.mycompany.poc.consola.Consola;
import com.mycompany.poc.laberinto.Laberinto;
import com.mycompany.poc.laberinto.LaberintoBuilder;

public class Menu {

    public static final int MENU_SALIR = 0;
    public static final int MENU_ASTERISCOS = 1;
    public static final int MENU_LABERINTO = 2;

    private ImprimirAsteriscos asteriscos;
    private LaberintoBuilder laberintoBuilder;
    private Consola consola;

    public Menu(Consola consola, ImprimirAsteriscos asteriscos, LaberintoBuilder laberintoBuilder) {
        this.asteriscos = asteriscos;
        this.laberintoBuilder = laberintoBuilder;
        this.consola = consola;
    }

    public void ejecutar() {
        mostrarTitulo();
        bucleMenu();
    }

    public void bucleMenu() {
        consola.limpiarPantalla();
        mostrarMenuPrincipal();
        int opcion = consola.leerEntero("Opcion:");
        switch (opcion) {
        case MENU_ASTERISCOS:
            asteriscos.ejecutar('D');
            bucleMenu();
        case MENU_LABERINTO:
            Laberinto laberinto = laberintoBuilder.cargarDesdeArchivo();
            if (laberinto != null) {
                bucleLaberinto(laberinto);
            }
            bucleMenu();
        case MENU_SALIR:
            break;
        default:
            break;
        }
    }

    private void bucleLaberinto(Laberinto laberinto) {
        consola.limpiarPantalla();
        laberinto.imprimir();
        int opcion = consola.leerTecla("Z|Q|S|D:");

        // bucleLaberinto(laberinto);
    }

    private void mostrarTitulo() {
        consola.imprimirMensaje("== Bienvenido a la aplicación ==");
    }

    private void mostrarMenuPrincipal() {
        consola.imprimirMensaje("Seleccione una de las siguientes opciones:");
        consola.imprimirMensaje("[" + MENU_ASTERISCOS + "] Imprimir asteriscos");
        consola.imprimirMensaje("[" + MENU_LABERINTO + "] Imprimir laberinto");
        consola.imprimirMensaje("[" + MENU_SALIR + "] Salir");
    }

}
