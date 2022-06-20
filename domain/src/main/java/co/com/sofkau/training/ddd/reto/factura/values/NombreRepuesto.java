package co.com.sofkau.training.ddd.reto.factura.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreRepuesto implements ValueObject<String> {
    private final String nombre;

    public NombreRepuesto(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }

    public static NombreRepuesto of(String nombre){
        return new NombreRepuesto(nombre);
    }

    @Override
    public String value() {
        return nombre;
    }
}
