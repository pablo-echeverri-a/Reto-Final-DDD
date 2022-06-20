package co.com.sofkau.training.ddd.reto.factura.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Horas implements ValueObject<Integer> {
    private final Integer horas;

    public Horas(Integer horas) {
        this.horas = Objects.requireNonNull(horas);
    }

    public static Horas of(Integer horas){
        return new Horas(horas);
    }

    @Override
    public Integer value() {
        return horas;
    }
}
