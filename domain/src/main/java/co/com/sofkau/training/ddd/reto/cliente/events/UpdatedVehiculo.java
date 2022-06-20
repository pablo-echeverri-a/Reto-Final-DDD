package co.com.sofkau.training.ddd.reto.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.cliente.identities.VehiculoId;
import co.com.sofkau.training.ddd.reto.cliente.values.*;

public class UpdatedVehiculo extends DomainEvent {
    private final VehiculoId vehiculoId;
    private final TipoVehiculo tipoVehiculo;
    private final Marca marca;
    private final Linea linea;
    private final Modelo modelo;
    private final Placa placa;

    public UpdatedVehiculo(VehiculoId vehiculoId, TipoVehiculo tipoVehiculo, Marca marca, Linea linea, Modelo modelo, Placa placa){
        super("co.com.sofkau.training.ddd.reto.cliente.events.UpdatedVehiculo");

        this.vehiculoId = vehiculoId;
        this.tipoVehiculo = tipoVehiculo;
        this.marca = marca;
        this.linea = linea;
        this.modelo = modelo;
        this.placa = placa;
    }

    public VehiculoId getVehiculoId() {
        return vehiculoId;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public Marca getMarca() {
        return marca;
    }

    public Linea getLinea() {
        return linea;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public Placa getPlaca() {
        return placa;
    }
}
