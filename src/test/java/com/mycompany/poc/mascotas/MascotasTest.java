package com.mycompany.poc.mascotas;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class MascotasTest {

    @Test
    public void should_transform_valid_male_pets() {
        // Given
        Mascota expected = new Mascota("scoody", "french poodle", Genero.Masculino);
        // When
        Mascota result = Mascota.transformarEnMascota("scoody, french poodle, negro, M");
        // Then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void should_transform_valid_feminine_pets() {
        // Given
        Mascota expected = new Mascota("bertha", "bulldog", Genero.Femenino);
        // When
        Mascota result = Mascota.transformarEnMascota("bertha, bulldog, negro, F");
        // Then
        assertThat(result).isEqualTo(expected);
    }


    @Test
    public void should_detect_invalid_genre() {
        // When
        Mascota result = Mascota.transformarEnMascota("bertha, bulldog, negro, X");
        // Then
        assertThat(result).isNull();
        ;
    }

    @Test
    public void should_detect_too_short_lines() {
        // When
        Mascota result = Mascota.transformarEnMascota("algo invalido");
        // Then
        assertThat(result).isNull();
        ;
    }

    @Test
    public void should_detect_too_large_lines() {
        // When
        Mascota result = Mascota.transformarEnMascota("bertha, bulldog, negro, algo, mas, F");
        // Then
        assertThat(result).isNull();
        ;
    }

}
