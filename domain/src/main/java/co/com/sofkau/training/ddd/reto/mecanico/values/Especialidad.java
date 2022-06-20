package co.com.sofkau.training.ddd.reto.mecanico.values;

import co.com.sofka.domain.generic.ValueObject;
import co.com.sofkau.training.ddd.reto.cliente.values.TipoVehiculo;

import java.util.Objects;

public class Especialidad implements ValueObject<Especialidad.Especialidades> {

    private final Especialidades especialidad;

    public Especialidad(Especialidades especialidad) {
        this.especialidad = Objects.requireNonNull(especialidad);
    }

    public static Especialidad of(Especialidad.Especialidades especialidad) {
        return new Especialidad(especialidad);
    }

    @Override
    public Especialidad.Especialidades value() {
        return especialidad;
    }

    public enum Especialidades {
        SUSPENSION, MOTOR, ELECTRICIDAD, GENERAL
    }

}
