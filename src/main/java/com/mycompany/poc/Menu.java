package com.mycompany.poc;

public class Menu {

    public static final int MENU_SALIR = 0;
    public static final int MENU_ASTERISCOS = 1;

    private ImprimirAsteriscos asteriscos;

    private Consola consola;

    public Menu(Consola consola, ImprimirAsteriscos asteriscos) {
        this.consola = consola;
        this.asteriscos = asteriscos;
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
            asteriscos.ejecutar();
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
        consola.imprimirMensaje("[" + MENU_SALIR + "] Salir");
    }

}
