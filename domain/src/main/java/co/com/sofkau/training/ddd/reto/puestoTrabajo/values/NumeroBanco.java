package co.com.sofkau.training.ddd.reto.puestoTrabajo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NumeroBanco implements ValueObject<String> {
    private final String numeroBanco;

    public NumeroBanco(String numeroBanco) {
        this.numeroBanco = Objects.requireNonNull(numeroBanco);
    }

    public static NumeroBanco of(String numeroBanco){
        return new NumeroBanco(numeroBanco);
    }

    @Override
    public String value() {
        return numeroBanco;
    }
}
