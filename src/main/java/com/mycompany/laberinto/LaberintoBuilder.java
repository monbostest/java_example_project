package com.mycompany.laberinto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.poc.Consola;

public class LaberintoBuilder {

    private Consola consola;

    public LaberintoBuilder(Consola consola) {
        this.consola = consola;
    }

    public Laberinto cargarDesdeArchivo() {
        List<String> contenido = new ArrayList<String>();
        try (FileReader reader = new FileReader((getFileFromResources("laberinto.txt")));
                BufferedReader br = new BufferedReader(reader)) {

            String line;
            while ((line = br.readLine()) != null) {
                contenido.add(line);
            }
        } catch (Exception ex) {
            consola.imprimirMensaje(ex.getMessage());
        }
        return Laberinto.desde(contenido);
    }

    private File getFileFromResources(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }

}