package co.com.sofkau.training.ddd.reto.puestoTrabajo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreHerramienta implements ValueObject<String> {
    private final String nombreHerramienta;

    public NombreHerramienta(String nombreHerramienta) {
        this.nombreHerramienta = Objects.requireNonNull(nombreHerramienta);
    }

    public static NombreHerramienta of(String nombreHerramienta){
        return new NombreHerramienta(nombreHerramienta);
    }

    @Override
    public String value() {
        return nombreHerramienta;
    }
}
