package co.com.sofkau.training.ddd.reto.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Linea implements ValueObject<String> {
    private final String linea;

    public Linea(String linea) {
        this.linea = Objects.requireNonNull(linea);
    }

    public static Linea of(String linea){
        return new Linea(linea);
    }

    @Override
    public String value() {
        return linea;
    }
}
