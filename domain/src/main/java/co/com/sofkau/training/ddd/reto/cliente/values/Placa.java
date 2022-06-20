package co.com.sofkau.training.ddd.reto.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Placa implements ValueObject<String> {
    private final String placa;

    public Placa(String placa) {
        this.placa = Objects.requireNonNull(placa);
    }

    public static Placa of(String placa){
        return new Placa(placa);
    }

    @Override
    public String value() {
        return placa;
    }
}
