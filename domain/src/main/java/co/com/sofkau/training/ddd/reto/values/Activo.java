package co.com.sofkau.training.ddd.reto.values;

import co.com.sofka.domain.generic.ValueObject;

public class Activo implements ValueObject<Boolean> {
    private final Boolean activo;

    public Activo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public Boolean value() {
        return activo;
    }
}
