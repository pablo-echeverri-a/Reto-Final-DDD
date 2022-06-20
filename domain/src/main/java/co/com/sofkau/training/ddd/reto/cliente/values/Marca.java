package co.com.sofkau.training.ddd.reto.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Marca implements ValueObject<String> {
    private final String marca;

    public Marca(String marca) {
        this.marca = Objects.requireNonNull(marca);
    }

    public static Marca of(String marca){
        return new Marca(marca);
    }

    @Override
    public String value() {
        return marca;
    }
}
