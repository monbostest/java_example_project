package com.mycompany.poc;

import com.mycompany.poc.mascotas.LeerMascotas;

public class Menu {

    public static final int MENU_SALIR = 0;
    public static final int MENU_ASTERISCOS = 1;
    public static final int MENU_MASCOTAS = 2;

    private ImprimirAsteriscos asteriscos;

    private Consola consola;
    private LeerMascotas mascotas;

    public Menu(Consola consola, ImprimirAsteriscos asteriscos, LeerMascotas mascotas) {
        this.consola = consola;
        this.asteriscos = asteriscos;
        this.mascotas = mascotas;
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
        case MENU_MASCOTAS:
            mascotas.ejecutar();
            bucleMenu();
        case MENU_SALIR:
            break;
        default:
            consola.imprimirMensaje("Digito no valido, vuelva a intertarlo");
            ejecutar();
        }
    }

    private void mostrarTitulo() {
        consola.imprimirMensaje("  ---  Welcome to aplication  ----  ");
    }

    private void mostrarMenuPrincipal() {
        consola.imprimirMensaje("select one option:");
        consola.imprimirMensaje("[" + MENU_ASTERISCOS + "] Imprimir asteriscos");
        consola.imprimirMensaje("[" + MENU_MASCOTAS + "] Mostrar mascotas");
        consola.imprimirMensaje("[" + MENU_SALIR + "] Salir");
    }

}
