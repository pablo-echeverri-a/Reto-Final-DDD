package co.com.sofkau.training.ddd.reto.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Modelo implements ValueObject<String> {
    private final String modelo;

    public Modelo(String modelo) {
        this.modelo = Objects.requireNonNull(modelo);
    }

    public static Modelo of(String modelo){
        return new Modelo(modelo);
    }

    @Override
    public String value() {
        return modelo;
    }
}
