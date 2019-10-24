package com.mycompany.poc.laberinto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.poc.consola.Consola;
import com.mycompany.poc.consola.ConsolaAvanzada;

public class LaberintoBuilder {

    private Consola consolaSimple;
    private ConsolaAvanzada consolaAvanzada;

    public LaberintoBuilder(Consola consolaSimple, ConsolaAvanzada consolaAvanzada) {
        this.consolaSimple = consolaSimple;
        this.consolaAvanzada = consolaAvanzada;
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
            consolaSimple.imprimirMensaje(ex.getMessage());
        }
        return Laberinto.desde(contenido, consolaAvanzada, consolaSimple);
    }

    private File getFileFromResources(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file was not found!");
        } else {
            return new File(resource.getFile());
        }
    }

}
