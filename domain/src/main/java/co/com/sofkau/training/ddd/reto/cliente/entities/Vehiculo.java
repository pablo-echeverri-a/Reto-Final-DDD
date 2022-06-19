package co.com.sofkau.training.ddd.reto.cliente.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.training.ddd.reto.cliente.identities.VehiculoId;
import co.com.sofkau.training.ddd.reto.cliente.values.DescripcionVehiculo;
import co.com.sofkau.training.ddd.reto.cliente.values.Placa;

public class Vehiculo extends Entity<VehiculoId> {
    private DescripcionVehiculo descripcionVehiculo;
    private Placa placa;

    public Vehiculo(VehiculoId entityId, DescripcionVehiculo descripcionVehiculo, Placa placa) {
        super(entityId);
        this.descripcionVehiculo = descripcionVehiculo;
        this.placa = placa;
    }

    public DescripcionVehiculo consultarDescripcion(){
    return descripcionVehiculo;
    }

    public Placa consultarPlaca(){
        return placa;
    }

    public void modificarDescripcionVehiculo(){}
}
