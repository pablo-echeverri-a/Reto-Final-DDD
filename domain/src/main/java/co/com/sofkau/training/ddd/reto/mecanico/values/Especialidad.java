package co.com.sofkau.training.ddd.reto.mecanico.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Especialidad implements ValueObject<Especialidad.Especialidades> {

    private final Especialidades especialidad;

    public Especialidad(Especialidades especialidad) {
        this.especialidad = Objects.requireNonNull(especialidad);
    }

    public Especialidades value() {
        return especialidad;
    }

    public enum Especialidades {
        SUSPENSION, MOTOR, ELECTRICIDAD, GENERAL
    }
}
