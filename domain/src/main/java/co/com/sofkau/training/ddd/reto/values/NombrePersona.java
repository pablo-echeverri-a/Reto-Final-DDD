package co.com.sofkau.training.ddd.reto.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombrePersona implements ValueObject<String> {
    private final String nombre;
    private final String apellido;

    public NombrePersona(String nombre, String apellido) {
        this.nombre = Objects.requireNonNull(nombre);
        this.apellido = Objects.requireNonNull(apellido);
    }

    public static NombrePersona of(String nombre, String apellido){
        return new NombrePersona(nombre, apellido);
    }

    @Override
    public String value() {
        return nombre + " " + apellido;
    }
}
