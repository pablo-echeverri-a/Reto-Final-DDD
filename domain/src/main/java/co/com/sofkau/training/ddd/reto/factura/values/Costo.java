package co.com.sofkau.training.ddd.reto.factura.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Costo implements ValueObject<Integer> {
    private final Integer costo;

    public Costo(Integer costo) {
        this.costo = Objects.requireNonNull(costo);
    }

    public static Costo of(Integer costo){
        return new Costo(costo);
    }

    @Override
    public Integer value() {
        return costo;
    }
}
