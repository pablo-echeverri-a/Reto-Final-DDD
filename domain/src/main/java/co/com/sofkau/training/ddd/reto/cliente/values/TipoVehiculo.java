package co.com.sofkau.training.ddd.reto.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoVehiculo implements ValueObject<TipoVehiculo.TiposVehiculos> {
    private final TiposVehiculos tipoVehiculo;

    public TipoVehiculo(TiposVehiculos tipoVehiculo) {
        this.tipoVehiculo = Objects.requireNonNull(tipoVehiculo);
    }

    public static TipoVehiculo of(TiposVehiculos tipoVehiculo) {
        return new TipoVehiculo(tipoVehiculo);
    }

    @Override
    public TiposVehiculos value() {
        return tipoVehiculo;
    }

    public enum TiposVehiculos {
        MOTO, AUTOMOVIL, CAMIONETA
    }
}
