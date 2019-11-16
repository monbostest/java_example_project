package com.mycompany.poc.mascotas;

public enum Genero {
    Masculino("H"), Femenino("F");

    private String value;

    Genero(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}