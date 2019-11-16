package com.mycompany.poc.mascotas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.poc.Consola;

public class LeerMascotas {

    private String archivo;
    private Consola consola;

    public LeerMascotas(Consola consola, String archivo) {
        this.consola = consola;
        this.archivo = archivo;
    }

	public void ejecutar() {
        consola.imprimirMensaje("========================");
        consola.imprimirMensaje("Se encontraron las siguientes mascotas:");
        for (Mascota mascota: leerMascotas(leerArchivo(archivo))) {
            consola.imprimirMensaje(mascota.toString());
        }
        consola.imprimirMensaje("========================");
    }

    private List<Mascota> leerMascotas(File file) {
        List<Mascota> mascotas = new ArrayList<>();
        if (file == null) return mascotas;

        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {

            String linea;
            while ((linea = br.readLine()) != null) {
                Mascota mascota = Mascota.transformarEnMascota(linea);
                // TODO: adicionar la mascota al arreglo SOLO si no es NULL
            }
        } catch(IOException err) {
            // ignora el mensaje de error
            err.printStackTrace();
        }
        return mascotas;
    }

    private File leerArchivo(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource != null) {
            return new File(resource.getFile());
        } else {
            return null;
        }
    }
}