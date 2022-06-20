package co.com.sofkau.training.ddd.reto.mecanico.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Codigo implements ValueObject<String> {
    private final String codigo;

    public Codigo(String codigo) {
        this.codigo = Objects.requireNonNull(codigo);
    }

    public static Codigo of(String codigo){
        return new Codigo(codigo);
    }

    @Override
    public String value() {
        return codigo;
    }
}
