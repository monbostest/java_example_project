package com.mycompany.poc.mascotas;

import java.io.File;
import java.util.List;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import com.mycompany.poc.Consola;

public class LeerMascotasTest {

    @Test
    public void should_read_pets_from_file() {
        // Given
        Consola consola = new Consola();
        LeerMascotas mascotas = new LeerMascotas(consola, "mascotas.csv");
        File archivo = mascotas.leerArchivo("mascotas.csv");

        // When
        List<Mascota> resultado = mascotas.leerMascotas(archivo);

        // Then
        assertThat(resultado).containsExactly(
            new Mascota("scoody", "french poodle", Genero.Masculino),
            new Mascota("ruffo", "desconocido", Genero.Masculino),
            new Mascota("bertha", "bulldog", Genero.Femenino)
        );
    }

}
