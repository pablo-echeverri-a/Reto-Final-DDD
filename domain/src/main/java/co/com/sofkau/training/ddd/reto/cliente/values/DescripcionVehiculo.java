package co.com.sofkau.training.ddd.reto.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

public class DescripcionVehiculo implements ValueObject<DescripcionVehiculo> {
    private final TiposVehiculos tipoVehiculo;
    private final String marca;
    private final String linea;
    private final String modelo;

    public DescripcionVehiculo(TiposVehiculos tipoVehiculo, String marca, String linea, String modelo) {
        this.tipoVehiculo = tipoVehiculo;
        this.marca = marca;
        this.linea = linea;
        this.modelo = modelo;
    }

    @Override
    public DescripcionVehiculo value() {
        return new DescripcionVehiculo(tipoVehiculo, marca, linea, modelo);
    }

    public enum TiposVehiculos {
        MOTO, AUTOMOVIL, CAMIONETA
    }
}
