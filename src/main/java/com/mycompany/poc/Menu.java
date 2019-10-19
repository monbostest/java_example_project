package com.mycompany.poc;

import java.util.Optional;

import com.mycompany.laberinto.Laberinto;
import com.mycompany.laberinto.LaberintoBuilder;

public class Menu {

    public static final int MENU_SALIR = 0;
    public static final int MENU_ASTERISCOS = 1;
    public static final int MENU_LABERINTO = 2;

    private ImprimirAsteriscos asteriscos;
    private LaberintoBuilder laberintoBuilder;
    private Consola consola;

    public Menu(Consola consola, ImprimirAsteriscos asteriscos, LaberintoBuilder laberintoBuilder) {
        this.consola = consola;
        this.asteriscos = asteriscos;
        this.laberintoBuilder = laberintoBuilder;
    }

    public void ejecutar() {
        mostrarTitulo();
        bucleMenu();
    }

    public void bucleMenu() {
        mostrarMenuPrincipal();
        int opcion = consola.leerEntero("Opcion:");
        switch (opcion) {
        case MENU_ASTERISCOS:
            asteriscos.ejecutar('D');
            bucleMenu();
        case MENU_LABERINTO:
            Optional<Laberinto> maybeLaberinto = laberintoBuilder.cargarDesdeArchivo();
            maybeLaberinto.ifPresent(lab -> lab.imprimir(consola));
            bucleMenu();
        case MENU_SALIR:
            break;
        default:
            break;
        }
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
