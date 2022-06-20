package co.com.sofkau.training.ddd.reto.servicioRM.values;

import co.com.sofka.domain.generic.ValueObject;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.values.NombreHerramienta;

import java.util.Objects;

public class NombreServicio implements ValueObject<String> {
    private final String nombreServicio;

    public NombreServicio(String nombreServicio) {
        this.nombreServicio = Objects.requireNonNull(nombreServicio);
    }

    public static NombreServicio of(String nombreServicio){
        return new NombreServicio(nombreServicio);
    }

    @Override
    public String value() {
        return nombreServicio;
    }
}
