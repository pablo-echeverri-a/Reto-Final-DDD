package co.com.sofkau.training.ddd.reto.puestoTrabajo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Sector implements ValueObject<String> {
    private final String sector;

    public Sector(String sector) {
        this.sector = Objects.requireNonNull(sector);
    }

    public static Sector of(String sector){
        return new Sector(sector);
    }

    @Override
    public String value() {
        return sector;
    }
}
